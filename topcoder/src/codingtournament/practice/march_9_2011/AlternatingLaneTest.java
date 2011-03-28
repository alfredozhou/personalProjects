package codingtournament.practice.march_9_2011;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class AlternatingLaneTest {

    private AlternatingLane objectUnderTest = new AlternatingLane();

    @Test
    public void shouldWork() {
        double beauty = objectUnderTest.expectedBeauty(new int[]{1, 1, 1}, new int[]{2, 2, 2});
        assertThat(beauty, equalTo(1.0));

        beauty = objectUnderTest.expectedBeauty(new int[]{1, 3, 5, 7, 9}, new int[]{2, 4, 6, 8, 10});
        assertThat(beauty, equalTo(8.0));

        beauty = objectUnderTest.expectedBeauty(new int[]{4, 3, 3, 7}, new int[]{10, 7, 7, 7});
        assertThat(beauty, equalTo(6.171428571428572));
    }

    @Test
    public void shouldCalculateExpectedDifference() {
        double expected = objectUnderTest.expectedDifference(1, 2, 1, 2);
        assertThat(expected, equalTo(0.5));
    }

    @Test
    public void shouldSumTheDifferences() {
        double amount = objectUnderTest.sumOfAllTheDifferences(1, 2, 1, 2);

        assertThat(amount, equalTo(2.0));
    }

    @Test
    public void shouldCalculateRunningSum() {
        double val = objectUnderTest.sumThem(new double[]{2.0, 3.0, 5.0, 6.0, 7.0});
        assertThat(val, equalTo(23.0));
    }

    @Test
    public void shouldCalculateFunnyArithmeticSeries() {
        int funnyArithmetic = objectUnderTest.funnyArithmeticSeries(3, 2, 4);
        assertThat(funnyArithmetic, equalTo(2));

        funnyArithmetic = objectUnderTest.funnyArithmeticSeries(4, 3, 7);
        assertThat(funnyArithmetic, equalTo(7));
    }

    @Test
    public void shouldCalculateFromLowToHigh() {
        int value = objectUnderTest.arithmeticFrom(3, 7);
        assertThat(value, equalTo(25));
    }
}
