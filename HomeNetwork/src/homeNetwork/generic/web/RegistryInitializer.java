package homeNetwork.generic.web;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import homeNetwork.connection.LocalConnection;

public class RegistryInitializer
{
  private static final Logger log = LogManager.getLogger(RegistryInitializer.class);
  private static boolean initialized = false;

  // table names
  private static final String USER_TABLE = "users";
  private static final String IP_RECORD_TABLE = "ipRecord";

  public static void init()
  {

    if (!initialized)
    {
      try (Connection conn = LocalConnection.getConnection())
      {
        // order matters!
        createTableUsers(conn);
        createTableIpRecord(conn);
        initialized = true;
      }
      catch (Exception e)
      {
        initialized = false;
        log.error(e);
      }
    }
  }

  //---------------------------------------------------------------------------
  //  T A B L E S  (in alphabetical order, based on table name)
  //---------------------------------------------------------------------------

  private static void createTableIpRecord(Connection conn) throws SQLException
  {
    StringBuilder q = new StringBuilder();
    q.append("\nCREATE TABLE IF NOT EXISTS `" + IP_RECORD_TABLE + "` ");
    q.append("\n  ( ");
    q.append("\n     `key` BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT, ");
    q.append("\n     `ip` VARCHAR(255) DEFAULT NULL, ");
    q.append("\n     `userKey` BIGINT UNSIGNED DEFAULT NULL, ");
    q.append("\n     `created` TIMESTAMP, ");
    q.append("\n      FOREIGN KEY (`userKey`) REFERENCES `" + USER_TABLE + "`(`key`)");
    q.append("\n  ) ");
    q.append("\nengine=innodb ");
    q.append("\nDEFAULT charset=latin1");

    try (Statement st = conn.createStatement())
    {
      log.trace(q.toString());
      st.executeUpdate(q.toString());
    }
  }

  private static void createTableUsers(Connection conn) throws SQLException
  {
    StringBuilder q = new StringBuilder();
    q.append("\nCREATE TABLE IF NOT EXISTS `" + USER_TABLE + "` ");
    q.append("\n  ( ");
    q.append("\n     `key` BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT, ");
    q.append("\n     `preferredFirstName` VARCHAR(255) DEFAULT NULL, ");
    q.append("\n     `username` VARCHAR(255) DEFAULT NULL, ");
    q.append("\n     `password` VARCHAR(255) DEFAULT NULL, ");
    q.append("\n     `email` VARCHAR(255) DEFAULT NULL, ");
    q.append("\n     `created` TIMESTAMP ");
    q.append("\n  ) ");
    q.append("\nengine=innodb ");
    q.append("\nDEFAULT charset=latin1");

    try (Statement st = conn.createStatement())
    {
      log.trace(q.toString());
      st.executeUpdate(q.toString());
    }
  }
}
