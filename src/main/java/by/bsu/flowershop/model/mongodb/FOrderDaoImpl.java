package by.bsu.flowershop.model.mongodb;

import by.bsu.flowershop.model.entities.FOrder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class FOrderDaoImpl extends CommonRepositoryDao implements FOrderDao
{
    @Autowired
    private LogRepositoryDao logRepositoryDao;

    @Override
    public void create(FOrder order)
    {
        MongoDatabase mongoDatabase = getDatabase();
        String dateStr = new Date().toString();
        MongoCollection mongoCollection = mongoDatabase.getCollection("ORDERS");
        Document doc = new Document().append("CUSTOMER_NAME", order.getCustomerName())
                                     .append("CUSTOMER_PHONE", order.getCustomerPhone())
                                     .append("CREATION_DATE", dateStr)
                                     .append("PLACEMENT", order.getPlacement())
                                     .append("COST", order.getCost())
                                     .append("ADDRESS", order.getAddress());
        mongoCollection.insertOne(doc);
        ObjectId id = (ObjectId)doc.get( "_id" );
        logRepositoryDao.setLogMessage(id.toString());
    }
}
