// Aria Pahlavan on March 21 2018

public class FractionalKnapsack {
    /**
     * Greedily solve fractional knapsack problem
     *
     * @param capacity capacity of knapsack
     * @param items    items available to put in the knapsack
     * @return maximum value result of fractional knapsack solution
     */
    public static double given(Integer capacity, Item[] items) {
        Item[] sorted = new InsertionSort().on(items);
        Item knapsack = new Item(0.0, 0.0);

        for (int i = sorted.length-1; i >= 0; i--) {
            Item item = sorted[i];

            if (knapsack.Weight() + item.Weight() <= capacity) {
                knapsack = knapsack
                        .WeightIncreasedBy(item.Weight())
                        .ValueIncreasedBy(item.Value());
            } else {
                double remain = capacity - knapsack.Weight();
                knapsack = knapsack
                        .ValueIncreasedBy(item.Value() * (remain / item.Weight()));
                break;
            }
        }

        return knapsack.Value();
    }

    public static void main(String[] args) {
        int knapsackCap = 50;
        Item items[] = {
                Item.of(60.0, 10.0),
                Item.of(120.0, 30.0),
                Item.of(100.0, 20.0),
        };


        System.out.println("Maximum value = "
                           + FractionalKnapsack.given(knapsackCap, items));
    }
}
