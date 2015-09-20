package by.bsu.flowershop.mongodb.repositories;

import by.bsu.flowershop.mongodb.domain.User;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class UserRepositoryDaoImpl implements UserRepositoryDao
{

    @Override
    public User findByUsername(String username)
    {

        ServerAddress serverAddress = new ServerAddress("127.6.49.4",27017);
        MongoCredential credential = MongoCredential.createCredential("admin","flowers","NfAc-CBXGWN9".toCharArray());

        MongoClient mongoClient = new MongoClient(serverAddress, Arrays.asList(credential));
        MongoDatabase db = mongoClient.getDatabase("flowers");

        final User user = new User();

        FindIterable<Document> iterable = db.getCollection("USERS").find(eq("LOGIN", username));
        iterable.forEach(new Block<Document>()
        {
            @Override
            public void apply(final Document document)
            {
                user.setName(document.getString("FIRSTNAME"));
                user.setSurname(document.getString("LASTNAME"));
                user.setPassword(document.getString("PASS"));
                user.setUsername(document.getString("LOGIN"));
                user.setId(document.getLong("USER_ID"));
                user.setRole(document.getLong("ROLE"));
            }
        });
        return user;
    }

}
