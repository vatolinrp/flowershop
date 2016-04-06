package by.bsu.flowershop.dao.impl;

import by.bsu.flowershop.dao.UserRepositoryDao;
import by.bsu.flowershop.model.User;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class UserRepositoryDaoImpl extends CommonRepositoryDao implements UserRepositoryDao
{
  @Override
  public User findByUsername( String username )
  {
    MongoDatabase mongoDatabase = getDatabase();
    final User user = new User();
    FindIterable<Document> iterable = mongoDatabase.getCollection( "USERS" ).find( eq( "LOGIN", username ) );
    iterable.forEach( new Block<Document>()
      {
        @Override
        public void apply( final Document document )
        {
          user.setName( document.getString( "FIRSTNAME" ) );
          user.setSurname( document.getString( "LASTNAME" ) );
          user.setPassword( document.getString( "PASS" ) );
          user.setUsername( document.getString( "LOGIN" ) );
          user.setId( document.getLong( "USER_ID" ) );
          user.setRole( document.getLong( "ROLE" ) );
        }
      });
    return user;
  }
}
