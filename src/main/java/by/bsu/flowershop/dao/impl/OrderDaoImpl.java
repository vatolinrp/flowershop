package by.bsu.flowershop.dao.impl;

import by.bsu.flowershop.dao.OrderDao;
import by.bsu.flowershop.model.Order;
import by.bsu.flowershop.model.TopRated;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static com.mongodb.client.model.Filters.eq;

@Repository
public class OrderDaoImpl extends CommonRepositoryDao implements OrderDao
{
  @Override
  public String create( Order order )
  {
    MongoDatabase mongoDatabase = getDatabase();
    MongoCollection mongoCollection = mongoDatabase.getCollection( "ORDERS" );
    Document doc = new Document().append( "CUSTOMER_NAME", order.getCustomerName() )
                                 .append( "CUSTOMER_PHONE", order.getCustomerPhone() )
                                 .append( "CREATION_DATE", new Date() )
                                 .append( "PLACEMENT", order.getPlacement() )
                                 .append( "COST", order.getCost() )
                                 .append( "ADDRESS", order.getAddress() )
                                 .append( "IS_DELETED", false );
    mongoCollection.insertOne( doc );
    ObjectId id = ( ObjectId )doc.get( "_id" );
    return id.toString();
  }

  @Override
  public List<Order> getAll()
  {
     final List<Order> list = new ArrayList<Order>();
     MongoDatabase mongoDatabase = getDatabase();
     FindIterable<Document> iterable = mongoDatabase.getCollection( "ORDERS" ).
       find( new BasicDBObject( "IS_DELETED", false ) );
     iterable.forEach( new Block<Document>()
       {
         @Override
         public void apply( final Document document )
         {
           Order order = new Order();
           order.setCustomerName( document.getString( "CUSTOMER_NAME" ) );
           order.setCustomerPhone( document.getLong( "CUSTOMER_PHONE" ) );
           order.setCreationDate( document.getDate( "CREATION_DATE" ) );
           order.setPlacement( document.getString( "PLACEMENT" ) );
           order.setCost( document.getInteger( "COST" ) );
           order.setAddress( document.getString( "ADDRESS" ) );
           ObjectId id = ( ObjectId )document.get( "_id" );
           order.setOrderId( id.toString() );
           list.add( order );
         }
       });
     return list;
    }

  @Override
  public Order getById( final String orderId )
  {
    MongoDatabase mongoDatabase = getDatabase();

    final Order order = new Order();
    FindIterable<Document> iterable = mongoDatabase.getCollection( "ORDERS" ).find(
      new BasicDBObject( "_id", new ObjectId( orderId ) ) );
    iterable.forEach( new Block<Document>()
      {
        @Override
        public void apply( final Document document )
        {
          order.setCustomerName(document.getString("CUSTOMER_NAME"));
          order.setCustomerPhone(document.getLong("CUSTOMER_PHONE"));
          order.setCreationDate(document.getDate("CREATION_DATE"));
          order.setPlacement(document.getString("PLACEMENT"));
          order.setCost(document.getInteger("COST"));
          order.setAddress(document.getString("ADDRESS"));
          order.setOrderId(document.get( "_id" ).toString());
        }
      });
    return order;
    }

  @Override
  public void deleteCompletely( List<String> ids )
  {
    MongoDatabase mongoDatabase = getDatabase();
    for(String id:ids)
    {
      mongoDatabase.getCollection( "ORDERS" ).deleteOne( eq( "_id", new ObjectId( id ) ) );
    }
  }

  @Override
  public void delete( List<String> ids )
  {
    MongoDatabase mongoDatabase = getDatabase();
    for( String id:ids )
    {
      mongoDatabase.getCollection( "ORDERS" ).updateOne( new Document( "_id", new ObjectId( id ) ),
        new Document( "$set", new Document( "IS_DELETED", true ) ) );
    }
  }

  @Override
  public List<Order> getHistoryByPhone( Long phoneNumber )
  {
    final List<Order> list = new ArrayList<Order>();
    MongoDatabase mongoDatabase = getDatabase();
    FindIterable<Document> iterable = mongoDatabase.getCollection( "ORDERS" ).
        find( new BasicDBObject( "CUSTOMER_PHONE", phoneNumber ) );
    iterable.forEach( new Block<Document>()
    {
      @Override
      public void apply( final Document document )
      {
        Order order = new Order();
        order.setCustomerName( document.getString( "CUSTOMER_NAME" ) );
        order.setCustomerPhone( document.getLong( "CUSTOMER_PHONE" ) );
        order.setCreationDate( document.getDate( "CREATION_DATE" ) );
        order.setPlacement( document.getString( "PLACEMENT" ) );
        order.setCost( document.getInteger( "COST" ) );
        order.setAddress( document.getString( "ADDRESS" ) );
        ObjectId id = ( ObjectId )document.get( "_id" );
        order.setOrderId( id.toString() );
        list.add( order );
      }
    });
    return list;
  }

  @Override
  public List<TopRated> getTopRated( final String celebrationType )
  {
    final List<TopRated> list = new ArrayList<TopRated>();
    MongoDatabase mongoDatabase = getDatabase();
    FindIterable<Document> iterable = mongoDatabase.getCollection( celebrationType ).find();
    iterable.forEach( new Block<Document>()
    {
      @Override
      public void apply( final Document document )
      {
        TopRated topRated = new TopRated();
        topRated.setPlacement( document.getString( "PLACEMENT" ) );
        topRated.setCost( document.getInteger( "COST" ) );
        topRated.setCelebrationType( celebrationType );
        ObjectId id = ( ObjectId )document.get( "_id" );
        topRated.setTrId( id.toString() );
        list.add( topRated );
      }
    });
    return list;
  }

  @Override
  public String getPlacementFromTopRated( String id )
  {
    MongoDatabase mongoDatabase = getDatabase();
    final String[] placement = new String[1];
    FindIterable<Document> iterable = mongoDatabase.getCollection( "VALENTINES_DAY" ).find(
      new BasicDBObject( "_id", new ObjectId( id ) ) );
    iterable.forEach( new Block<Document>()
    {
      @Override
      public void apply( final Document document )
      {
        placement[0] =  document.getString( "PLACEMENT" );
      }
    });
    if( placement[0] != null )
    {
      return placement[0];
    }
    iterable = mongoDatabase.getCollection( "MOTHERS_DAY" ).find(
        new BasicDBObject( "_id", new ObjectId( id ) ) );
    iterable.forEach( new Block<Document>()
    {
      @Override
      public void apply( final Document document )
      {
        placement[0] =  document.getString( "PLACEMENT" );
      }
    });
    if( placement[0] != null )
    {
      return placement[0];
    }
    iterable = mongoDatabase.getCollection( "WOMENS_DAY" ).find(
        new BasicDBObject( "_id", new ObjectId( id ) ) );
    iterable.forEach( new Block<Document>()
    {
      @Override
      public void apply( final Document document )
      {
        placement[0] =  document.getString( "PLACEMENT" );
      }
    });
    if( placement[0] != null )
    {
      return placement[0];
    }
    return null;
  }
}
