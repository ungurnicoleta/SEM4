package Service;

import Domain.Client;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class ClientServiceClient implements ClientService {
    @Autowired
    private ClientService clientService;
    @Override
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @Override
    public void add(Client client) {
        clientService.add(client);
    }

    @Override
    public void remove(Long id) {
        clientService.remove(id);
    }

    @Override
    public void update(Client client) {
        clientService.update(client);
    }

    @Override
    public Set<Client> filterClientsByName(String keyword) {
        return clientService.filterClientsByName(keyword);
    }
}
