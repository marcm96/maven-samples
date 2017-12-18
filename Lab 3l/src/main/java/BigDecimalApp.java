import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BigDecimalApp {
    public static void main(String[] args) {
        List<BigDecimal> input = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 500; i++){
            input.add(BigDecimal.valueOf(random.nextDouble()));
        }

        System.out.println("Before serialization");
        Long s = System.currentTimeMillis();
        System.out.println("Sum: " + BigDecimalOperations.computeSum(input));
        System.out.println("Average: " + BigDecimalOperations.computeAverage(input));
        System.out.println("Top 10: " + BigDecimalOperations.topTen(input));
        Long resultOne = System.currentTimeMillis() - s;
        System.out.println("Took: " + resultOne + "ms");

        BigDecimalOperations.serializeItems(input, "bigdecimals.ser");

        List<BigDecimal> readDecimals = new ArrayList<>();

        BigDecimalOperations.deserializeItems(readDecimals, "bigdecimals.ser");

        System.out.println("After deserialization");
        s = System.currentTimeMillis();
        System.out.println("Sum: " + BigDecimalOperations.computeSum(readDecimals));
        System.out.println("Average: " + BigDecimalOperations.computeAverage(readDecimals));
        System.out.println("Top 10: " + BigDecimalOperations.topTen(readDecimals));
        Long resultTwo = System.currentTimeMillis() - s;
        System.out.println("Took: " + resultTwo + "ms");
    }
}
