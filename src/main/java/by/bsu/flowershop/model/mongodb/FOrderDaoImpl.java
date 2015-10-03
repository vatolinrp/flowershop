package by.bsu.flowershop.model.mongodb;

import by.bsu.flowershop.model.entities.FOrder;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class FOrderDaoImpl extends CommonRepositoryDao implements FOrderDao
{
    @Autowired
    private LogRepositoryDao logRepositoryDao;

    @Override
    public String create(FOrder order)
    {
        MongoDatabase mongoDatabase = getDatabase();
        String dateStr = new Date().toString();
        MongoCollection mongoCollection = mongoDatabase.getCollection("ORDERS");
        Document doc = new Document().append("CUSTOMER_NAME", order.getCustomerName())
                                     .append("CUSTOMER_PHONE", order.getCustomerPhone())
                                     .append("CREATION_DATE", new Date())
                                     .append("PLACEMENT", order.getPlacement())
                                     .append("COST", order.getCost())
                                     .append("ADDRESS", order.getAddress());
        mongoCollection.insertOne(doc);
        ObjectId id = (ObjectId)doc.get( "_id" );
        return id.toString();

    }

    @Override
    public List<FOrder> getAllOrders()
    {
        final List<FOrder> list = new ArrayList<FOrder>();
        MongoDatabase mongoDatabase = getDatabase();



        FindIterable<Document> iterable = mongoDatabase.getCollection("ORDERS").find();
        iterable.forEach(new Block<Document>()
        {
            @Override
            public void apply(final Document document)
            {
                FOrder order = new FOrder();
                order.setCustomerName(document.getString("CUSTOMER_NAME"));
                order.setCustomerPhone(document.getLong("CUSTOMER_PHONE"));
                order.setCreationDate(document.getDate("CREATION_DATE"));
                order.setPlacement(document.getString("PLACEMENT"));
                order.setCost(document.getInteger("COST"));
                order.setAddress(document.getString("ADDRESS"));
                list.add(order);
            }
        });
        return list;
    }
}
