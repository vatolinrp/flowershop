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
import java.util.List;

@Repository
public class LogRepositoryDaoImpl implements LogRepositoryDao
{
    @Override
    public void setLogMessage(String message)
    {
        MongoDatabase mongoDatabase = getDatabase();
        String dateStr = new Date().toString();
        MongoCollection mongoCollection = mongoDatabase.getCollection("LOGS");
        mongoCollection.insertOne(new Document().append("LOG_MESSAGE", message).append("LOG_TIME",dateStr));
    }

    @Override
    public void setLogMessages(List<String> messages)
    {
        MongoDatabase mongoDatabase = getDatabase();
        MongoCollection mongoCollection = mongoDatabase.getCollection("LOGS");
        String dateStr = new Date().toString();
        for(String message:messages)
        {
            mongoCollection.insertOne(new Document().append("LOG_MESSAGE", message).append("LOG_TIME",dateStr));
        }
    }

    private MongoDatabase getDatabase()
    {
        ServerAddress serverAddress = new ServerAddress("127.6.49.4", 27017);
        MongoCredential credential = MongoCredential.createCredential("admin", "flowers", "NfAc-CBXGWN9".toCharArray());

        MongoClient mongoClient = new MongoClient(serverAddress, Arrays.asList(credential));
        return mongoClient.getDatabase("flowers");
    }
}
