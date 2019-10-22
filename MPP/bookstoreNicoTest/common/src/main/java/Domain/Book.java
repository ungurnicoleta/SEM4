package Domain;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.Serializable;

public class Book extends BaseEntity<Long>  implements Serializable {
    private String author;
    private String title;
    private String ISBN;
    private float price;
    private Integer quantity;

    public Book(String aut, String title, String ISBN, float price, Integer quantity) {
        this.author = aut;
        this.title = title;
        this.ISBN = ISBN;
        this.price = price;
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + this.getId() + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public String toFileString() {
        return String.join(";", author, title, ISBN, String.valueOf(price), String.valueOf(quantity));
    }

    @Override
    public void writeXml(XMLStreamWriter writer) throws XMLStreamException {
        writer.writeStartElement("Book");
        writer.writeAttribute("id", getId().toString());

        writer.writeStartElement("author");
        writer.writeCharacters(getAuthor());
        writer.writeEndElement();

        writer.writeStartElement("title");
        writer.writeCharacters(getTitle());
        writer.writeEndElement();

        writer.writeStartElement("isbn");
        writer.writeCharacters(getISBN());
        writer.writeEndElement();

        writer.writeStartElement("price");
        writer.writeCharacters(Float.toString(getPrice()));
        writer.writeEndElement();

        writer.writeStartElement("quantity");
        writer.writeCharacters(Integer.toString(getQuantity()));
        writer.writeEndElement();

        writer.writeEndElement();
    }
}
