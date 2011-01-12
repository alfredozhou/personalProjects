package practice;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Date: 1/12/11
 */
public class StringLeftOvers {
    public final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public String findMissingCharacters(String input) {
        Set<Character> charsInAlphabet = toSet(ALPHABET);
        charsInAlphabet.removeAll(toSet(input));
        return toString(charsInAlphabet);
    }

    private String toString(Set<Character> charsInAlphabet) {
        Object[] arrayOfChars = charsInAlphabet.toArray();
        char[] stringChars = new char[arrayOfChars.length];
        for (int i = 0; i < arrayOfChars.length; i++) {
            Object character = arrayOfChars[i];
            stringChars[i] = ((Character) character).charValue();
        }
        return new String(stringChars);
    }

    private Set<Character> toSet(String input) {
        char[] chars = input.toLowerCase().toCharArray();
        LinkedHashSet<Character> charSet = new LinkedHashSet<Character>();
        for (Character character : chars) {
            charSet.add(character);
        }
        return charSet;
    }
}
