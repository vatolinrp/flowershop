package by.bsu.flowershop.model.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class RemoteLogRepositoryDaoImpl extends CommonRepositoryDao implements RemoteLogRepositoryDao
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
}
