import java.util.ArrayList;

public class FizzBuzzQuestion {
    public static void main(String[] args) {
        System.out.println(fizzbuzz(16));
    }

    public static ArrayList fizzbuzz(int n) {
        ArrayList<String> resultOfArray = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                resultOfArray.add("FizzBuzz");
            } else if (i % 3 == 0) {
                resultOfArray.add("Fizz");
            } else if (i % 5 == 0) {
                resultOfArray.add("Buzz");
            } else {
                resultOfArray.add("" + i);
            }
        }

        return resultOfArray;
    }
}