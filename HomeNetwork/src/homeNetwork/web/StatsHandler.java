package homeNetwork.web;

import homeNetwork.model.IpRecord;
import homeNetwork.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

@ManagedBean
@SessionScoped
public class StatsHandler
{
  private static final Logger log = LogManager.getLogger(StatsHandler.class);

  private Session session;
  private List<IpRecord> records;

  public StatsHandler()
  {
    init();
  }

  public void init()
  {
    reset();
  }

  private void reset()
  {
    openSession();
    records = retrieveData();
    closeSession();
  }



  //---------------------------------------------------------------------------
  //   A C T I O N
  //---------------------------------------------------------------------------




  //---------------------------------------------------------------------------
  //  P R I V A T E
  //---------------------------------------------------------------------------

  private void openSession()
  {
    session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
  }

  private List<IpRecord> retrieveData()
  {
    List<IpRecord> records = session.createCriteria(IpRecord.class).list();
    return (records.isEmpty() ? new ArrayList<IpRecord>() : records);
  }

  private void closeSession()
  {
    session.disconnect();
  }



  //---------------------------------------------------------------------------
  //  S T A N D A R D   G E T T E R S / S E T T E R S
  //---------------------------------------------------------------------------

  public List<IpRecord> getRecords()
  {
    return records;
  }

  public void setRecords(List<IpRecord> records)
  {
    this.records = records;
  }
}
