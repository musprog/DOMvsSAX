
package xmldom;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * The class contain all the CRUD methods to modify the books.xml document 
 * @author Mostafa
 */
public class CRUD {

    private File file;
    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    private Document document;
    private NodeList nodeList;

    /**
     * Parse the XML document 
     */
    public void read() {
        try {
            file = new File("books.xml");
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());
            nodeList = document.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println(i + "-" + node.getNodeName() + ": " + element.getAttribute("category") + node.getTextContent());
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
        }
    }

    /**
     * To delete a selected element
     * @param index for element
     */
    public void delete(int index) {
        Element remove = (Element) document.getElementsByTagName("book").item(index);
        remove.getParentNode().removeChild(remove);
        document.normalize();
        rewriteDoc();
        System.out.println("removed " + remove.getAttribute("category"));
    }

    /**
     * To update an selected element 
     * @param book object for element data representation
     * @param index of the element 
     */
    public void update(Book book, int index) {

        Element update = (Element) document.getElementsByTagName("book").item(index);

        Node attr = update.getAttributeNode("category");
        attr.setTextContent(book.getCategory());

        NodeList title = update.getElementsByTagName("title");
        Node tit = title.item(0);
        tit.setTextContent(book.getTitle());

        NodeList author = update.getElementsByTagName("author");
        Node aut = author.item(0);
        aut.setTextContent(book.getAuthor());

        NodeList year = update.getElementsByTagName("year");
        Node yea = year.item(0);
        yea.setTextContent(book.getYear());

        NodeList price = update.getElementsByTagName("price");
        Node pri = price.item(0);
        pri.setTextContent(book.getPrice());

        rewriteDoc();
        System.out.println("updated " + update.getAttribute("category"));
    }

    /**
     * To add a new element 
     * @param book object for element data representation
     */
    public void create(Book book) {

        Element root = document.getDocumentElement();
        Element child = document.createElement("book");
        child.setAttribute("category", book.getCategory());
        root.appendChild(child);

        Element title = document.createElement("title");
        Text titleText = document.createTextNode(book.getTitle());
        title.appendChild(titleText);
        child.appendChild(title);

        Element author = document.createElement("author");
        Text authorText = document.createTextNode(book.getAuthor());
        author.appendChild(authorText);
        child.appendChild(author);

        Element year = document.createElement("year");
        Text yearText = document.createTextNode(book.getYear());
        year.appendChild(yearText);
        child.appendChild(year);

        Element price = document.createElement("price");
        Text priceText = document.createTextNode(book.getPrice());
        price.appendChild(priceText);
        child.appendChild(price);

        rewriteDoc();
        System.out.println("added " + child.getAttribute("category"));
    }

    /**
     * To rewrite the XML document after any modification 
     */
    public void rewriteDoc() {
        try {

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("books.xml"));
            transformer.transform(source, result);

        } catch (TransformerFactoryConfigurationError | IllegalArgumentException | TransformerException e) {
        }

    }
}
