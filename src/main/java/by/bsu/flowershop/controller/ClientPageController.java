package by.bsu.flowershop.controller;

import by.bsu.flowershop.model.ChoiceVO;
import by.bsu.flowershop.model.Flower;
import by.bsu.flowershop.model.Order;
import by.bsu.flowershop.model.PlacementVO;
import by.bsu.flowershop.model.TopRated;
import by.bsu.flowershop.service.FlowerService;
import by.bsu.flowershop.service.OrderService;
import by.bsu.flowershop.exceptions.ServiceException;
import by.bsu.flowershop.util.HtmlCreator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ClientPageController
{
  private final Logger logger = Logger.getLogger( ClientPageController.class );

  @Resource
  private OrderService orderService;

  @Resource
  private FlowerService flowerService;

  @RequestMapping( value = "/create-by-yourself", method = RequestMethod.GET )
  public String clearFields( Map<String, Object> model )
  {
    logger.info( "preparing empty bouquet..." );
    model.put( "possible_flowers", flowerService.getPossibleFlowersHtml() );
    model.put( "dynamicBouquet", flowerService.getDynamicBouquetHtml( null ) );
    model.put( "order", new Order() );
    return "client/order-add";
  }

  @RequestMapping(value = "/save-order", method = RequestMethod.POST )
  public String saveOrder( @ModelAttribute( "order" ) Order order, Map<String, Object> model )
  {
    logger.info("saving order...");
    orderService.create( order );
    model.put( "message", "Your order was successfully created. Expect a call" );
    return "welcome";
  }

  @RequestMapping(value = "/display-history", method = RequestMethod.POST )
  public String displayHistory(@ModelAttribute( "choiceVO" ) ChoiceVO choiceVO, Map<String, Object> model )
  {
    logger.info( "displaying history by phone(" + choiceVO.getPhoneNumber() + ")" );
    List<Flower> flowerList = flowerService.getAllTypes();
    ChoiceVO updatedChoiceVO = orderService.getHistoryByPhone( choiceVO.getPhoneNumber(), flowerList );
    model.put( "choiceVO", updatedChoiceVO );
    return "client/order-choose";
  }

  @RequestMapping(value = "/display-celebration/{cType}", method = RequestMethod.POST )
  public String displayCelebration( @ModelAttribute( "choiceVO" ) ChoiceVO choiceVO, @PathVariable String cType,
                                    Map<String, Object> model )
  {
    logger.info( "displaying top rated by celebration type(" + cType + ")" );
    List<Flower> flowerList = flowerService.getAllTypes();
    ChoiceVO updatedChoiceVO = orderService.getTopRated( cType, flowerList );
    model.put( "choiceVO", updatedChoiceVO );
    return "client/order-choose";
  }

  @RequestMapping( value = "/create-by-choosing", method = RequestMethod.GET )
  public String clearVariety( Map<String,Object> model )
  {
    logger.info( "creating new ChoiceVO object..." );
    model.put( "choiceVO", new ChoiceVO() );
    return "client/order-choose";
  }

  @RequestMapping( value = "/order-chosen/{placementId}", method = RequestMethod.GET )
  public String viewOrder( @PathVariable String placementId, Map<String, Object> model )
  {
    try
    {
      logger.info( "preparing chosen bouquet..." );
      model.put( "order", new Order() );
      model.put( "dynamicBouquet", flowerService.getDynamicBouquetHtml( orderService.findPlacement( placementId ) ) );
      model.put( "possible_flowers", flowerService.getPossibleFlowersHtml() );
    }
    catch( ServiceException ex )
    {
      return "client/error-client";
    }
    return "client/order-add";
  }
}
