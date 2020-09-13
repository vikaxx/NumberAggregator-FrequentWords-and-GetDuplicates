package ua.alevel.task;

import java.util.List;
import java.util.Map;

public interface FrequentWords {
    List<Map.Entry<String, Long>> getMostFrequentWords(List<String> words, long limit);
}
