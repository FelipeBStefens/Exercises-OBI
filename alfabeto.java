import java.util.Scanner;

public class alfabeto {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int n = scanner.nextInt();

        String alphabetString = scanner.next();
        char[] alphabet = alphabetString.toCharArray();
        
        String mensageString = scanner.next();
        char[] mensage = mensageString.toCharArray();

        boolean canBeAlien = true;
        for (int i = 0; i < n; i++) {

            boolean inAlphabet = false;
            for (int j = 0; j < k; j++) {

                if (mensage[i] == alphabet[j]) {
                    inAlphabet = true;
                }
            }

            if (!inAlphabet) {
                canBeAlien = false;
                break;
            }
        }

        if (canBeAlien) {
            System.out.println("S");
        }
        else {
            System.out.println("N");
        }

        scanner.close();
    }
}