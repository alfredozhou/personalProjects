package codingtournament.practice.feb_22_2009;

import junit.framework.TestCase;
import codingtournament.practice.feb_22_2009.HowEasy;

/**
 * Created by IntelliJ IDEA.
 * User: zxzhou
 * Date: Feb 22, 2009
 * Time: 2:29:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class HowEasyTest extends TestCase {
    public void testHowEasy() {
        HowEasy easy = new HowEasy();
        int returnValue = easy.pointVal("This is a problem statement");
        assertEquals("the value should be correct", 500, returnValue);
        returnValue = easy.pointVal("523hi.");
        assertEquals("the value should be correct", 250, returnValue);
        returnValue = easy.pointVal("Implement a class H5 which contains some method.");
        assertEquals("the value should be correct", 500, returnValue);
        returnValue = easy.pointVal(" no9 . wor7ds he8re. hj..");
        assertEquals("the value should be correct", 250, returnValue);
        returnValue = easy.pointVal(" ");
        assertEquals("the value should be correct", 250, returnValue);
    }
}
