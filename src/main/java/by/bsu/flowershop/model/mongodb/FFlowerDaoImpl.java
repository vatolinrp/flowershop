package by.bsu.flowershop.model.mongodb;

import by.bsu.flowershop.model.entities.FFlower;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FFlowerDaoImpl extends CommonRepositoryDao implements FFlowerDao
{

    @Override
    public List<FFlower> getAllTypes()
    {
        final List<FFlower> list = new ArrayList<FFlower>();
        MongoDatabase mongoDatabase = getDatabase();
        FindIterable<Document> iterable = mongoDatabase.getCollection("FLOWERS").find();
        iterable.forEach(new Block<Document>()
        {
            @Override
            public void apply(final Document document)
            {
                FFlower flower = new FFlower();
                flower.setName(document.getString("NAME"));
                flower.setCost(document.getLong("COST"));
                flower.setInfo(document.getString("INFO"));
                flower.setImgUrl(document.getString("IMG_URL"));
                flower.setFlowerCode(document.getString("CODE"));
                ObjectId id = (ObjectId)document.get( "_id" );
                flower.setId(id.toString());
                list.add(flower);
            }
        });
        return list;
    }
}
