package by.bsu.flowershop.model.mongodb;

import java.util.List;

public interface RemoteLogRepositoryDao
{
    void setLogMessage(String message);

    void setLogMessages(List<String> messages);
}
