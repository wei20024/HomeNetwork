package homeNetwork.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean
@RequestScoped
public class LoginHandler
{
  private static Logger log = LogManager.getLogger(LoginHandler.class);
  private String username;
  private String password;

  public LoginHandler()
  {
    init();
  }

  public void init()
  {
    reset();
  }

  private void reset()
  {
    username = "";
    password = "";
  }


  //---------------------------------------------------------------------------
  //  A C T I O N
  //---------------------------------------------------------------------------

  public String login()
  {
    return "index.xhtml";
  }


  //---------------------------------------------------------------------------
  //  S T A N D A R D  G E T T E R S / S E T T E R S
  //---------------------------------------------------------------------------

  public String getUsername()
  {
    return this.username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getPassword()
  {
    return this.password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }
}
