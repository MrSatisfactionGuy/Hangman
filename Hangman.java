
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {

        String word = "pizza";

        Scanner sc = new Scanner(System.in);
        ArrayList<Character> wordstate = new ArrayList<>();

        int wrongGuesses = 0;

        for (int i = 0; i < word.length(); i++) {
            wordstate.add('_');
        }
        System.out.println("* * * * * * * * * * * * *");
        System.out.println("Welcome to Hangman!");
        System.out.println("* * * * * * * * * * * * *");

        while (wrongGuesses < 6) {

            System.out.print(getHangmanArt(wrongGuesses));

            System.out.print("Word: ");

            for (char c : wordstate) {
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.println("Gebe eine Zeichen ein: ");
            char guess = sc.next().toLowerCase().charAt(0);

            if (word.indexOf(guess) >= 0) {
                System.out.println("Gut geraten!");

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordstate.set(i, guess);
                    }
                }

                if (!wordstate.contains('_'))
                {
                    System.out.print(getHangmanArt(wrongGuesses));
                    System.out.println("*** Gewonnen! ***");
                    System.out.printf("Das zu ratende Wort ist: '%s'!.\n", word);
                    break;
                }

            } else {
                wrongGuesses++;
                System.out.println("Falsch geraten...");
            }
        }

        if(wrongGuesses >= 6)
        {
            System.out.print(getHangmanArt(wrongGuesses));
            System.out.println("*** Spiel zu Ende ***");
            System.out.printf("Das zu ratende Wort wäre: '%s' gewesen.\n", word);
        }

        sc.close();
    }

    static String getHangmanArt(int wrongGuesses) {
        return switch (wrongGuesses) {
            case 0 ->
                """


                      """;
            case 1 ->
                """
                       o


                      """;
            case 2 ->
                """
                       o
                       |

                      """;
            case 3 ->
                """
                       o
                     / |

                      """;
            case 4 ->
                """
                       o
                     / | \\

                      """;
            case 5 ->
                """
                       o
                     / | \\
                      / 

                      """;
            case 6 ->
                """
                       o
                     / | \\
                      / \\
                      """;
            default ->
                "";

        };

    }

}
