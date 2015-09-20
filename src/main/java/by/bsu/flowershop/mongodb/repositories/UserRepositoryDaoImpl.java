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

import javax.annotation.Resource;
import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class UserRepositoryDaoImpl implements UserRepositoryDao
{
    @Resource
    private LogRepositoryDao logRepositoryDao;

    @Override
    public User findByUsername(String username)
    {

        ServerAddress serverAddress = new ServerAddress("127.6.49.4",27017);
        MongoCredential credential = MongoCredential.createCredential("admin","flowers","NfAc-CBXGWN9".toCharArray());

        MongoClient mongoClient = new MongoClient(serverAddress, Arrays.asList(credential));
        MongoDatabase db = mongoClient.getDatabase("flowers");

        final User user = new User();
        user.setName("notRostislav");

        FindIterable<Document> iterable = db.getCollection("USERS").find(eq("LOGIN", username));
        iterable.forEach(new Block<Document>()
        {
            @Override
            public void apply(final Document document)
            {
                logRepositoryDao.setLogMessage("in apply method");
                user.setName(document.getString("FIRSTNAME"));
                user.setSurname(document.getString("LASTNAME"));
                user.setPassword(document.getString("PASS"));
                user.setUsername(document.getString("LOGIN"));
                //user.setRole(document.getInteger("ROLE"));
            }
        });
        return user;
    }

}
