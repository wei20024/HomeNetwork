package homeNetwork.generic.web;

import homeNetwork.generic.Globals;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class GlobalsInitializer implements ServletContextListener
{
  @Override
  public void contextDestroyed(ServletContextEvent arg0)
  {
    // do nothing
  }

  @Override
  public void contextInitialized(ServletContextEvent arg0)
  {
    Globals.initialSetup();
  }
}
