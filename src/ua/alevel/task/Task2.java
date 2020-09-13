package ua.alevel.task;

import java.util.*;

public class Task2 implements FrequentWords {

    public static void main(String[] args) {
        Task2 task = new Task2();

        List<String> words = new ArrayList<>();

        words.add("duplicate8");
        words.add("hello");
        words.add("hello");
        words.add("word");
        words.add("word");
        words.add("word");
        words.add("hello");
        words.add("hello");
        words.add("word");
        words.add("word");
        words.add("w");
        words.add("duplicate8");
        words.add("duplicate8");
        words.add("duplicate8");
        words.add("duplicate8");
        words.add("duplicate8");
        words.add("duplicate8");
        words.add("duplicate8");
        words.add("word");

        List<Map.Entry<String, Long>> result = task.getMostFrequentWords(words, (long) 3);

        result.forEach(System.out::println);

    }

    @Override
    public List<Map.Entry<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        List<Map.Entry<String, Long>> result = new ArrayList<>();
        Map<String, Long> map = new HashMap<>();
        Set<String> temp = new HashSet<>();

        for (String currentWord : words) {
            if (temp.add(currentWord)) {
                map.put(currentWord, (long) 1);
            } else {
                long counter = (long) map.get(currentWord);
                counter++;
                map.put(currentWord, counter);
            }
        }

        List<Long> values = new ArrayList<>();

        for (Map.Entry<String, Long> current : map.entrySet()) {
            values.add(current.getValue());
        }
        Collections.sort(values);
        Collections.reverse(values);

        for (int i = 0; i < limit; i++) {
            for (Map.Entry<String, Long> current : map.entrySet()) {
                if (current.getValue().equals(values.get(i))) {
                    result.add(current);
                }
            }
        }

        return result;
    }
}