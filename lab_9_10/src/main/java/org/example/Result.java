package org.example;

import java.util.List;

public class Result {
    List<Item> items;
    List<Integer> nrOfItems;
    int sumValue;
    int sumWeight;

    public Result(List<Item> items, List<Integer> nrOfItems, int sumValue, int sumWeight) {
        this.items = items;
        this.nrOfItems = nrOfItems;
        this.sumValue = sumValue;
        this.sumWeight = sumWeight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < nrOfItems.get(i); j++) {
                sb.append("No: ").append(i+1).append(" ").append(items.get(i)).append("\n");
            }
        }
        sb.append("\n");
        sb.append("Weight: ").append(sumWeight).append("\n");
        sb.append("Value: ").append(sumValue).append("\n");
        return sb.toString();
    }
}
