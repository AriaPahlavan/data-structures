// Aria Pahlavan on March 21 2018

public class Item implements Comparable {
    private final Double weight;
    private final Double value;

    public Item(Double value, Double weight) {
        this.weight = weight;
        this.value = value;
    }

    public static Item of(Double value, Double weight) {
        return new Item(value, weight);
    }

    public Double Weight() {
        return weight;
    }

    public Double Value() {
        return value;
    }

    public Item WithWeight(Double weight) {
        return new Item(this.value, weight);
    }

    public Item WeightIncreasedBy(Double w) {
        return new Item(this.value, this.weight + w);
    }

    public Item WithValue(Double value) {
        return new Item(value, this.weight);
    }

    public Item ValueIncreasedBy(Double v) {
        return new Item(this.value + v, this.weight);
    }

    @Override
    public int compareTo(Object o) {
        Item that = (Item) o;
        double thisRatio = this.value/this.weight;
        double thatRatio = that.value/that.weight;

        if (thisRatio == thatRatio) return 0;

        return thisRatio > thatRatio ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Item{" +
               "value=" + value +
               ", weight=" + weight +
               '}';
    }
}
