package Service;

import Domain.Client;

import java.util.List;
import java.util.Set;

public interface ClientService {

    List<Client> findAll();

    void add(Client client);

    void remove(Long id);

    void update(Client client);

    Set<Client> filterClientsByName(String keyword);
}
