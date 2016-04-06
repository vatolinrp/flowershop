package by.bsu.flowershop.dao.impl;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import java.util.Arrays;

public abstract class CommonRepositoryDao
{
  @Value( "${mongodb.host}" )
  private String host;

  @Value( "${mongodb.port}" )
  private String port;

  @Value( "${mongodb.username}" )
  private String username;

  @Value( "${mongodb.dbname}" )
  private String dbname;

  @Value ( "${mongodb.password}" )
  private String password;

  protected MongoDatabase getDatabase()
  {
    ServerAddress serverAddress = new ServerAddress( host, Integer.valueOf( port ) );
    MongoClient mongoClient;
    if( "127.0.0.1".equals( host ) )
    {
      mongoClient = new MongoClient( serverAddress );
    }
    else
    {
      MongoCredential credential = MongoCredential.createCredential( username, dbname, password.toCharArray());
      mongoClient = new MongoClient( serverAddress, Arrays.asList( credential ) );
    }
    return mongoClient.getDatabase( dbname );
  }
}
