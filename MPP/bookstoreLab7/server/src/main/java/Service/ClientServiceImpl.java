package Service;

import Domain.Book;
import Domain.Client;
import Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private Repository<Client> repository;

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Client client) {
        this.repository.save(client);
    }


    @Override
    public void remove(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public void update(Client client) {
        this.repository.update(client);
    }


    @Override
    public Set<Client> filterClientsByName(String keyword) {
        List<Client> allClients = this.repository.findAll();

        Set<Client> filteredClients = new HashSet<>(allClients);
        filteredClients.removeIf(book -> !book.getName().toLowerCase().contains(keyword.toLowerCase()));

        return filteredClients;
    }


}
