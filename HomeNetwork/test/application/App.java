package application;

import java.util.List;

import homeNetwork.model.IpRecord;
import homeNetwork.model.User;
import homeNetwork.utils.HibernateUtil;

import org.hibernate.Session;

public class App
{
  public static void main(String[] args)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    User user = new User();
    user.setUsername("username");
    user.setEmail("example@email.com");
    user.setPassword("paswword");
    user.setPreferredFirstName("preferred name");
    session.save(user);
    session.getTransaction().commit();

    IpRecord ipRec = new IpRecord();
    ipRec.setIp("10.1.8.112");
    ipRec.setUser(user);
    session.save(ipRec);
    session.getTransaction().commit();

    List<IpRecord> recs = session.createCriteria(IpRecord.class).list();
    if (recs.size() > 0)
    {
      System.out.print("Hey, it worked!");

      for (IpRecord rec : recs)
      {
        System.out.print("\n" + rec.toString());
      }
    }
  }
}

