
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PlugboardParser {

    static void execute(String plugboard, String word) throws IOException {

        String jsonParsed = plugboard.substring(plugboard.indexOf("{") + 1, plugboard.indexOf("}"));
        String[]  parsed = jsonParsed.split(",");

        List<String> formatedPlugboard = parseForExpectedFormat(parsed);

        plugboardParser(word, formatedPlugboard);
        System.out.println("\n" +"\n" +"\n" +"\n" +"\n" );



    }
    static List<String> parseForExpectedFormat(String[] list) {
        List<String> plugboardList = new ArrayList<String>();
        for (String value: list){
            plugboardList.add(value.trim());
        }
        return plugboardList;
    }

    static void plugboardParser(String word, List<String> formatedPlugboard) throws IOException {

            for(String value: formatedPlugboard) {
                String[] formatedValue = value.split(":");

                String firstValue = String.valueOf(formatedValue[0]);
                String secondValue = String.valueOf(formatedValue[1]);

                String[] firstValueFormatted  = firstValue.split("'");
                String[] secondValueFormatted  = secondValue.split("'");

                String finalFirstValue = firstValueFormatted[1];
                String finalSecondValue = secondValueFormatted[1];
//                System.out.println(finalFirstValue + "     " + finalSecondValue);


                for (int i=0; i<word.length(); i++) {
                    char c = word.charAt(i);

                    if(String.valueOf(c).equals(finalFirstValue)){
                        System.out.println(c + "-----" + finalFirstValue);
                    }
                }

            }

        }


}
