package by.bsu.flowershop.configs.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import by.bsu.flowershop.model.entities.FUser;
import by.bsu.flowershop.model.mongodb.UserRepositoryDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MongoUserDetailsService implements UserDetailsService
{

    @Resource
    private UserRepositoryDao userRepositoryDao;

    private User userdetails;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        FUser FUser = getUserDetail(username);
        userdetails = new org.springframework.security.core.userdetails.User(FUser.getUsername(), FUser.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(FUser.getRole()));
        return userdetails;
    }

    public List<GrantedAuthority> getAuthorities(Long role)
    {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        if (role.intValue() == 1)
        {
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return authList;
    }

    public FUser getUserDetail(String username)
    {
        FUser FUser = userRepositoryDao.findByUsername(username);
        return FUser;
    }

}
