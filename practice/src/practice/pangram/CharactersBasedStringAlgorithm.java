package practice.pangram;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Date: 1/12/11
 */
public class CharactersBasedStringAlgorithm implements StringAlgorithm{
    public final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public String findMissingCharacters(String input) {
        Set<Character> charsInAlphabet = toSet(ALPHABET);
        charsInAlphabet.removeAll(toSet(input));
        return toString(charsInAlphabet);
    }

    private String toString(Set<Character> charsInAlphabet) {
        StringBuilder builder = new StringBuilder();
        for (Character character : charsInAlphabet) {
            builder.append(character);
        }
        return builder.toString();
    }

    private Set<Character> toSet(String input) {
        LinkedHashSet<Character> charSet = new LinkedHashSet<Character>();
        for (Character character : input.toLowerCase().toCharArray()) {
            charSet.add(character);
        }
        return charSet;
    }
    
    /*  A collection of particles is contained in a linear chamber. They all have the same speed, but some are headed toward the right and others are headed toward the left. These particles can pass through each other without disturbing the motion of the particles, so all the particles will leave the chamber relatively quickly.

You will be given the initial conditions by a String init containing at each position an 'L' for a leftward moving particle, an 'R' for a rightward moving particle, or a '.' for an empty location. init shows all the positions in the chamber. Initially, no location in the chamber contains two particles passing through each other.

We would like an animation of the process. At each unit of time, we want a string showing occupied locations with an 'X' and unoccupied locations with a '.'. Create a class Animation that contains a method animate that is given an int speed and a String init giving the initial conditions. The speed is the number of positions each particle moves in one time unit.

The method will return an array of strings in which each successive element shows the occupied locations at the next time unit. The first element of the return should show the occupied locations at the initial instant (at time = 0) in the 'X', '.' format. The last element in the return should show the empty chamber at the first time that it becomes empty.

    * */
}
