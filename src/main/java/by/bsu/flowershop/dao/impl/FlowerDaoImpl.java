package by.bsu.flowershop.dao.impl;

import by.bsu.flowershop.dao.FlowerDao;
import by.bsu.flowershop.model.Flower;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FlowerDaoImpl extends CommonRepositoryDao implements FlowerDao
{
  @Override
  public List<Flower> getAllTypes()
  {
    final List<Flower> list = new ArrayList<Flower>();
    MongoDatabase mongoDatabase = getDatabase();
    FindIterable<Document> iterable = mongoDatabase.getCollection( "FLOWERS" ).find();
    iterable.forEach( new Block<Document>()
      {
        @Override
        public void apply( final Document document )
        {
          Flower flower = new Flower();
          flower.setName( document.getString( "NAME" ) );
          flower.setCost( document.getLong( "COST" ) );
          flower.setInfo( document.getString( "INFO" ) );
          flower.setImgUrl( document.getString( "IMG_URL" ) );
          flower.setFlowerCode( document.getString( "CODE" ) );
          ObjectId id = ( ObjectId )document.get( "_id" );
          flower.setId( id.toString() );
          list.add( flower );
        }
      });
    return list;
  }
}
