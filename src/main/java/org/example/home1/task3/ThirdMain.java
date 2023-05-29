package org.example.home1.task3;

public class ThirdMain {

    public static void main(String[] args) {
        var library = new Library();

        var book1 = new Book("Lord of the Ring", "J. R. R. Tolkien", true);
        var book2 = new Book("The Little Prince", "A. de Saint-Exupery", true);
        var book3 = new Book("1984", "G. Orwell", false);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayAvailableBooks();
        System.out.println("-----------------------");

        System.out.println(library.searchByAuthor("G. Orwell"));
        System.out.println("-----------------------");

        library.removeBook(book2);
        library.displayAvailableBooks();
    }
}
