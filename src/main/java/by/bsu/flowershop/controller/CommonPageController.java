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
    private final Logger logger = Logger.getLogger(CommonPageController.class);

    @RequestMapping(value = { "/" })
    public String welcome()
    {
        logger.info("welcome page is shown!");
        return "welcome";
    }
}
