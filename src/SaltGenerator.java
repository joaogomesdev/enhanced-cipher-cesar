import java.io.IOException;
import java.util.List;



public class SaltGenerator {
    static String saltAlphabet = "ABCDEFGHIJKLM";
    static void execute(List<String> wordList , String plugboard) throws Exception {

            for(String word: wordList){
                BreakingEnigma.currentWord = word;
                generateRightSaltedWord(word, plugboard);
            }
            for(String word: wordList){
                BreakingEnigma.currentWord = word;
                generateLeftSaltedWord(word, plugboard);
            }
    }

    static void generateLeftSaltedWord(String word, String plugboard) throws Exception {
        if(word.length() < 2){
            return;
        }
        for (int i = 0; i < saltAlphabet.length(); i++) {

            for(int j = 0; j < saltAlphabet.length(); j++){
                String salt = String.valueOf(saltAlphabet.charAt(i) + "" + saltAlphabet.charAt(j));
                String finalSalt = "";
                if (salt != null) {
                    finalSalt = salt + "" + word;
                    BreakingEnigma.currentSaltBeforePlugboard = finalSalt;
                }
                PlugboardParser.execute(plugboard, finalSalt);
            }

        }
    }

    static void generateRightSaltedWord(String word, String plugboard) throws Exception {
        if(word.length() < 2){
            return;
        }
        for (int i = 0; i < saltAlphabet.length(); i++) {

            for(int j = 0; j < saltAlphabet.length(); j++) {

                String salt = String.valueOf(saltAlphabet.charAt(i) + "" + saltAlphabet.charAt(j));
                String finalSalt = "";
                if (salt != null) {
                    finalSalt = word + "" + salt;
                    BreakingEnigma.currentSaltBeforePlugboard = finalSalt;
                }
                PlugboardParser.execute(plugboard, finalSalt);

            }

        }


    }

}
