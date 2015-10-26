package by.bsu.flowershop.model.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;

public class CommonRepositoryDao
{
    protected MongoDatabase getDatabase()
    {
        ServerAddress serverAddress = new ServerAddress("127.6.49.4", 27017);
        MongoCredential credential = MongoCredential.createCredential("admin", "flowers", "NfAc-CBXGWN9".toCharArray());

        MongoClient mongoClient = new MongoClient(serverAddress, Arrays.asList(credential));
        return mongoClient.getDatabase("flowers");
    }
}
