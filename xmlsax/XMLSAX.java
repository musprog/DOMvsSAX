package xmlsax;

import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 * http://docs.oracle.com/javase/tutorial/jaxp/sax/parsing.html
 */
/**
 * According to Oracle documentation, the Simple API for XML (SAX), an
 * event-driven, serial-access mechanism for accessing XML documents. The SAX is
 * useful for applications that required not more than transmit or reading XML
 * document. Using SAX make harder to visualize or modify the contents your XML
 * documents because of its event-driven model, SAX like any I/O streams useful
 * only for reading. To modify XML documents Domain Object Model (DOM) is
 * required, due to its larger memory usage and structure , DOM allow
 * application to access multiple data and not only serial access. DOM provides
 * us a complete CRUD functions to modify your XML document.
 */
/**
 * The main class with initiations for SAXParserFactory, SAXParser
 * @see ToDo_Modification some explanation to show alternatives for doing modification for an XML document.
 * @author Mostafa
 */
public class XMLSAX {

    private static Scanner in;
    private static int index;
    private static boolean run;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        /**
         * Create a "parser factory" for creating SAX parsers
         */
        SAXParserFactory spfac = SAXParserFactory.newInstance();
        /**
         * Now use the parser factory to create a SAXParser object
         */
        SAXParser sp = spfac.newSAXParser();
        /**
         * Create an instance of this class; it defines all the handler methods
         */
        SAXR r = new SAXR();
        /**
         * Finally, tell the parser to parse the input and notify the handler
         */
        sp.parse("Books.xml", r);
        run = true;
        do {// Retriving user input
            in = new Scanner(System.in);
            System.out.println("Enter an option? R for book details or Q");
            char option = in.next().charAt(0);
            option = Character.toUpperCase(option);//Constrain 
            if (option == 'R') {
                System.out.println("Enter the book number:");
                index = in.nextInt();
                r.printBookInfo(index);
            } else if (option == 'Q') {
                run = false;
            }
        } while (run);
    }
}
