import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BanglaFlashcardManager {
    private List<BanglaDeck> decks = new ArrayList<>();

    public void createDeck(Scanner scanner) {
        System.out.print("Enter deck name (e.g., 'Basic Bangla Words'): ");
        String name = scanner.nextLine();
        BanglaDeck newDeck = new BanglaDeck(name);

        System.out.println("Now, add flashcards to the deck.");
        String choice;
        do {
            System.out.print("Enter Bangla word: ");
            String banglaWord = scanner.nextLine();
            System.out.print("Enter English meaning: ");
            String englishMeaning = scanner.nextLine();

            newDeck.addCard(banglaWord, englishMeaning);

            System.out.print("Add another flashcard? (yes/no): ");
            choice = scanner.nextLine().trim().toLowerCase();
        } while (choice.equals("yes"));

        decks.add(newDeck);
        System.out.println("Deck \"" + name + "\" created successfully!");
    }

    public void viewDecks() {
        if (decks.isEmpty()) {
            System.out.println("No decks available.");
            return;
        }
        System.out.println("\nAvailable Decks:");
        for (int i = 0; i < decks.size(); i++) {
            System.out.println((i + 1) + ". " + decks.get(i).getName());
        }
    }

    public void studyDeck(Scanner scanner) {
        BanglaDeck deck = selectDeck(scanner);
        if (deck == null) return;
        deck.study();
    }

    public void quizDeck(Scanner scanner) {
        BanglaDeck deck = selectDeck(scanner);
        if (deck == null) return;
        deck.quiz(scanner);
    }

    private BanglaDeck selectDeck(Scanner scanner) {
        viewDecks();
        if (decks.isEmpty()) return null;

        System.out.print("Select a deck by number: ");
        int deckNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (deckNumber < 1 || deckNumber > decks.size()) {
            System.out.println("Invalid choice.");
            return null;
        }
        return decks.get(deckNumber - 1);
    }
}
