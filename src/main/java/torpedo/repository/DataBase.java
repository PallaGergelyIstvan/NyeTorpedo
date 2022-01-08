package torpedo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This is the database class.
 *
 * @author Palla Gergely
 */

public class DataBase {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:./db./test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "as";

    /**
     * The game starts.
     *
     */

    public static void config() {
        Connection conn = null;
        Statement stmt = null;
        int aaa = 0;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "CREATE TABLE   GameData " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " game INTEGER, " +
                    " win INTEGER, " +
                    " draw INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

            // STEP 4: Execute a query
            sql = "INSERT INTO GameData " + "VALUES (0, 'Ai1', 0, 0, 0)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO GameData " + "VALUES (1, 'Ai2', 0, 0, 0)";
            stmt.executeUpdate(sql);

            System.out.println("Created first two entry in the database...");

            // STEP 5: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                aaa++;
            } // nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Config finish!!!");
    }

   /**
    * The game starts.
    *
    */

   public static void newplayer(String player) {
        Connection conn = null;
        Statement stmt = null;
        int aaa = 0;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT id, name FROM GameData";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            boolean sea = false;
            int bigid  = 0;

            while (rs.next()) {
                // Retrieve by column name
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                // Processing data
                if (player.equals(name)) {
                    sea = true;
                } else if (bigid < id) {
                    bigid = id;
                }
            }

            // STEP 5: data entry if necessary
            if (sea == false) {
                sql = "INSERT INTO GameData " + "VALUES (" + bigid + 1 + ", '" + player + "', 0, 0, 0)";
                stmt.executeUpdate(sql);
            }

            // STEP 6: Clean-up environment
            rs.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                aaa++;
            } // nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }

    /**
     * The game starts.
     *
     */

    public static void endgame(String player, boolean wing, boolean drawg) {
        Connection conn = null;
        Statement stmt = null;
        int aaa = 0;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT id, name, game, win, draw FROM GameData WHERE name in ('Ai1')";
            ResultSet rs = stmt.executeQuery(sql);
            int id  = rs.getInt("id");
            String name = rs.getString("name");
            int game = rs.getInt("game");
            int win = rs.getInt("win");
            int draw = rs.getInt("draw");

            if (wing = true) {
                game = game++;
                win = win++;
                sql = "UPDATE GameData " + "SET game = " + game + ", win = " + win + " WHERE id in (" + id + ")";
                stmt.executeUpdate(sql);
            } else if (drawg = true) {
                game = game++;
                draw = draw++;
                sql = "UPDATE GameData " + "SET game = " + game + ", draw = " + draw + " WHERE id in (" + id + ")";
                stmt.executeUpdate(sql);
            } else {
                game = game++;
                sql = "UPDATE GameData " + "SET game = " + game + " WHERE id in (" + id + ")";
                stmt.executeUpdate(sql);
            }

            System.out.print("Játékos: " + name);
            System.out.print(", összes játék száma: " + game);
            System.out.print(", megnyert játékok száma: " + win);
            System.out.println(", döntetlen játékok száma: " + draw);

            rs.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                aaa++;
            } // nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }
}