import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public class BreakingEnigma {
    public static String hash;
    public static String plugboard;
    public static String wordListPath;
    public static String currentWord;

    public static String currentSaltBeforePlugboard;
    public static String currentSaltAfterPlugboardBeforeCesar;
    public static String currentSaltAfterCesarBeforeSecondPlugboard;
    public static String currentSaltAfterSecondPlugboard;
    public static String generatedHash;



    public static void main(String[] args) throws Exception {

            hash = args[0];
            plugboard = args[1];
            wordListPath = args[2];

            List<String> wordList = WordListParser.execute(wordListPath);

            SaltGenerator.execute(wordList, plugboard);

    }
}
