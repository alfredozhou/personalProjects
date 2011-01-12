package practice.pangram;

import org.junit.Test;
import practice.pangram.StringAlgorithm;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Date: 1/12/11
 */
public abstract class AbstractStringAlgorithmTest <T extends StringAlgorithm>{
    @Test
    public void CanFindLeftOvers() throws Exception {
        T leftOvers = makeClassUnderTest();
        assertThat(leftOvers.findMissingCharacters("A quick brown fox jumps over the lazy dog"), equalTo(""));
        assertThat(leftOvers.findMissingCharacters("A slow yellow fox crawls under the proactive dog"), equalTo("bjkmqz"));
        assertThat(leftOvers.findMissingCharacters("Lions, and tigers, and bears, oh my!"), equalTo("cfjkpquvwxz"));
        assertThat(leftOvers.findMissingCharacters(""), equalTo("abcdefghijklmnopqrstuvwxyz"));
    }

    protected abstract T makeClassUnderTest() ;
}
