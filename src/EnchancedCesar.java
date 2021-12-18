import java.io.IOException;

public class EnchancedCesar {

    public final static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";



    public static void execute(String word) throws Exception {
        for (int rotationKey = 0; rotationKey <= 26; rotationKey++) {

            for(int incrementKey = 0; incrementKey < 26; incrementKey++) {
                String newWord = enchancedCaesar(word, rotationKey, incrementKey);
                BreakingEnigma.currentSaltAfterCesarBeforeSecondPlugboard = newWord;
                PlugboardParser.backToPlugboard(BreakingEnigma.plugboard, newWord);

            }
        }
    }

    public static String enchancedCaesar(String word, int rotationKey, int increment){

        StringBuilder newWord = new StringBuilder(word);

            for(int index = 0; index < word.length(); index++){

                    int currentIncrement = index * increment;
                    int wordPositionOnTheAlphabet = alphabet.indexOf(newWord.charAt(index));
                    int flag = wordPositionOnTheAlphabet + rotationKey + currentIncrement;

                    int alphabetPosition = flag % alphabet.length();

                    char letter = alphabet.charAt(alphabetPosition);

                    newWord.setCharAt(index,letter);
                }
        BreakingEnigma.currentSaltAfterCesarBeforeSecondPlugboard = newWord.toString();
        return newWord.toString();
    }


}
