package by.bsu.flowershop.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import by.bsu.flowershop.model.User;
import by.bsu.flowershop.dao.UserRepositoryDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService
{
  @Resource
  private UserRepositoryDao userRepositoryDao;

  private org.springframework.security.core.userdetails.User userdetails;

  public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
  {
    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;
    User User = getUserDetail( username );
    userdetails = new org.springframework.security.core.userdetails.User( User.getUsername(), User.getPassword(),
              enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities( User.getRole() ) );
    return userdetails;
  }

  private List<GrantedAuthority> getAuthorities( Long role )
  {
    List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
    if ( role.intValue() == 1 )
    {
      authList.add( new SimpleGrantedAuthority( "ROLE_ADMIN" ) );
    }
    return authList;
  }

  private User getUserDetail( String username )
  {
    return userRepositoryDao.findByUsername( username );
  }
}
