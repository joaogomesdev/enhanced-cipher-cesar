import java.lang.reflect.Array;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;



public class SaltGenerator {
    static String saltAlphabet = "ABCDEFGHIJKLM";

    static void execute(List<String> wordList )  {

        for(String word: wordList){

        }


    }

    static String putLeft(String word){
        for (int i = 0; i < saltAlphabet.length(); i++) {

            for(int j = 0; j < saltAlphabet.length(); j++){

                System.out.println(saltAlphabet.charAt(i) + "" + saltAlphabet.charAt(j) );

            }

        }
    }

    static List<String> putRight(String word){

        for (int i = 0; i < saltAlphabet.length(); i++) {

            for(int j = 0; j < saltAlphabet.length(); j++){



            }

        }


    }

}
