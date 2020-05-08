package rainfallJ;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class Rainfall {
    static double rainfall(List<Integer> rainfalls) throws IllegalArgumentException {
        if (rainfalls.isEmpty()) throw new IllegalArgumentException("No data");
        int sum = 0;
        int n = 0;
        for (int rainfall: rainfalls) {
            if (rainfall == -999)
                break;
            if (rainfall >= 0) {
                n++;
                sum += rainfall;
            }
        }
        if (n != 0)
            return (double) sum / n;
        else
            throw new IllegalArgumentException("No Data");
    }
    private static void test(List<Integer> rainfalls) {
        try {
            System.out.println("====");
            System.out.println(rainfalls);
            System.out.println(rainfall(rainfalls));
        } catch (Exception ex) {
            System.err.println(ex.getClass() + ": " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        test(Collections.emptyList());
        test(Collections.singletonList(0));
        test(Collections.singletonList(-999));
        test(asList(-1, -2));
        test(asList(1, 2));
        test(asList(1, -3, 2));
        test(asList(1, 2, -3));
        test(asList(1, -999, 2, -3));
    }
}