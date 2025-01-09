import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BanglaDeck {
    private String name;
    private List<BanglaFlashcard> cards = new ArrayList<>();

    public BanglaDeck(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCard(String banglaWord, String englishMeaning) {
        cards.add(new BanglaFlashcard(banglaWord, englishMeaning));
    }

    public void study() {
        if (cards.isEmpty()) {
            System.out.println("No cards in this deck.");
            return;
        }

        System.out.println("\nStudying \"" + name + "\" deck:");
        for (BanglaFlashcard card : cards) {
            System.out.println("Bangla: " + card.getBanglaWord());
            System.out.println("English: " + card.getEnglishMeaning());
        }
    }

    public void quiz(Scanner scanner) {
        if (cards.isEmpty()) {
            System.out.println("No cards in this deck.");
            return;
        }

        System.out.println("\nQuizzing \"" + name + "\" deck:");
        int correct = 0;

        for (BanglaFlashcard card : cards) {
            System.out.print("What is the English meaning of \"" + card.getBanglaWord() + "\"? ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(card.getEnglishMeaning())) {
                System.out.println("Correct!");
                correct++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + card.getEnglishMeaning());
            }
        }

        System.out.println("Quiz complete! You got " + correct + "/" + cards.size() + " correct.");
    }
}
