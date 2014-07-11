package homeNetwork.connection;

import homeNetwork.generic.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocalConnection implements ConnectionProvider
{
  private static final Logger log = LogManager.getLogger(LocalConnection.class);
  private static final String CONNECTION_DRIVER = "com.mysql.jdbc.Driver";
  private static final String CONNECTION_URL = "jdbc:mysql://localhost:62369/";

  public Connection connection() throws SQLException, NamingException
  {
    return getConnection();
  }

  public static Connection getConnection() throws SQLException, NamingException
  {
    try
    {
      Class.forName(CONNECTION_DRIVER).newInstance();
    }
    catch (Exception e)
    {
      // do nothing
    }

    if (Configuration.getApplicationLocalDatabaseName().isEmpty())
    {
      log.error("You must set Configuration.applicationLocalDatabaseName before"
          + " you can get a connection to the local database.  Returning null.");
      return null;
    }

    if (Configuration.getApplicationLocalDatabaseUsername().isEmpty())
    {
      log.error("You must set Configuration.applicationLocalDatabaseUsername before"
          + " you can get a connection to the local database.  Returning null.");
      return null;
    }

//    if (Configuration.getApplicationLocalDatabasePassword().isEmpty())
//    {
//      log.error("You must set Configuration.applicationLocalDatabasePassword before"
//          + " you can get a connection to the local database.  Returning null.");
//      return null;
//    }

    log.trace("Return connection to " + CONNECTION_URL + Configuration.getApplicationLocalDatabaseName());
    return DriverManager.getConnection(CONNECTION_URL + Configuration.getApplicationLocalDatabaseName(),
                                       Configuration.getApplicationLocalDatabaseUsername(),
                                       Configuration.getApplicationLocalDatabasePassword());
  }
}
