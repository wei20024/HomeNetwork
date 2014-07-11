package homeNetwork.generic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Configuration
{
  private static final Logger log = LogManager.getLogger(Configuration.class);

  /*  CONFIGURATION FIELDs */

  // database
  private static String applicationLocalDatabaseName = "";
  private static String applicationLocalDatabaseUsername = "";
  private static String applicationLocalDatabasePassword = "";


  //---------------------------------------------------------------------------
  //  G E T T E R S / S E T T E R S
  //---------------------------------------------------------------------------

  public static String getApplicationLocalDatabaseName()
  {
    return applicationLocalDatabaseName;
  }

  public static void setApplicationLocalDatabaseName(String applicationLocalDatabaseName)
  {
    Configuration.applicationLocalDatabaseName = applicationLocalDatabaseName;
    log.info("Setting Configuration.applicationLocalDatabaseName = " + applicationLocalDatabaseName);
  }

  public static String getApplicationLocalDatabaseUsername()
  {
    return applicationLocalDatabaseUsername;
  }

  public static void setApplicationLocalDatabaseUsername(String applicationLocalDatabaseUsername)
  {
    Configuration.applicationLocalDatabaseUsername = applicationLocalDatabaseUsername;
    log.info("Setting Configuration.applicationLocalDatabaseUsername = " + applicationLocalDatabaseUsername);
  }

  public static String getApplicationLocalDatabasePassword()
  {
    return applicationLocalDatabasePassword;
  }

  public static void setApplicationLocalDatabasePassword(String applicationLocalDatabasePassword)
  {
    Configuration.applicationLocalDatabasePassword = applicationLocalDatabasePassword;
    log.info("Setting Configuration.applicationLocalDatabasePassword = " + applicationLocalDatabasePassword);
  }
}
