package by.bsu.flowershop.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.Locale;

@Controller
public class CommonPageController
{
  private final Logger logger = Logger.getLogger( CommonPageController.class );

  @RequestMapping( value = { "/" } )
  public String welcome()
  {
    return "welcome";
  }

  @RequestMapping( value = { "/welcome" } )
  public ModelAndView getLoginForm( @RequestParam( required = false ) String authFailed, String logout )
  {
    Locale.setDefault( Locale.ENGLISH );
    String message = "";
    if ( authFailed != null )
    {
      message = "Invalid username or password, try again !";
    }
    else
    {
      if ( logout != null )
      {
        message = "Logged Out successfully !";
      }
    }
    logger.info( message );
    return new ModelAndView( "welcome", "message", message );
  }
}
