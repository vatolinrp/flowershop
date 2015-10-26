package by.bsu.flowershop.model.mongodb;


import by.bsu.flowershop.model.entities.FUser;

public interface UserRepositoryDao
{
    FUser findByUsername(String username);
}
