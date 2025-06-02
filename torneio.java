import java.util.Scanner;

public class torneio {
    
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        String[] allMatches = new String[6];
        int winSum = 0;
        for (int i = 0; i < allMatches.length; i++) {

            allMatches[i] = scanner.next();
            if (allMatches[i].equalsIgnoreCase("V")) {

                winSum++;
            } 
            else if (!allMatches[i].equalsIgnoreCase("P")) {
                
                scanner.close();
                throw new Exception();
            }
        }

        if (winSum == 5 || winSum == 6) {
            System.out.println(1);
        }
        else if (winSum == 3 || winSum == 4) {
            System.out.println(2);
        }
        else if (winSum == 1 || winSum == 2) {
            System.out.println(1);
        }
        else {
            System.out.println(-1);
        }
        
        scanner.close();
    }
}
