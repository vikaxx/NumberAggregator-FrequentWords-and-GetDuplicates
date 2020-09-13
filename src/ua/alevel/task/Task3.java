package ua.alevel.task;

import java.util.*;

public class Task3 implements GetDuplicates {

    public static void main(String[] args) {
        Task3 task = new Task3();

        List<String> words = new ArrayList<>();

        words.add("duplicate8");
        words.add("NOT_duplicate");
        words.add("WORLD");
        words.add("heLLo");
        words.add("hello");
        words.add("world");
        words.add("world");
        words.add("DUPLICATE8");
        words.add("duplicate8");
        words.add("duplicate78");
        words.add("word");
        words.add("woooooooooord12");
        words.add("woooooooooord12");
        words.add("wwwwwwwwword14");
        words.add("wwwwwwwwword14");

        List<String> result = task.getDuplicates(words, 4);

        result.forEach(System.out::println);
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        List<String> result = new ArrayList<>();
        List<String> equalCaseWords = new ArrayList<>();
        Set<String> duplicates = new HashSet<>();

        for (String currentWord : words) {
            equalCaseWords.add(currentWord.toLowerCase());
        }

        for (String currentWord : equalCaseWords) {
            if (!duplicates.add(currentWord)) {
                if (!result.contains(currentWord)) {
                    result.add(currentWord);
                }
            }
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) > o2.charAt(i)) {
                            return 1;
                        } else if (o1.charAt(i) < o2.charAt(i)) {
                            return -1;
                        }
                    }
                    return 0;
                }
                return o1.length() - o2.length();
            }
        };

        result.sort(comparator);

        return result.subList(0, (int) limit);
    }

}
