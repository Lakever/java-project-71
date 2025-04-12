package hexlet.code;

import java.io.IOException;
import java.util.*;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws IOException {
        var data1 = Parser.pars(filePath1);
        var data2 = Parser.pars(filePath2);

        var list = new ArrayList<String>();

        list.addAll(data1.keySet());
        list.addAll(data2.keySet());

        list.sort((s1, s2) -> s1.compareTo(s2)); // сортирую по алфавиту
        String res = list.toString();

        

//        Set<String> allKeys = new HashSet<>();
//        allKeys.addAll(data1);



        return res;
    }
}
