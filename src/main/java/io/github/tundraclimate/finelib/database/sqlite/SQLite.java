package io.github.tundraclimate.finelib.database.sqlite;

import io.github.tundraclimate.finelib.FineLib;
import org.jetbrains.annotations.NotNull;

import java.sql.*;

/**
 * SQLite connect
 */
public final class SQLite {
    private final String dbname;
    private Connection connect = null;
    private Statement state = null;
    private PreparedStatement preState = null;

    public SQLite(@NotNull final String dbname) {
        this.dbname = dbname;
    }

    /**
     * connect Database
     */
    public void connectSQLite() {
        try {
            Class.forName("org.sqlite.JDBC");
            if (!FineLib.getPlugin().getDataFolder().exists())
                FineLib.getPlugin().getDataFolder().mkdirs();
            this.connect = DriverManager.getConnection("jdbc:sqlite:" + ".\\plugins\\" + FineLib.getPlugin().getName() + "\\" + dbname);
            this.state = connect.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wrapping executeUpdate
     *
     * @param sql SQL code
     * @throws SQLException SQLException
     */
    public void executeUpdate(@NotNull String sql) throws SQLException {
        state.executeUpdate(sql);
    }

    /**
     * Wrapping executeQuery
     *
     * @param sql SQL code
     * @return Query
     * @throws SQLException SQLException
     */
    public ResultSet executeQuery(@NotNull String sql) throws SQLException {
        return state.executeQuery(sql);
    }

    /**
     * prepare State Wrap
     *
     * @param sql SQL code
     * @return Statement
     * @throws SQLException SQLException
     */
    public PreparedStatement prepareStatement(@NotNull String sql) throws SQLException {
        return this.preState = connect.prepareStatement(sql);
    }

    /**
     * state getter
     *
     * @return state
     */
    public Statement getState() {
        return state;
    }

    /**
     * check Table
     *
     * @param table Table to check
     * @return Does it exist
     */
    public boolean hasTable(@NotNull String table) {
        try {
            ResultSet rs = state.executeQuery(
                    "SELECT COUNT(*) FROM sqlite_master WHERE TYPE='table' AND name='" + table + "'"
            );
            if (rs.getInt(1) != 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * check ContainValue
     * @param table checking table
     * @param column checking column
     * @param value checking value
     * @return Contain
     */
    public boolean containValue(String table, String column, String value) {
        boolean bool = false;
        try {
            ResultSet rs = state.executeQuery(
                    "SELECT COUNT(*) FROM "+ table +" WHERE "+ column +" ='" + value + "'"
            );
            bool = rs.getInt(1) != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bool;
    }

    /**
     * disconnect Database
     */
    public void disconnectSQLite() {

        try {
            if (connect != null) {
                connect.close();
            }
            if (state != null) {
                state.close();
            }
            if (preState != null) {
                preState.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * DataBase Name getter
     * @return Database fileName
     */
    public String getDbname() {
        return dbname;
    }
}
