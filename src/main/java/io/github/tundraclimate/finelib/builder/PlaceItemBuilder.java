package io.github.tundraclimate.finelib.builder;

import io.github.tundraclimate.finelib.FineLib;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * ItemPlaced Ground
 */
public final class PlaceItemBuilder {
    private final Location location;
    private final Location itemLocation;
    private final ItemStack holdItem;
    private ArmorStand holdStand;
    private final World worldOfItem;
    private final BukkitRunnable killRunnable = new BukkitRunnable() {
        @Override
        public void run() {
            if (hasItem()) {
                remove();
                cancel();
            }
        }
    };

    /**
     * @param holdItem placing Item
     * @param location placing Location
     * @param world    Placing World
     */
    public PlaceItemBuilder(@Nonnull ItemStack holdItem, @Nonnull Location location, @Nonnull World world) {
        this.holdItem = holdItem;
        this.location = location;
        this.itemLocation = location;
        this.itemLocation.setX(itemLocation.getX() - 0.08);
        this.itemLocation.setY(itemLocation.getY() - 0.65);
        this.itemLocation.setZ(itemLocation.getZ() + 0.44);
        this.worldOfItem = world;
        placeItem();
    }

    /**
     * init Item
     */
    private void placeItem() {
        holdStand = (ArmorStand) worldOfItem.spawnEntity(itemLocation, EntityType.ARMOR_STAND);
        holdStand.setInvulnerable(true);
        holdStand.setArms(true);
        holdStand.setVisible(false);
        holdStand.setGravity(true);
        Objects.requireNonNull(holdStand.getEquipment()).setItemInMainHand(holdItem);
        holdStand.setRightArmPose(new EulerAngle(-0.275, -95, 0));
    }

    /**
     * set PickUp able
     *
     * @param b able
     * @return this
     */
    public PlaceItemBuilder setItemPickUp(boolean b) {
        if (b) {
            holdStand.removeEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
            holdStand.removeEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.ADDING_OR_CHANGING);
        } else {
            holdStand.addEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.REMOVING_OR_CHANGING);
            holdStand.addEquipmentLock(EquipmentSlot.HAND, ArmorStand.LockType.ADDING_OR_CHANGING);
        }
        return this;
    }

    /**
     * Stand has Item
     *
     * @return Stand has Item
     */
    public boolean hasItem() {
        return Objects.requireNonNull(holdStand.getEquipment()).getItemInMainHand().getType() == Material.AIR;
    }

    /**
     * Remove Stand of Not has Item
     *
     * @return this
     */
    public PlaceItemBuilder setKillOfNotHoldItem() {
        this.killRunnable.runTaskTimer(FineLib.getPlugin(), 0, 5);
        return this;
    }

    /**
     * Item Remove
     */
    public void remove() {
        holdStand.remove();
    }

    /**
     * Stand set Marker
     *
     * @param b Stand is Marker
     * @return this
     */
    public PlaceItemBuilder setMarker(boolean b) {
        this.holdStand.setMarker(b);
        return this;
    }

    /**
     * set Receive Gravity
     *
     * @param b Stand Received Gravity
     * @return this
     */
    public PlaceItemBuilder setGravity(boolean b) {
        this.holdStand.setGravity(b);
        return this;
    }

    /**
     * HoldStand getter
     *
     * @return HoldStand
     */
    public ArmorStand getHoldStand() {
        return holdStand;
    }

    /**
     * HoldItem getter
     *
     * @return HoldItem
     */
    public ItemStack getHoldItem() {
        return holdItem;
    }

    /**
     * Location getter
     *
     * @return item Location
     */
    public Location getLocation() {
        return location;
    }
}
