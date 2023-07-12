// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся 
// имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Homework5 {

  public static void main(String[] args) {
    Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();
    addNumber("Иван Петров", 111, phoneBook);
    addNumber("Сергей Иванов", 222, phoneBook);
    addNumber("Олег Сидоров", 333, phoneBook);
    addNumber("Мария Петрова", 444, phoneBook);
    addNumber("Ольга Иванова", 555, phoneBook);
    addNumber("Наталья Сидорова", 666, phoneBook);
    printBook(phoneBook);
  }
  public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map) { // Метод, добавляющий
                                                                                             // номера в книгу
    if (map.containsKey(key)) {
      map.get(key).add(value);
    } else {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(value);
      map.put(key, list);
    }
  }
  public static void printBook(Map<String, ArrayList<Integer>> map) { // Метод, печатающий список контактов
    for (var item : map.entrySet()) {
      String phones = "";
      for (int el : item.getValue()) {
        phones = phones + el + ", ";
      }
      System.out.printf("%s: %s \n", item.getKey(), phones);
    }
  }
}