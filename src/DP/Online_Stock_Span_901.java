package DP;
import java.util.Stack;

public class Online_Stock_Span_901 {
    Stack<Integer> prices;
    Stack<Integer> weights;
    public Online_Stock_Span_901() {
        prices = new Stack<>();
        weights = new Stack<>();
    }

    public int next(int price) {
        int weight = 1;
        while (!prices.isEmpty() && price >= prices.peek()) {
            prices.pop();
            weight += weights.pop();
        }
        prices.push(price);
        weights.push(weight);
        return weight;
    }

    public static void main(String[] args) {
        Online_Stock_Span_901 s = new Online_Stock_Span_901();
        int param_1 = s.next(100);
        int param_2 = s.next(80);
        int param_3 = s.next(60);
        int param_4 = s.next(70);
        int param_5 = s.next(60);
        int param_6 = s.next(75);
        int param_7 = s.next(85);
    }
}
