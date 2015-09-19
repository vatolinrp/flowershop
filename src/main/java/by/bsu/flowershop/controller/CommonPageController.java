package by.bsu.flowershop.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.UnknownHostException;
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

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {

        boolean auth = false;
        try
        {
            MongoClient mongoClient = new MongoClient("127.6.49.4",27017);
            DB db = mongoClient.getDB("flowers");
            auth = db.authenticate("admin", "NfAc-CBXGWN9".toCharArray());
            if(auth)
            {
                DBCollection table = db.getCollection("ROLES");
                BasicDBObject document = new BasicDBObject();
                document.put("USER_ID", 1);
                document.put("ROLENAME", "ROLE_ADMIN");
                table.insert(document);

                DBCollection table1 = db.getCollection("USERS");
                BasicDBObject document1 = new BasicDBObject();
                document1.put("USER_ID", 1);
                document1.put("FIRSTNAME", "Rostislav");
                document1.put("LASTNAME", "Vatolin");
                document1.put("LOGIN", "1");
                document1.put("PASS", "1");
                table1.insert(document1);
            }
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }

        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        if(auth)
        {
            model.addObject("msg", "done");
        }
        else
        {
            model.addObject("msg", "not done");
        }

        return model;

    }
}
