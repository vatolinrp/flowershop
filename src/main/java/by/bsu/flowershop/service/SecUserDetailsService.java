package by.bsu.flowershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SecUserDetailsService //implements UserDetailsService
{

//    private MongoTemplate mongoTemplate;
//
//    public UserDetails loadUserByUsername(String username)
//            throws UsernameNotFoundException {
//        User user = getUserDetail(username);
//        System.out.println(username);
//        org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),true,true,true,true,getAuthorities(user.getRole()));
//        return userDetail;
//    }
//
//    @Autowired
//    public void setMongoTemplate(MongoTemplate mongoTemplate) {
//        this.mongoTemplate = mongoTemplate;
//    }
//
//    public List<GrantedAuthority> getAuthorities(Integer role) {
//        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
//        if (role.intValue() == 1) {
//            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
//            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        } else if (role.intValue() == 2) {
//            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }
//        return authList;
//    }
//
//    public User getUserDetail(String username){
//        MongoOperations mongoOperation = (MongoOperations)mongoTemplate;
//        User user = mongoOperation.findOne(
//                new Query(Criteria.where("username").is(username)),
//                User.class);
//        System.out.println(user.toString());
//        return user;
//    }

}
