import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class ReadFail {
    public static void main(String[] args) throws IOException {
        //вывод текста
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("C:\\Users\\WE\\Desktop\\ReadFail.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // log error
        }
        // считает количество слов
        Scanner scanner = new Scanner(new File("C:\\Users\\WE\\Desktop\\ReadFail.txt"));
        Map<String, Integer> statistics = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter("\\s+").next();
            Integer count = statistics.get(word);
            if (count == null) {
                count = 0;
            }
            statistics.put(word, ++count);

        }
        System.out.println(statistics);
// Выводим самое популярное
        String manyWords = null;
        Integer howMany = null;

        for (Map.Entry<String, Integer> pair : statistics.entrySet()) {
            if (manyWords == null) {
                manyWords = pair.getKey();
                howMany = statistics.get(manyWords);
            }
            String key = pair.getKey();
            Integer value = pair.getValue();

            if (value > howMany) {
                manyWords = key;
                howMany = value;
            }
        }
        System.out.println();
        System.out.println("Больше всего слов " + manyWords + " повторяется " + howMany + " раз");
        //Сортируем колекцию
//        List<Object> list = new ArrayList<Object>();
//        Collections.sort(list);
//        for (Object str : list) {
//            System.out.print(" " + str);
//        }

    }
}