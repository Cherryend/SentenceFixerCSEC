//Cherry 
//Mr. Flower
//Final Lab
//June 3rd 20

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sentenceFixer {

    static Scanner input = new Scanner(System.in);

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
public static String punctuate(String str) {
    if (str == null || str.isEmpty()) {
        return str;
    }
    
    if (str.endsWith(".") || str.endsWith("!") || str.endsWith("?") || str.endsWith("\"")) {
        return str;
    }
    return str + ".";
}

public static String duplicates(String str){
    Pattern pattern = Pattern.compile("(?i)\\b(\\w+)\\b(\\s+\\1\\b)+");
    Matcher matcher = pattern.matcher(str);
    return matcher.replaceAll("$1");
}

public static String doubleSpace(String str){
        return str.replaceAll("\\s+"," ").trim();
}

public static void main(String[] args) {
        System.out.print("Enter sentence: ");
        String sentence = input.nextLine();
        
        String fixedSentence = capitalize(sentence);
        String fixedSentence2 = punctuate(fixedSentence);
        String fixedSentence3 = duplicates(fixedSentence2);
        String fixedSentence4 = doubleSpace(fixedSentence3);
        System.out.println(fixedSentence4);
    }
}
