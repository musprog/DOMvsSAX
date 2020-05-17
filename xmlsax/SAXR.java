package xmlsax;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * The SAXR class is for parsing the XML document and add its data to ArrayList
 * @author Mostafa
 */
public class SAXR extends DefaultHandler {

    /**
     * @see Book
     */
    private Book book;
    private String temp;
    private ArrayList<Book> bookList = new ArrayList<>();

    /**
     * Root elements
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    /**
     * Where the XML attributes can be fetched
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        temp = "";// resetting the String
        if (qName.equalsIgnoreCase("book")) {
            book = new Book();
            book.setCategory(attributes.getValue("category"));
            System.out.println(bookList.size() + "." + qName + ": " + attributes.getValue("category"));
        }
    }

    /**
     * Since the data in the Buffer it's time to save it
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("book")) {
            bookList.add(book);
        } else if (qName.equalsIgnoreCase("title")) {
            book.setTitle(temp);
        } else if (qName.equalsIgnoreCase("author")) {
            book.setAuthor(temp);
        } else if (qName.equalsIgnoreCase("year")) {
            book.setYear(temp);
        } else if (qName.equalsIgnoreCase("price")) {
            book.setPrice(temp);
        }
    }

    /**
     * Buffer the text data from the XML
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        temp = new String(ch, start, length);
    }

    /**
     * @param index for getting an item for the bookList
     */
    public void printBookInfo(int index) {
        if (index <= bookList.size()) {
            Book b = bookList.get(index);
            System.out.println(index + ".book:" + b.getCategory() + "\n title:" + b.getTitle()
                    + "\n author:" + b.getAuthor() + "\n year:" + b.getYear() + "\n price:" + b.getPrice());
        } else {
            System.out.println("Not such a book!");
        }
    }
}
