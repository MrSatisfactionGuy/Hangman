
public class Loops {

    public static void main(String[] args) {

        int counter = 5;

        //For-Schleife
        //Iteration für einen bekannten Bereich (int = 5)
        //Erst Bedingung, dann Durchlauf
        for (int i = 0; i <= counter; i++)
        {
            System.out.println(i);
        }

        System.out.println("******");

        int j = 0;

        //While-Schleife
        //Anzahl der Wiederholungen nicht im Voraus bekannt
        //Erst Bedingung, dann Durchlauf
        while(j <= counter)
        {
            System.out.println(j);
            j++;
        }

        System.out.println("******");

        int k = 0;

        //Do-Schleife
        //Mindestens einmaliger Durchlauf
        //Erst Durchlauf, dann Prüfung
        do{
            System.out.println(k);
            k++;
        }
        while(k <= counter);
    }
}


