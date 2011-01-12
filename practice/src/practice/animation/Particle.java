package practice.animation;

/**
 * Date: 1/12/11
 */
public class Particle {
    private int direction;
    private int position;

    public Particle(String direction, int position) {
        this.direction = "R".equalsIgnoreCase(direction) ? 1 : -1;
        this.position = position;
    }
    
    public int move(int numberOfSteps) {
        position += direction * numberOfSteps;
        return position;
    }

    public int getPosition() {
        return position;
    }
}
