package practice.animation;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Date: 1/12/11
 */
public class AnimationTest {
    @Test
    public void shouldWork() throws Exception {
        Animation animation = new Animation();

        String[] animatedStrings = animation.animate(2, "..R....");
        
        assertThat(animatedStrings.length, equalTo(4));
        assertThat(animatedStrings[0], equalTo("..X...."));
        assertThat(animatedStrings[1], equalTo("....X.."));
        assertThat(animatedStrings[2], equalTo("......X"));
        assertThat(animatedStrings[3], equalTo("......."));
    }

}
