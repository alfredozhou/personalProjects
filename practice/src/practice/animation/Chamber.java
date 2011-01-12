package practice.animation;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 1/12/11
 */
public class Chamber {
    private int roomLength;
    private List<Particle> particles = new ArrayList<Particle>();
    private String currentStateOfTheRoom;

    public Chamber(String initialState) {
        roomLength = initialState.length();
        initializeParticles(initialState.split("(?!^)"));
    }

    private void initializeParticles(String[] initialState) {
        for (int i = 0; i < initialState.length; i++) {
            String character = initialState[i];
            if (!".".equalsIgnoreCase(character)) {
                particles.add(new Particle(character, i));
            }
        }
        currentStateOfTheRoom = putParticlesIn(emptyRoom(), particles);
    }

    public String[] renderAnimation(int speed) {
        ArrayList <String> animations = new ArrayList<String>();
        animations.add(currentStateOfTheRoom);
       
        while (animationNotDone()) {
            updateTheParticles(speed);
            currentStateOfTheRoom = putParticlesIn(emptyRoom(), particles);
            animations.add(currentStateOfTheRoom);
        }
       
        return animations.toArray(new String[animations.size()]);
    }

    private void updateTheParticles(int speed) {
        for (Particle particle : particles) {
            particle.move(speed);
        }
    }

    private char[] emptyRoom() {
        char[] roomLayout = new char[roomLength];
        for (int i = 0; i < roomLength; i++) {
            roomLayout[i] = '.';
        }
        return roomLayout;
    }

    private String putParticlesIn(char[] room, List<Particle> particles) {
        for (Particle particle : particles) {
            int currentPosition = particle.getPosition();
            if (currentPosition < room.length && currentPosition >= 0)
                room[currentPosition] = 'X';
        }
        return new String (room); 
    }

    private boolean animationNotDone() {
        return currentStateOfTheRoom.contains("X");
    }
}
