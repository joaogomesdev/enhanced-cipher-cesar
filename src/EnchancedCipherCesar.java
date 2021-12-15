import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public class EnchancedCipherCesar {


    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
            String myPlugboard = "{'M': 'N', 'Q': 'J', 'I': 'C', 'O': 'A', 'R': 'S', 'K': 'U', 'P': 'F', 'E': 'Y', 'H': 'V', 'B': 'L'}" ;
            String myHash = "4ef49689665c22e413ceec2a45d2e6f40b069ea464c3484f13cb48580611da2fa6bca1f81c414fb1f480c2e892d3644db66378fa28e8fc2a811f8a48fdb9cb3d";

            String hash = args[0];
            String plugboard = args[1];
            String wordListPath = args[2];

            List<String> wordList = WordListParser.execute(wordListPath);
//            for (String word: wordList){
//                SaltGenerator.execute(word);
//                PlugboardParser.execute(plugboard, word);
//            }

            String result = Sha512Cyptor.execute("NPTXKFH");
        System.out.println(result);



    }
}
