package homeNetwork.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil
{
  private static final Logger log = LogManager.getLogger(HibernateUtil.class);
  private static final SessionFactory sessionFactory = buildSessionFactory();

  private static SessionFactory buildSessionFactory() {
      try
      {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        // Create the SessionFactory from hibernate.cfg.xml
        return config.buildSessionFactory(serviceRegistry);

      }
      catch (Throwable ex)
      {
        // Make sure you log the exception, as it might be swallowed
        log.error("Initial SessionFactory creation failed.", ex);
        throw new ExceptionInInitializerError(ex);
      }
  }

  public static SessionFactory getSessionFactory()
  {
    return sessionFactory;
  }

  public static void shutdown()
  {
    // Close caches and connection pools
    getSessionFactory().close();
  }
}
