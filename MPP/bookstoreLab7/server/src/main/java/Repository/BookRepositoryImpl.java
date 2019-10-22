package Repository;

import Domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;


import java.util.List;

@org.springframework.stereotype.Repository
public class BookRepositoryImpl implements Repository<Book> {
    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public List<Book> findAll() {
        String sql = "select * from book";
        return jdbcOperations.query(sql, (rs, rowNum) -> {
            Long id = rs.getLong("id");
            String author = rs.getString("author");
            String title = rs.getString("title");
            String ISBN = rs.getString("isbn");
            float price = rs.getFloat("price");
            int quantity = rs.getInt("quantity");

            Book book = new Book(author, title, ISBN, price, quantity);
            book.setId(id);
            return book;
        });
    }

    @Override
    public void save(Book book) {
        String sql = "insert into book (id, author, title, isbn, price, quantity) values (?,?,?,?,?,?)";
        jdbcOperations.update(sql, book.getId(), book.getAuthor(), book.getTitle(), book.getISBN(), book.getPrice(), book.getQuantity());
    }

    @Override
    public void update(Book book) {
        String sql = "update book set author=?, title=?, isbn=?, price=?, quantity=? where id=?";
        jdbcOperations.update(sql, book.getAuthor(), book.getTitle(), book.getISBN(), book.getPrice(), book.getQuantity(),
                              book.getId());
    }

    @Override
    public void deleteById(Long id) {
        String sql = "delete from book where id=?";
        jdbcOperations.update(sql, id);
    }
}
