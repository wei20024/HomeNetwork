package homeNetwork.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

public interface ConnectionProvider
{
  Connection connection() throws SQLException, NamingException;
}
