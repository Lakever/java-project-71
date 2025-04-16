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

        list.sort(Comparator.naturalOrder()); // сортирую по алфавиту
//        String res = list.toString();
// ok тееперь ключи отсортированы, дальше по этим ключам делать разницу значений этих ключей
        StringBuilder result = new StringBuilder("{\n");
        for (String item : list) {
            if (!data2.containsKey(item)) { // ключ удалён
                result.append("-").append(item).append(": ").append(data1.get(item)).append("\n");
                // если нет ключа, то он есть во втором файле, но он нсть в list значит он есть во стором файле
                //зачит он добавлен
            } else if (!data1.containsKey(item)) {
                result.append("+").append(item).append(": ").append(data2.get(item)).append("\n");
                //разница
                //значения и ключи есть, так как варианты, где их нет мы рассмотрели
                //если они не рарвны то
            } else if (!data1.get(item).equals(data2.get(item))) {
                result.append("-").append(item).append(": ").append(data1.get(item)).append("\n");
                result.append("+").append(item).append(": ").append(data2.get(item)).append("\n");
            } else {
                result.append(" ").append(item).append(": ").append(data1.get(item));
            }
        }
        result.append("\n}");
        return result.toString();
    }
}
