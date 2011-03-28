package codingtournament.practice.feb_19_2011;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PermutationSignatureTest {
    private PermutationSignature signature;

    @Before
    public void setUp() throws Exception {
        signature = new PermutationSignature();
    }

    @Test
    public void shouldTellIfNeedsSwapping() {
        assertFalse(signature.needToSwap(1, 2, 'I'));
        assertTrue(signature.needToSwap(2, 1, 'I'));

        assertTrue(signature.needToSwap(1, 2, 'D'));
        assertFalse(signature.needToSwap(2, 1, 'D'));
    }

    @Test
    public void shouldSwap() {
        int[] integer = new int[]{1,2};
        signature.swap(0, 1, integer);

        assertEquals(integer[0], 2);
        assertEquals(integer[1], 1);
    }

    @Test
    public void shouldOutputCorrectlyNow() {
        int[] ints = signature.reconstruct("IIII");
        assertEquals(1, ints[0]);
        assertEquals(2, ints[1]);
        assertEquals(3, ints[2]);
        assertEquals(4, ints[3]);
        assertEquals(5, ints[4]);

        ints = signature.reconstruct("DIIDID");
        assertEquals(2, ints[0]);
        assertEquals(1, ints[1]);
        assertEquals(3, ints[2]);
        assertEquals(5, ints[3]);
        assertEquals(4, ints[4]);
        assertEquals(7, ints[5]);
        assertEquals(6, ints[6]);

        ints = signature.reconstruct("DI");
        assertEquals(2, ints[0]);
        assertEquals(1, ints[1]);
        assertEquals(3, ints[2]);

        ints = signature.reconstruct("DDII");
        assertEquals(3, ints[0]);
        assertEquals(2, ints[1]);
        assertEquals(1, ints[2]);
        assertEquals(4, ints[3]);
        assertEquals(5, ints[4]);
    }
}
