package codingtournament.practice.march_12_2011;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class StarportTest {
    private Starport port = new Starport();

    @Test
    public void shouldCalculatedGcd() {
        int gcd = port.gcd(2, 4);
        assertThat(gcd, equalTo(2));

        gcd = port.gcd(3, 5);
        assertThat(gcd, equalTo(1));

        gcd = port.gcd(21, 28);
        assertThat(gcd, equalTo(7));

        gcd = port.gcd(12345, 2345);
        assertThat(gcd, equalTo(5));
    }

    @Test
    public void shouldCalculateTheLCM() {
        int lcm = port.lcm(2, 4);

        assertThat(lcm, equalTo(4));
        lcm = port.lcm(3, 5);

        assertThat(lcm, equalTo(15)); 

        lcm = port.lcm(12345, 2345);

        assertThat(lcm, equalTo(5789805));

    }

    @Test
    public void shouldAccumulateWaitTimes() {
        int wait = port.accumulatedWaitTimes(4, 2);

        assertThat(wait, equalTo(2));

         wait = port.accumulatedWaitTimes(5, 3);

        assertThat(wait, equalTo(10));
    }

    @Test
    public void shouldCalculateInBetweenWaitTimes() {
        int wait = port.waitsBetween(0, 4, 2);

        assertThat(wait, equalTo(2));
    }

    @Test
    public void shouldCalculateExpectedWaittime() {
        double expectedTime = port.getExpectedTime(5, 3);

        assertThat(expectedTime, equalTo(2.0));

        expectedTime = port.getExpectedTime(6, 1);

        assertThat(expectedTime, equalTo(2.5));

        expectedTime = port.getExpectedTime(12345, 2345);

        assertThat(expectedTime, equalTo(6170.0));

        expectedTime = port.getExpectedTime(7, 3);

        assertThat(expectedTime, equalTo(3.0));
    }
}
