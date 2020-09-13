package ua.alevel.task;

import java.util.ArrayList;
import java.util.List;

public class Task1 implements NumberAggregator {

    public static void main(String[] args) {

        Task1 task = new Task1();

        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(2);
        integerList.add(2);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(2.2);
        doubleList.add(2.2);
        doubleList.add(2.2);

        List<Long> longList = new ArrayList<>();
        longList.add((long) 3);
        longList.add((long) 3);

        List<Byte> byteList = new ArrayList<>();
        byteList.add((byte) 2);
        byteList.add((byte) 2);


        System.out.println(task.sum(integerList));
        System.out.println(task.sum(doubleList));
        System.out.println(task.sum(longList));
        System.out.println(task.sum(byteList));
    }


    @Override
    public Number sum(List<? extends Number> numbers) {

        Double sum = 0.0;

        for (Number currentNumber : numbers) {
            sum += currentNumber.floatValue();
        }

        return sum;
    }
}
