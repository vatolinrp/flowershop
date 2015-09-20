package by.bsu.flowershop.mongodb.repositories;

import java.util.List;

public interface LogRepositoryDao
{
    void setLogMessage(String message);

    void setLogMessages(List<String> messages);
}
