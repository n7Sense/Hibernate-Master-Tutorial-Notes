package org.hibernate.engine.jdbc.connections.spi;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public abstract interface JdbcConnectionAccess  extends Serializable
{
  public abstract Connection obtainConnection()
    throws SQLException;
  
  public abstract void releaseConnection(Connection paramConnection)
    throws SQLException;
  
  public abstract boolean supportsAggressiveRelease();
}
