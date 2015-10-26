package by.bsu.flowershop.model.mongodb;

import by.bsu.flowershop.model.entities.FUser;
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
    public FUser findByUsername(String username)
    {
        MongoDatabase mongoDatabase = getDatabase();

        final FUser FUser = new FUser();

        FindIterable<Document> iterable = mongoDatabase.getCollection("USERS").find(eq("LOGIN", username));
        iterable.forEach(new Block<Document>()
        {
            @Override
            public void apply(final Document document)
            {
                FUser.setName(document.getString("FIRSTNAME"));
                FUser.setSurname(document.getString("LASTNAME"));
                FUser.setPassword(document.getString("PASS"));
                FUser.setUsername(document.getString("LOGIN"));
                FUser.setId(document.getLong("USER_ID"));
                FUser.setRole(document.getLong("ROLE"));
            }
        });
        return FUser;
    }

}
