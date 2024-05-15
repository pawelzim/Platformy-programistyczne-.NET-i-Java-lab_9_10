package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem {
    int n;
    int seed;
    int lowerBound;
    int upperBound;
    List<Item> items;

    public Problem(int n, int seed, int lowerBound, int upperBound) {
        this.n = n;
        this.seed = seed;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.items = new ArrayList<>();
        generateItems();
    }

    private void generateItems() {
        Random random = new Random(seed);
        for (int i = 0; i < n; i++) {
            int weight = lowerBound + random.nextInt(upperBound - lowerBound + 1);
            int value = lowerBound + random.nextInt(upperBound - lowerBound + 1);
            items.add(new Item(weight, value));
        }
    }

    public Result solve(int capacity) {
        items.sort((a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

//            for (int i = 0; i < items.size(); i++) {
//                System.out.println(i + " " + items.get(i));
//            }

        List<Item> resultItems = new ArrayList<>();
        List<Integer> resultNrOfItems = new ArrayList<>();
        int sumValue = 0;
        int sumWeight = 0;

        for (int i = 0; i < n; i++) {
            Item item = items.get(i);
            int ilosc = 0;
            while (sumWeight + item.weight <= capacity) {
                sumWeight += item.weight;
                sumValue += item.value;
                ilosc++;
            }
            if (ilosc > 0) {
                resultItems.add(items.get(i));
                resultNrOfItems.add(ilosc);
            }
        }

        if (resultItems.isEmpty()) {
            return null;
        }

        return new Result(resultItems, resultNrOfItems, sumValue, sumWeight);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append("No: ").append(i+1).append(" ").append(items.get(i)).append("\n");
        }
        return sb.toString();
    }
}