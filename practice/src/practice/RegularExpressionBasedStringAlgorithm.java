package practice;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

/**
 * Date: 1/12/11
 */
public class RegularExpressionBasedStringAlgorithm implements StringAlgorithm {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public String findMissingCharacters(String string) {
        Set<String> alphabetAsStrings = toSetOfCharStrings(ALPHABET);
        alphabetAsStrings.removeAll(toSetOfCharStrings(string));
        return asString(alphabetAsStrings);
    }

    private Set<String> toSetOfCharStrings(String string) {
        List<String> listOfCharactersInLowerCase = asList(string.toLowerCase().split("(?!^)"));
        return new LinkedHashSet<String>(listOfCharactersInLowerCase);
    }

    private String asString(Set<String> alphabetAsStrings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String alphabetAsString : alphabetAsStrings) {
            stringBuilder.append(alphabetAsString);
        }
        return stringBuilder.toString();
    }
}
