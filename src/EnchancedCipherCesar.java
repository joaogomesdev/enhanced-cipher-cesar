public class EnchancedCipherCesar {


    public static void main(String[] args) {

            String hash = args[0];
            String plugboard = args[1];
            String wordListPath = args[2];

            WordListParser.execute(wordListPath);
    }
}
