package by.bsu.flowershop.mongodb.repositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Date;

@Repository
public class LogRepositoryDaoImpl implements LogRepositoryDao
{
    @Override
    public void setLogMessage(String message)
    {

        ServerAddress serverAddress = new ServerAddress("127.6.49.4",27017);
        MongoCredential credential = MongoCredential.createCredential("admin","flowers","NfAc-CBXGWN9".toCharArray());

        MongoClient mongoClient = new MongoClient(serverAddress, Arrays.asList(credential));
        MongoDatabase db = mongoClient.getDatabase("flowers");

        MongoCollection mongoCollection = db.getCollection("LOGS");
        mongoCollection.insertOne(new Document().append("LOG_MESSAGE", message).append("LOG_TIME", (new Date()).toString()));
    }
}
