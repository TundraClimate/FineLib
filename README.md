# FineLib
FineLib is Spigot Library

# Features

FineLib is Spigot Convenient system Library  
***Will never be completed.***
---
## Implemented
### Events
- **AsyncChatAfterEvent** *Called after chat
  There is no content*
- **SignClickEvent** *Called by clicking on the sign*
- **EntityFallDamageEvent** *Called when an entity takes fall damage*
### Builders
- **ItemStackBuilder** *Simplified the operation of the item stack as a builder*
- **ColorStringBuilder** *Build ChatColors with builder*
- **InventoryBuilder** *Build Inventory*
- **PlaceItemBuilder** *Build Placeable Item*
### Server Addon
- **Distribute** *Distribute to Player*
- **PreItemStack** *Init able ItemStack*
### Others
- **Base64Converter** *Convert Base64*
- **HeadGenerator** *Build a McHead*
- **DataContainer** *persistentDataContainer simply*
- **Randomizer** *Create randomize getter*
- **Shaped / Shapeless RecipeModifier** *Recipe easy register*
- **SQLiteConnector** *SQLite Connect easily*

# Usage
Enter `FineLib.setPlugin(this)` in `onEnable()` of the plugin to be used.
```java
public class Your_Plugin extends JavaPlugin{
    @Override
    public void onEnable(){
        FineLib.setPlugin(this);
    }
    // your code...
}
```
This library is for **Minecraft 1.18**  

[Javadoc](https://tundraclimate.github.io/FineLib/javadoc/)
# Author
**Tundra_Climate**

# License

"FineLib" is under [MIT license](https://en.wikipedia.org/wiki/MIT_License).

