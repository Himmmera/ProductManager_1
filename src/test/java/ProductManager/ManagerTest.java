package ProductManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ManagerTest {
    @Test
    public void addBookTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Sherlock Holmes and Dr. Watson", 100, "A.C.Doyle");
        Book book2 = new Book(2, "Gone with the Wind", 200, "M.Mitchell");
        Book book3 = new Book(3, "Jane Eyre", 300, "Charlotte Bronte");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2,book3};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void addSmartphoneTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Smartphone smartphone1 = new Smartphone(11, "Samsung S21", 515, "Samsung");
        Smartphone smartphone2 = new Smartphone(12, "Samsung S22", 212, "Samsung");
        Smartphone smartphone3 = new Smartphone(13, "Samsung S20", 474, "Samsung");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1, smartphone2,smartphone3};
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void addSmartphoneAndBookTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Smartphone smartphone1 = new Smartphone(11, "Samsung S21", 515, "Samsung");
        Smartphone smartphone2 = new Smartphone(12, "Samsung S22", 212, "Samsung");
        Book book1 = new Book(1, "Sherlock Holmes and Dr. Watson", 100, "A.C.Doyle");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(book1);
        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1, smartphone2,book1};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeByIdTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Sherlock Holmes and Dr. Watson", 100, "A.C.Doyle");
        Book book2 = new Book(2, "Gone with the Wind", 200, "M.Mitchell");
        Book book3 = new Book(3, "Jane Eyre", 300, "Charlotte Bronte");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        repo.removeById(2);
        Product[] actual = repo.findAll();
        Product[] expected = {book1,book3};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchWhenOneResultTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Sherlock Holmes and Dr. Watson", 100, "A.C.Doyle");
        Book book2 = new Book(2, "Gone with the Wind", 200, "M.Mitchell");
        Book book3 = new Book(3, "Jane Eyre", 300, "Charlotte Bronte");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Jane Eyre");
        Product[] expected = {book3};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchResultTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Sherlock Holmes and Dr.Watson", 100, "A.C.Doyle");
        Book book2 = new Book(2, "Gone with the Wind", 200, "M.Mitchell");
        Book book3 = new Book(3, "Jane Eyre", 300, "Charlotte Bronte");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Sherlock Holmes and Dr.Watson");
        Product[] expected = {book1};
        Assertions.assertArrayEquals(expected, actual);
    }


}
