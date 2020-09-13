package ua.alevel.task;

import java.util.List;

public interface NumberAggregator {
    Number sum(List<? extends Number> numbers);
}
