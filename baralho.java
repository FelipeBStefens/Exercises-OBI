import java.util.Scanner;

public class baralho {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        String line = scanner.next();
        char[] charLine = line.toCharArray();
        String[] stringCard = new String[charLine.length / 3];

        for (int i = 0; i < stringCard.length; i++) {

            String card = "" + charLine[3 * i] + charLine[3 * i + 1] + charLine[3 * i + 2];
            stringCard[i] = card;
        }

        boolean[] c = new boolean[13];
        boolean cError = false;
        boolean[] e = new boolean[13];
        boolean eError = false;
        boolean[] u = new boolean[13];
        boolean uError = false;
        boolean[] p = new boolean[13];
        boolean pError = false;

        for (int i = 0; i < 13; i++) {
            c[i] = false;
            e[i] = false;
            u[i] = false;
            c[i] = false;
        }
        
        for (int i = 0; i < stringCard.length; i++) {

            char[] card = stringCard[i].toCharArray();
            int number = 10 * Integer.parseInt(Character.toString(card[0])) + 
                Integer.parseInt(Character.toString(card[1]));
            
            if (number < 1 || number > 13) {

                scanner.close();
                throw new Exception();
            }

            if (card[2] == 'C') {

                if (c[number - 1]) {
                    cError = true;
                }
                else {
                    c[number - 1] = true;
                }
            }
            else if (card[2] == 'E') {

                if (e[number - 1]) {
                    eError = true;
                }
                else {
                    e[number - 1] = true;
                }
            }
            else if (card[2] == 'U') {

                if (u[number - 1]) {
                    uError = true;
                }
                else {
                    u[number - 1] = true;
                }
            }
            else if (card[2] == 'P') {

                if (p[number - 1]) {
                    pError = true;
                }
                else {
                    p[number - 1] = true;
                }
            }
            else {

                scanner.close();
                throw new Exception();
            }
        }

        if (cError) {
            System.out.println("erro");
        }
        else {
            int total = 13;
            for (int i = 0; i < 13; i++) {
                if (c[i]) {
                    total -= 1;
                }
            }
            System.out.println(total);
        }

        if (eError) {
            System.out.println("erro");
        }
        else {
            int total = 13;
            for (int i = 0; i < 13; i++) {
                if (e[i]) {
                    total -= 1;
                }
            }
            System.out.println(total);
        }

        if (uError) {
            System.out.println("erro");
        }
        else {
            int total = 13;
            for (int i = 0; i < 13; i++) {
                if (u[i]) {
                    total -= 1;
                }
            }
            System.out.println(total);
        }

        if (pError) {
            System.out.println("erro");
        }
        else {
            int total = 13;
            for (int i = 0; i < 13; i++) {
                if (p[i]) {
                    total -= 1;
                }
            }
            System.out.println(total);
        }

        scanner.close();
    }
}