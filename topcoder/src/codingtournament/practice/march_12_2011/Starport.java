package codingtournament.practice.march_12_2011;


public class Starport {
    public double getExpectedTime(int teleportationRate, int spaceShipArrivalRate) {
        return (double) accumulatedWaitTimes(teleportationRate, spaceShipArrivalRate) / (lcm(teleportationRate, spaceShipArrivalRate) / spaceShipArrivalRate);
    }

    protected int accumulatedWaitTimes(int teleport, int arrival) {
        int lcm = lcm(teleport, arrival);
        int result = 0;
        for (int i = 1; i * teleport <= lcm; i++) {
            result += waitsBetween((i - 1) * teleport, i * teleport, arrival);
        }
        return result;
    }

    protected int waitsBetween(int previousTeleport, int thisTeleport, int arrivalRate) {
        double arrivalMultiplier = Math.ceil((double)previousTeleport / arrivalRate);
        arrivalMultiplier = arrivalMultiplier == 0 ? 1 : arrivalMultiplier;
        int returnValue = 0;
        for (; arrivalMultiplier * arrivalRate <= thisTeleport; arrivalMultiplier++) {
            returnValue += thisTeleport - arrivalMultiplier * arrivalRate;
        }
        return returnValue;
    }

    protected int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    protected int gcd(int a, int b) {
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        else if (a > b)
            return gcd(a - b, b);
        else
            return gcd(b - a, a);
    }
}
