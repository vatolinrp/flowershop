package by.bsu.flowershop.dao;

import by.bsu.flowershop.model.User;

public interface UserRepositoryDao
{
  User findByUsername( String username );
}
