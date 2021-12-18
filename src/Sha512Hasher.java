import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha512Hasher {

    static String execute(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger generatedHash = new BigInteger(1, messageDigest);

            String hash = generatedHash.toString(16);

            while (hash.length() < 32) {
                hash = "0" + hash;
            }
            BreakingEnigma.generatedHash = hash;
            return hash;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
}
