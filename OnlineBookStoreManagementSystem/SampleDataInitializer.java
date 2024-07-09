package OnlineBookStoreManagementSystem;

public class SampleDataInitializer {
    public static void initialize(InventoryManager inventoryManager) {
        Book book1 = new Book(1, "Whispers of Time", "Elena Rutherford", "Science Fiction", 29500, 10);
        Book book2 = new Book(2, "Eternal Wanderer", "Maxwell Collins", "Science Fiction", 31200, 15);
        Book book3 = new Book(3, "Galactic Horizons", "Fiona Clarke", "Science Fiction", 23000, 20);
        Book book4 = new Book(4, "Mystic Shadows", "Olivia Hart", "Fantasy", 18700, 25);
        Book book5 = new Book(5, "Dragon's Embrace", "Liam Storm", "Fantasy", 12000, 30);
        Book book6 = new Book(6, "Enchanted Realms", "Ava Nightingale", "Fantasy", 10500, 50);
        Book book7 = new Book(7, "Silent Echoes", "Isabella Moore", "Mystery", 20000, 50);
        Book book8 = new Book(8, "Lost Labyrinth", "Noah Bennett", "Thriller", 10000, 100);
        Book book9 = new Book(9, "Hidden Truths", "Sophia Reed", "Non-Fiction", 8000, 60);
        Book book10 = new Book(10, "Whispering Winds", "James Blackwood", "Romance", 19200, 35);

        //data adding to array list
        inventoryManager.addBook(book1);
        inventoryManager.addBook(book2);
        inventoryManager.addBook(book3);
        inventoryManager.addBook(book4);
        inventoryManager.addBook(book5);
        inventoryManager.addBook(book6);
        inventoryManager.addBook(book7);
        inventoryManager.addBook(book8);
        inventoryManager.addBook(book9);
        inventoryManager.addBook(book10);
    }
}
