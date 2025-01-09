import java.util.Scanner;

public class BanglaFlashcardApp {
    public static void main(String[] args) {
        BanglaFlashcardManager manager = new BanglaFlashcardManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Learn Bangla Flashcards ===");
            System.out.println("1. Create Deck");
            System.out.println("2. View Decks");
            System.out.println("3. Study Deck");
            System.out.println("4. Quiz Yourself");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manager.createDeck(scanner);
                    break;
                case 2:
                    manager.viewDecks();
                    break;
                case 3:
                    manager.studyDeck(scanner);
                    break;
                case 4:
                    manager.quizDeck(scanner);
                    break;
                case 5:
                    System.out.println("Shubho Bidai! (Goodbye!)");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
