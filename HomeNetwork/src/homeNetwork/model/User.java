package homeNetwork.model;

import java.sql.Timestamp;

public class User
{
  private Long key;
  private String preferredFirstName;
  private String username;
  private String password;
  private String email;
  private Timestamp created;

  public User()
  {
    key = -1l;
    preferredFirstName = "";
    username = "";
    password = "";
    email = "";
    created = new Timestamp(System.currentTimeMillis());
  }

  private User(User ob)
  {
    this.key = ob.key;
    this.preferredFirstName = ob.preferredFirstName;
    this.username = ob.preferredFirstName;
    this.password = ob.password;
    this.created = ob.created;
  }

  public User copy(User ob)
  {
    return new User(ob);
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

  public String getPreferredFirstName()
  {
    return preferredFirstName;
  }

  public void setPreferredFirstName(String preferredFirstName)
  {
    this.preferredFirstName = preferredFirstName;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
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
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    result = prime * result + ((preferredFirstName == null) ? 0 : preferredFirstName.hashCode());
    result = prime * result + ((username == null) ? 0 : username.hashCode());
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
    User other = (User)obj;
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
    if (preferredFirstName == null)
    {
      if (other.preferredFirstName != null)
      {
        return false;
      }
    }
    else if (!preferredFirstName.equals(other.preferredFirstName))
    {
      return false;
    }
    if (username == null)
    {
      if (other.username != null)
      {
        return false;
      }
    }
    else if (!username.equals(other.username))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "User [key=" + key + ", preferredFirstName=" + preferredFirstName + ", username=" + username + "]";
  }
}
