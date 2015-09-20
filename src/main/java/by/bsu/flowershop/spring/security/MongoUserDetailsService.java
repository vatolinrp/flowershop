package by.bsu.flowershop.spring.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import by.bsu.flowershop.mongodb.repositories.LogRepositoryDao;
import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import by.bsu.flowershop.mongodb.repositories.UserRepositoryDao;


@Component
public class MongoUserDetailsService implements UserDetailsService
{

    @Resource
    private UserRepositoryDao userRepositoryDao;

    @Resource
    private LogRepositoryDao logRepositoryDao;

    private static final Logger logger = Logger.getLogger(MongoUserDetailsService.class);

    private org.springframework.security.core.userdetails.User userdetails;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        logRepositoryDao.setLogMessage("got username: " + username);
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        by.bsu.flowershop.mongodb.domain.User user = getUserDetail(username);
        logRepositoryDao.setLogMessage("got user detail: " + user.toString());

        userdetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(user.getRole()));
        return userdetails;
    }

    public List<GrantedAuthority> getAuthorities(Long role)
    {
        logRepositoryDao.setLogMessage("in get authorities method");
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        if (role.intValue() == 1)
        {
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            logRepositoryDao.setLogMessage("user has admin role");

        }
        else if (role.intValue() == 2)
        {
            authList.add(new SimpleGrantedAuthority("ROLE_CAMPAIGN"));
            logRepositoryDao.setLogMessage("user does not have admin role");
        }
        return authList;
    }

    public by.bsu.flowershop.mongodb.domain.User getUserDetail(String username)
    {
        by.bsu.flowershop.mongodb.domain.User user = userRepositoryDao.findByUsername(username);
        logRepositoryDao.setLogMessage("getting user detail...");
        return user;
    }

}
