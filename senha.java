import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class senha {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        String word = scanner.next();
        char[][] possibleReplace = new char[m][k];

        for (int i = 0; i < m; i++) {
            possibleReplace[i] = scanner.next().toCharArray();
        }
        int p = scanner.nextInt();

        ArrayList<String> list = generateList(word, possibleReplace);

        for (int i = 0; i < list.size(); i++) {
            if (i == p - 1) {
                System.out.println(list.get(i));
                break;
            }
        }
        
        scanner.close();
    }

    public static ArrayList<String> generateList(String word, char[][] possibleReplace) {

        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '#') {
                index.add(i);
            }
        }
        int[] indexArray = new int[index.size()];
        for (int i = 0; i < index.size(); i++) {
            indexArray[i] = index.get(i);
        }

        return
            recursiveList(word, indexArray, possibleReplace, new ArrayList<>());
         
    } 

    public static ArrayList<String> recursiveList(
        String word, int[] index, char[][] possibleReplace, ArrayList<String> list) {

        if (possibleReplace.length == 0 && index.length == 0) {

            list.add(word);
            return list;
        }
        
        for (int i = 0; i < possibleReplace.length; i++) {
            for (int j = 0; j < possibleReplace[0].length; j++) {
                
                String newWord = replace(word, possibleReplace[i][j], index[i]);

                int[] newIndex = Arrays.copyOfRange(index, 1, index.length);
                char[][] newPossibleReplace = 
                    Arrays.copyOfRange(possibleReplace, 1, possibleReplace.length);
                
                recursiveList(newWord, newIndex, newPossibleReplace, list);   
            }
        }

        return list;
    }

    public static String replace(String word, char character, int i) {
        String newWord = "";

        for (int j = 0; j < word.length(); j++) {
            if (j == i) {
                newWord += character;
            }
            else {
                newWord += word.charAt(j);
            }
        }

        return newWord;
    }
}