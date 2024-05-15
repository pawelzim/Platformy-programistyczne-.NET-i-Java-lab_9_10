package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Give number of items: ");
        int numberOfItems = scanner.nextInt();

        System.out.print("Give seed: ");
        int seed = scanner.nextInt();

        System.out.print("Give knapsack capacity: ");
        int capacity = scanner.nextInt();

//        System.out.print("LowerBound: ");
//        int lowerBound = scanner.nextInt();
//
//        System.out.print("UpperBound: ");
//        int upperBound = scanner.nextInt();

        System.out.println();

        Problem problem = new Problem(numberOfItems, seed, 1, 10);
        System.out.println(problem);

        System.out.println("------");

        Result result = problem.solve(capacity);
        System.out.println(result);

        scanner.close();
    }
}
