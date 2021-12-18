
import java.io.IOException;
import java.util.*;

public class PlugboardParser {

    static void execute(String plugboard, String saltedWord) throws Exception {

        try{
            String jsonParsed = plugboard.substring(plugboard.indexOf("{") + 1, plugboard.indexOf("}"));
            String[]  parsed = jsonParsed.split(",");
            List<String> formatedPlugboard = parseForExpectedFormat(parsed);

            String plugboardedWord = plugboardParser(saltedWord, formatedPlugboard);
            BreakingEnigma.currentSaltAfterPlugboardBeforeCesar = plugboardedWord;

            EnchancedCesar.execute(plugboardedWord);
        }catch (Exception err){
            throw new Exception(err.getMessage());
        }


    }

    static void backToPlugboard(String plugboard, String saltedWord) throws Exception {

        try {
            String jsonParsed = plugboard.substring(plugboard.indexOf("{") + 1, plugboard.indexOf("}"));
            String[]  parsed = jsonParsed.split(",");

            List<String> formatedPlugboard = parseForExpectedFormat(parsed);
            BreakingEnigma.currentSaltAfterCesarBeforeSecondPlugboard = saltedWord;
            String plugboardedWord = plugboardParser(saltedWord, formatedPlugboard);
            BreakingEnigma.currentSaltAfterSecondPlugboard = plugboardedWord;
            String hashedWord = Sha512Hasher.execute(plugboardedWord);

            if(Objects.equals(hashedWord, BreakingEnigma.hash)){
                System.out.println("              _____");
                System.out.println("        ---==/    \\\\");
                System.out.println("             |.    \\|\\  ");
                System.out.println("             |  )   \\\\\\   ");
                System.out.println("             \\_/ |  //|\\\\ ");
                System.out.println("                  /   \\\\\\/\\\\");
                System.out.println("Your word is -> " + "" + BreakingEnigma.currentWord);
                System.out.println("Your salt before plugboard is -> " + "" + BreakingEnigma.currentSaltBeforePlugboard);
                System.out.println("Your salt after plugboard and before EnchancedCesar -> " + "" + BreakingEnigma.currentSaltAfterPlugboardBeforeCesar);
                System.out.println("Your salt after EnchancedCesar and before the second plugboard is -> " + "" + BreakingEnigma.currentSaltAfterCesarBeforeSecondPlugboard);
                System.out.println("Your salt after second plugboard is -> " + "" + BreakingEnigma.currentSaltAfterSecondPlugboard);
                System.out.println("Your generated hash  is  -> " + "" + BreakingEnigma.generatedHash);
                System.out.println("Your expected  hash  is  -> " + "" + BreakingEnigma.hash);

                System.out.println(BreakingEnigma.currentWord);
                System.exit(0);
            }

            System.out.println("Não é");
        }catch (Exception e){
            throw  new Exception("Hash invalido");
        }



    }


    static List<String> parseForExpectedFormat(String[] list) {
        List<String> plugboardList = new ArrayList<String>();
        for (String value: list){
            plugboardList.add(value.trim());
        }
        return plugboardList;
    }

    static String plugboardParser(String word, List<String> formatedPlugboard) throws IOException {
            for(String value: formatedPlugboard) {
                String[] formatedValue = value.split(":");

                String firstValue = String.valueOf(formatedValue[0]);
                String secondValue = String.valueOf(formatedValue[1]);

                String[] firstValueFormatted  = firstValue.split("'");
                String[] secondValueFormatted  = secondValue.split("'");

                String finalFirstValue = firstValueFormatted[1];
                String finalSecondValue = secondValueFormatted[1];

                for (int i=0; i<word.length(); i++) {
                    char c = word.charAt(i);

                    if(String.valueOf(c).equals(finalFirstValue)){
                        char[] finalSecondValueCharArray = finalSecondValue.toCharArray();
                        word = word.replace(word.charAt(i),finalSecondValueCharArray[0]);
                    }
                }
            }

            return word;
        }


}
