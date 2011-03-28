package codingtournament.practice.feb_22_2009;

import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HowEasy {
    private Pattern pattern = Pattern.compile("[a-zA-Z]+");

    public int pointVal(String param0) {
        List tokens = tokenize(param0);
        List words = findWords(tokens);
        int totalNumberOfLetters = sumUpWordLength(words);
        int avgWordLength = 0;
        try {
            avgWordLength = totalNumberOfLetters / words.size();
        } catch (Exception e) {
            return 250;
        }
        if (avgWordLength <= 3)
            return 250;
        else if (avgWordLength <= 5)
            return 500;
        return 1000;
    }

    private int sumUpWordLength(List words) {
        int totalNumberOfCharacters = 0;
        for (int i = 0; i < words.size(); i++) {
            Object thing = words.get(i);
            Word word = (Word) thing;
            totalNumberOfCharacters += word.getWordLength();
        }
        return totalNumberOfCharacters;  //To change body of created methods use File | Settings | File Templates.
    }

    private List findWords(List tokens) {
        List words = new ArrayList();
        for (int i = 0; i < tokens.size(); i++) {
            Object token = tokens.get(i);
            String word = (String) token;
            if (isWord(word, pattern))
                words.add(new Word(word));
        }
        return words;
    }

    public boolean isWord(String word, Pattern pattern) {
        Matcher matcher = pattern.matcher(word);
        boolean onlyAlphabetic = matcher.matches();
        if (onlyAlphabetic)
            return true;
        String subWord = word.substring(0, word.length() > 0 ? word.length() - 1 : 0);
        matcher = pattern.matcher(subWord);
        boolean subwordHasOnlyAlphabet = matcher.matches();
        return subwordHasOnlyAlphabet && hasDot(word);
    }

    private boolean hasDot(String word) {
        char lastChar = word.charAt( word.length() - 1);
        return lastChar=='.';
    }

    private List tokenize(String param0) {
        StringTokenizer tokenizer = new StringTokenizer(param0);
        List tokens = new ArrayList();
        while (tokenizer.hasMoreTokens())
            tokens.add(tokenizer.nextToken());
        return tokens;
    }

    private class Word {
        private String word;
        private int wordLength;

        Word(String value) {
            word = value;
            setWordLength(value);
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getWordLength() {
            return wordLength;
        }

        public void setWordLength(String word) {
            if (hasDot(word))
                this.wordLength = word.length() - 1;
            else
                this.wordLength = word.length();
        }
    }
}
