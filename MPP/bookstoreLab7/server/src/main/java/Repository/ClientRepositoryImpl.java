package Repository;

import Domain.Book;
import Domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.List;

public class ClientRepositoryImpl implements Repository<Client> {
    @Autowired
    private JdbcOperations jdbcOperations;
    @Override
    public List<Client> findAll() {
        String sql = "select * from client";
        return jdbcOperations.query(sql, (rs, rowNum) -> {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            String profession = rs.getString("profession");
            float pocketMoney = rs.getFloat("pocketmoney");
            int age = rs.getInt("age");

            Client client = new Client(name,age,pocketMoney,profession);
            client.setId(id);
            return client; });
    }

    @Override
    public void save(Client client) {
        String sql = "insert into client (id, name, age, pocketmoney, profession) values (?,?,?,?,?)";
        jdbcOperations.update(sql, client.getId(), client.getName(), client.getAge(), client.getPocketMoney(), client.getProfession());

    }

    @Override
    public void update(Client client) {
        String sql = "update client set name=?, age=?, pocketmoney=?, profession=? where id=?";
        jdbcOperations.update(sql, client.getId(), client.getName(), client.getAge(), client.getPocketMoney(), client.getProfession(),
                client.getId());

    }

    @Override
    public void deleteById(Long id) {
        String sql = "delete from client where id=?";
        jdbcOperations.update(sql, id);
    }
}
