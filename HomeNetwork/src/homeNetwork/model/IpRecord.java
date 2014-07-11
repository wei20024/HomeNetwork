package homeNetwork.model;

import java.sql.Timestamp;


public class IpRecord
{
  private Long key;
  private String ip;
  private User user;
  private Timestamp created;

  public IpRecord()
  {
    key = -1l;
    ip = "";
    user = null;
    created = new Timestamp(System.currentTimeMillis());
  }

  private IpRecord(IpRecord ob)
  {
    this.key = ob.key;
    this.ip = ob.ip;
    this.user = ob.user;
    this.created = ob.created;
  }

  public IpRecord copy(IpRecord ob)
  {
    return new IpRecord(ob);
  }



  //---------------------------------------------------------------------------
  //  GETTERS/SETTERS
  //---------------------------------------------------------------------------

  public Long getKey()
  {
    return key;
  }

  public void setKey(Long key)
  {
    this.key = key;
  }

  public String getIp()
  {
    return ip;
  }

  public void setIp(String ip)
  {
    this.ip = ip;
  }

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  public Timestamp getCreated()
  {
    return created;
  }

  public void setCreated(Timestamp created)
  {
    this.created = created;
  }



  //---------------------------------------------------------------------------
  //   HASHCODE, EQUALS, & toSTRING
  //---------------------------------------------------------------------------

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ip == null) ? 0 : ip.hashCode());
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (obj == null)
    {
      return false;
    }
    if (getClass() != obj.getClass())
    {
      return false;
    }
    IpRecord other = (IpRecord)obj;
    if (ip == null)
    {
      if (other.ip != null)
      {
        return false;
      }
    }
    else if (!ip.equals(other.ip))
    {
      return false;
    }
    if (key == null)
    {
      if (other.key != null)
      {
        return false;
      }
    }
    else if (!key.equals(other.key))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "IpRecord [key=" + key + ", ip=" + ip + ", user=" + user + ", created=" + created + "]";
  }
}
