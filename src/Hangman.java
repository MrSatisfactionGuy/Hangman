
import com.sun.source.tree.ArrayAccessTree;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {

        String filePath = "src/woerter.txt";
        ArrayList<String> woerterListe = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                woerterListe.add(line.trim());
            }

            for (String w : woerterListe) {
                System.out.println("[" + w + "] length=" + w.length());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        } catch (IOException e) {
            System.out.println("Irgendwas ist schiefgegangen beim Einlesen...");
        }

        Random rd = new Random();

        String word = woerterListe.get(rd.nextInt(woerterListe.size()));

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

            if (word.toLowerCase().indexOf(Character.toLowerCase(guess)) >= 0) {
                System.out.println("Gut geraten!");

                for (int i = 0; i < word.length(); i++) {
                    if (Character.toLowerCase(word.charAt(i)) == Character.toLowerCase(guess)) {
                        wordstate.set(i, guess);
                    }
                }

                if (!wordstate.contains('_')) {
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

        if (wrongGuesses >= 6) {
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
