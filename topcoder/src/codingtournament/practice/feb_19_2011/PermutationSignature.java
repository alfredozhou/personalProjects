package codingtournament.practice.feb_19_2011;


public class PermutationSignature {
    public int[] reconstruct(String signature) {
        assert signature.length() > 0;
        int[] ints = prefillTheIncreasingValues(signature.length() + 1);
        rearrange(ints, signature);
        return ints;
    }

    private int[] prefillTheIncreasingValues(int size) {
        int[] toBeReturned = new int[size];
        for (int i = 0; i < toBeReturned.length; i++) {
            toBeReturned[i] = i + 1;
        }
        return toBeReturned;
    }

    private int[] rearrange(int[] integers, String signature) {
        for (int i = integers.length - 1; i > 0; i--) {
            doSwapIfNeeded(integers, signature, i);
        }
        return integers;
    }

    private void doSwapIfNeeded(int[] integers, String signature, int index) {
        while (index <= signature.length()) {
            char charToCompare = getCharToCompare(signature, index);
            if (needToSwap(integers[index - 1], integers[index], charToCompare)) {
                swap(index - 1, index, integers);
                index++;
            } else
                break;
        }
    }

    private char getCharToCompare(String signature, int i) {
        return signature.charAt(i - 1);
    }

    protected boolean needToSwap(int previousInteger, int integer, char upOrDown) {
        if ('I' == upOrDown)
            return previousInteger > integer;
        return integer > previousInteger;
    }

    protected void swap(int index, int index2, int[] integers) {
        int temp = integers[index2];
        integers[index2] = integers[index];
        integers[index] = temp;
    }
}
