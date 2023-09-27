package Graph;

import java.util.Arrays;


public class Knapsack {

    private static Item[] items; // array of items
    private static double maxWeight; // maximum weight capacity of the knapsack
    private static double maxValue; // maximum value obtained so far
    private static Item[] bestSolution; // current best solution
    private static Item[] currentSolution; // current solution being explored

    public static Object[] solve(Item[] itemList, double knapsackCapacity) {
        // initialize global variables
        items = itemList;
        maxWeight = knapsackCapacity;
        maxValue = 0.0;
        bestSolution = new Item[items.length];
        currentSolution = new Item[items.length];
        // start exploring solutions
        backtrack(0, 0.0, 0.0);
        // return the best solution and its profit
        Object[] result = new Object[2];
        result[0] = Arrays.copyOf(bestSolution, bestSolution.length);
        result[1] = maxValue;
        return result;
    }




    private static void backtrack(int i, double currentValue, double currentWeight) {
        if (currentWeight > maxWeight) {
            return; // solution is not feasible
        }
        if (i == items.length) {
            // solution is complete, update best solution if necessary
            if (currentValue > maxValue) {
                maxValue = currentValue;
                bestSolution = Arrays.copyOf(currentSolution, currentSolution.length);
            }
            return;
        }
        // explore two branches: include or exclude item i
        currentSolution[i] = items[i]; // include item i
        backtrack(i + 1, currentValue + items[i].profit, currentWeight + items[i].weight);
        currentSolution[i] = null; // exclude item i
        backtrack(i + 1, currentValue, currentWeight);
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item("A", 2.1, 40.0),
                new Item("B", 3.14, 50.0),
                new Item("C", 1.99, 100.0),
                new Item("D", 5.0, 95.0),
                new Item("E", 3.0, 30.0)
                };
        double knapsackCapacity = 10.0;
        Object[] result = Knapsack.solve(items, knapsackCapacity);
        Item[] bestSolution = (Item[]) result[0];
        double maxProfit = (double) result[1];
        System.out.println("Best solution: " + Arrays.toString(bestSolution));
        System.out.println("Maximum profit: " + maxProfit);
    }
}

class Item {

    public String name;
    public double weight;
    public double profit;

    public Item(String name, double weight, double profit) {
        this.name = name;
        this.weight = weight;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return name;
    }
}
