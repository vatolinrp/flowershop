package by.bsu.flowershop.mongodb.repositories;

import by.bsu.flowershop.mongodb.domain.User;

public interface UserRepositoryDao
{
    User findByUsername(String username);
}
