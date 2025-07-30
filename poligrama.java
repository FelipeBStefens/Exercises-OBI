import java.util.ArrayList;
import java.util.Scanner;

public class poligrama {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String word = scanner.next();
        
        String root = "*";
        for (int i = 0; i < n / 2; i++) {

            String possibleRoot = word.substring(0, i + 1);
            String otherParts = word.substring(i + 1, word.length());

            boolean isRoot = true;
            for (int j = 0; j < otherParts.length(); j += possibleRoot.length()) {

                String other = otherParts.substring(j, j + possibleRoot.length());
                if (!isPermutation(possibleRoot, other)) {
                    isRoot = false;
                    break;
                }
            }

            if (isRoot && root.equals("*")) {
                root = possibleRoot;
                break;
            }
        }

        System.out.println(root);
        scanner.close();
    }

    public static boolean isPermutation(String one, String two) {

        ArrayList<String> permutations = allPermutations("", one, new ArrayList<>());
        for (int i = 0; i < permutations.size(); i++) {

            if (permutations.get(i).equals(two)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> allPermutations(String up, String word, 
        ArrayList<String> list) {
        
        if (word.isEmpty()) {
            list.add(up);
        }

        for (int i = 0; i < word.length(); i++) {

            allPermutations(up + word.charAt(i), removeIndex(word, i), list);
        }

        return list;
    }

    public static String removeIndex(String word, int i) {

        String newWord = "";

        for (int j = 0; j < word.length(); j++) {
            if (i != j) {
                newWord += word.charAt(j);
            }
        }
        return newWord;
    }
}
