package codingtournament.practice.march_9_2011;

import static java.lang.Math.*;


public class AlternatingLane {
    public double expectedBeauty(int[] low, int[] high) {
        double[] differences = differencesOfExpectedHeights(low, high);
        return sumThem(differences);
    }

    protected double sumThem(double[] expectedHeights) {
        double beauty = 0.0;
        for (double expectedHeight : expectedHeights) {
            beauty += expectedHeight;
        }
        return beauty;
    }

    private double[] differencesOfExpectedHeights(int[] low, int[] high) {
        double[] returnVal = new double[low.length];
        for (int i = 1; i < low.length; i++) {
            returnVal[i] = expectedDifference(low[i - 1], high[i - 1], low[i], high[i]);
        }
        return returnVal;
    }

    protected double expectedDifference(int firstLow, int firstHigh, int secondLow, int secondHigh) {
        int numberOfTerms1 = firstHigh - firstLow + 1;
        int numberOfTerms2 = secondHigh - secondLow + 1;
        int numberOfPossibilities = numberOfTerms1 * numberOfTerms2;
        double totalSumOfDiffs = sumOfAllTheDifferences(firstLow, firstHigh, secondLow, secondHigh);
        return totalSumOfDiffs / numberOfPossibilities;
    }

    protected double sumOfAllTheDifferences(int firstLow, int firstHigh, int secondLow, int secondHigh) {
        double result = 0.0;
        for (int i = firstLow; i <= firstHigh; i++) {
            if (strictlyInTheRange(i, secondLow, secondHigh)) {
                result += funnyArithmeticSeries(i, secondLow, secondHigh);
            }
            else
                result += arithmeticFrom(abs(secondLow - i), abs(secondHigh - i));
        }
        return result;
    }

    private boolean strictlyInTheRange(int i, int low, int high) {
        return i < high && i > low;
    }

    protected int arithmeticFrom(int from, int to) {
        if (from == 0 ) return arithmetic(to);
        if (to == 0) return arithmetic(from);
        int big = from > to ? from : to;
        int small = from < to ? from : to;
        return arithmetic(big) - arithmetic(small - 1);
    }

    protected int funnyArithmeticSeries(int i, int secondLow, int secondHigh) {
        return arithmetic(abs(secondLow - i)) + arithmetic(abs(secondHigh - i)); 
    }

    private int arithmetic(int n) {
        return (n * (n + 1)) / 2;
    }
}
