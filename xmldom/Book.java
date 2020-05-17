package xmldom;

/**
 * The Book class represent a book element in the XML document with some getters
 * and setters
 *
 * @author Mostafa
 */
public class Book {

    String category;
    String title;
    String author;
    String year;
    String price;

    public Book(String category, String title, String author, String year, String price) {
        this.category = category;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
