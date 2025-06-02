import java.util.ArrayList;
import java.util.Scanner;

public class tempo {
    
    public static void main(String[] args) throws Exception{
        Scanner scannerLine = new Scanner(System.in);

        int n = scannerLine.nextInt();
        if (n < 1 || n > 20) {

            scannerLine.close();
            throw new Exception();
        }
        scannerLine.nextLine();
        ArrayList<Integer> allUsers = new ArrayList<>();
        ArrayList<Integer> timeByUsers = new ArrayList<>();
        ArrayList<Boolean> isConcluded = new ArrayList<>();
        
        String oldValue = "T";
        for (int i = 0; i < n; i++) {
            String linei = scannerLine.nextLine();

            Scanner scanner = new Scanner(linei);
            String type = scanner.next();
            if (type.equalsIgnoreCase("R")) {
                int userCode = scanner.nextInt();
                if (userCode < 1 || userCode > 100) {

                    scanner.close();
                    scannerLine.close();
                    throw new Exception();
                }

                int indexUser = -1;
                for (int j = 0; j < allUsers.size(); j++) {
                    if (allUsers.get(j) == userCode) {
                        indexUser = j;
                        break;
                    }
                }


                if (indexUser != -1) {
                    if (isConcluded.get(indexUser)) {
                        isConcluded.set(indexUser, false);
                    }
                    else {

                        scanner.close();
                        scannerLine.close();
                        throw new Exception();
                    }
                }
                else {

                    allUsers.add(userCode);
                    timeByUsers.add(0);
                    isConcluded.add(false);
                }
            }
            else if (type.equalsIgnoreCase("T")) {
                int time = scanner.nextInt();
                if (time < 1 || time > 100) {

                    scanner.close();
                    scannerLine.close();
                    throw new Exception();
                }

                for (int j = 0; j < timeByUsers.size(); j++) {

                    if (!isConcluded.get(j)) {
                        timeByUsers.set(j, timeByUsers.get(j) + time);
                    }
                }
            }
            else if (type.equalsIgnoreCase("E")) {
                int userCode = scanner.nextInt();
                if (userCode < 1 || userCode > 100) {

                    scanner.close();
                    scannerLine.close();
                    throw new Exception();
                }
                
                int indexUser = -1;
                for (int j = 0; j < allUsers.size(); j++) {
                    if (allUsers.get(j) == userCode) {
                        indexUser = j;
                        break;
                    }
                }

                if (indexUser != -1) {

                    if (!isConcluded.get(indexUser)) {
                        isConcluded.set(indexUser, true);
                    }
                    else {

                        scanner.close();
                        scannerLine.close();
                        throw new Exception();
                    }
                }
                else {

                   scanner.close();
                    scannerLine.close();
                    throw new Exception(); 
                }
            }
            else {

                scanner.close();
                scannerLine.close();
                throw new Exception();
            }
            if (scanner.hasNext()) {

                scanner.close();
                scannerLine.close();
                throw new Exception();
            }

            if (!type.equalsIgnoreCase("T") && 
                !oldValue.equalsIgnoreCase("T")) {
                
                for (int j = 0; j < timeByUsers.size(); j++) {

                    if (!isConcluded.get(j)) {
                        timeByUsers.set(j, timeByUsers.get(j) + 1);
                    }
                }
            }

            oldValue = type;
            scanner.close();
        }

        for (int i = 0; i < allUsers.size(); i++) {

            if (isConcluded.get(i)) {
                System.out.println(allUsers.get(i) + " " + timeByUsers.get(i));
            }
            else {
                System.out.println(allUsers.get(i) + " " + (-1));
            }
        }

        scannerLine.close();
    }
}
