package practice;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Date: 1/12/11
 */
public class StringLeftOversTest {
    @Test
    public void CanFindLeftOvers() throws Exception {
        StringLeftOvers leftOvers = new StringLeftOvers();
        assertThat(leftOvers.findMissingCharacters("A quick brown fox jumps over the lazy dog"), equalTo(""));
        assertThat(leftOvers.findMissingCharacters("A slow yellow fox crawls under the proactive dog"), equalTo("bjkmqz"));
        assertThat(leftOvers.findMissingCharacters("Lions, and tigers, and bears, oh my!"), equalTo("cfjkpquvwxz"));
        assertThat(leftOvers.findMissingCharacters(""), equalTo("abcdefghijklmnopqrstuvwxyz"));
    }
}