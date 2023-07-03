// 2.Реализуйте алгоритм сортировки пузырьком числового 
// массива, результат после каждой итерации запишите в лог-файл.

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Homework2_2 {
    static ArrayList<Integer> bubbleSort(ArrayList<Integer> arr) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(Homework2_2.class.getName());
        FileHandler fh = new FileHandler("output.log");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        System.out.println("Отсортированный массив: ");
        int k = arr.size();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
            try {
                FileWriter writer = new FileWriter("output.log", true);
                writer.write("Iteration " + (i + 1) + ": " + arr.toString() + "\n");
                writer.close();
            } catch (Exception e) {
                logger.warning(e.getMessage());
            }
        }
        return arr;
    }
}