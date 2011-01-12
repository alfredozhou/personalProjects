package practice;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Date: 1/12/11
 */
public class HashSetBasedStringAlgorithm implements StringAlgorithm{
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
}
