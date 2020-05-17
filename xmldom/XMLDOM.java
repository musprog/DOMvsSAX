
package xmldom;

import java.util.Scanner;

/**
 * The main class to get user input to modify the XML document 
 * @see CRUD the class contain all the read, create, update and delete functions.
 * (http://docs.oracle.com/javase/tutorial/jaxp/dom/index.html)
 * @author Mostafa
 */
public class XMLDOM {

    private static boolean run;
    private static Scanner in;
    private static int index;
    private static CRUD crud;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        crud = new CRUD();
        in = new Scanner(System.in);
        run = true;
        do {
            crud.read();
            System.out.println("Enter an option? C R U D or Q");
            char option = in.next().charAt(0);
            option = Character.toUpperCase(option);
            if (option == 'R') {
                crud.read();
            }
            if (option == 'C') {
                crud.create(userInput());
            }
            if (option == 'U') {
                System.out.println("Enter the book number:");
                index = in.nextInt();
                crud.update(userInput(), index);
            }
            if (option == 'D') {
                System.out.println("Enter the book number:");
                index = in.nextInt();
                crud.delete(index);
            } else if (option == 'Q') {
                run = false;
            }
        } while (run);

    }
 
    /**
     * To get every single data for a book which will be later updated or added.
     * @return a book object
     * @see Book
     */
    public static Book userInput() {
        String category, title, author, year, price;
        System.out.println("Enter a category:");
        category = in.nextLine();

        System.out.println("Enter a title:");
        title = in.nextLine();

        System.out.println("Enter an author:");
        author = in.nextLine();

        System.out.println("Enter an year:");
        year = in.nextLine();

        System.out.println("Enter an price:");
        price = in.nextLine();

        Book book = new Book(category, title, author, year, price);

        return book;
    }
}
