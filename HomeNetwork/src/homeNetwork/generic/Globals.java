package homeNetwork.generic;

import homeNetwork.generic.web.RegistryInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Globals
{
  public static final String APPLICATION_LOCAL_DATABASE_NAME = "homeServer";

  private static final Logger log = LogManager.getLogger();
  private static boolean initializing = false;
  private static boolean initialized = false;

  public static synchronized void initialSetup()
  {
    log.debug("initialSetup()");

    if (!initializing)
    {
      initializing = true;

      try
      {
        // Configuration
        Configuration.setApplicationLocalDatabaseName(APPLICATION_LOCAL_DATABASE_NAME);
        Configuration.setApplicationLocalDatabaseUsername("root");
        Configuration.setApplicationLocalDatabasePassword("Ieiunitas123");

        RegistryInitializer.init();
      }
      catch (Exception e)
      {
        log.error(e);
      }

      initialized = true;
    }
    else
    {
      while (!initialized)
      {
        log.debug("...waiting for another thread to finish initializing the Globals. ");
        try
        {
          Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
          log.error(e);
        }
      }
    }
  }
}
