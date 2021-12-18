
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class WordListParser {



    static List<String> execute(String path) throws FileNotFoundException {
        List<String> wordList = new ArrayList<>();
        try {
            File file = new File(path);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String word = myReader.nextLine();
                wordList.add(word);
            }
            myReader.close();
            return wordList;
        } catch (FileNotFoundException e) {
            throw  new FileNotFoundException(e.getMessage());
        }
    }



}
