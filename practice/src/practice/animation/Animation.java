package practice.animation;

/**
 * Date: 1/12/11
 */
public class Animation {
    public String[] animate(int speed, String initialState) {
        Chamber chamber = new Chamber(initialState);
        return chamber.renderAnimation(speed);
    }
}
