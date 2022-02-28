package com.tundra.finelib.database.sqlite;

import com.tundra.finelib.FineLib;

import javax.annotation.Nonnull;
import java.sql.*;

/**
 * SQLite connect
 */
public class SQLite {
    private Connection connect = null;
    private Statement state = null;
    private PreparedStatement preState = null;

    /**
     * connect Database
     * @param dbname DatabaseName
     */
    public void connectSQLIte(@Nonnull final String dbname) {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connect = DriverManager.getConnection("jdbc:sqlite:" + ".\\plugins\\" + FineLib.getPlugin().getName() + "\\" + dbname);
            this.state = connect.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wrapping executeUpdate
     * @param sql SQL code
     * @throws SQLException SQLException
     */
    public void executeUpdate(@Nonnull String sql) throws SQLException {
        state.executeUpdate(sql);
    }

    /**
     * Wrapping executeQuery
     * @param sql SQL code
     * @throws SQLException SQLException
     * @return Query
     */
    public ResultSet executeQuery(@Nonnull String sql) throws SQLException {
        return state.executeQuery(sql);
    }

    /**
     * prepare State Wrap
     * @param sql SQL code
     * @return Statement
     * @throws SQLException SQLException
     */
    public PreparedStatement prepareStatement(@Nonnull String sql) throws SQLException {
        return this.preState = connect.prepareStatement(sql);
    }

    /**
     * state getter
     * @return state
     */
    public Statement getState() {
        return state;
    }

    /**
     * check Table
     * @param table Table to check
     * @return Does it exist
     */
    public boolean hasTable(@Nonnull String table) {
        try {
            ResultSet rs = state.executeQuery(
                    "SELECT COUNT(*) FROM sqlite_master WHERE TYPE='table' AND name='" + table + "'"
            );
            if (rs.getInt(1) == 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
            if (preState != null){
                preState.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
