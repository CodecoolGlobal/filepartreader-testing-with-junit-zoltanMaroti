package main.java.com.codecool.filePartReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {

    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String originalText = filePartReader.readLines().replaceAll("[.]*[,]*\\n*", "");
        List<String> splittedText = Arrays.asList(originalText.split("\\W"));
        splittedText.sort(String::compareToIgnoreCase);
        return splittedText;
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        List<String> wordsContainingSubstring = new ArrayList<>();
        String originalText = filePartReader.readLines().replaceAll("[.]*[,]*\\n*", "");
        String[] splittedText = originalText.split("\\W");
        for (String word: splittedText) {
            if (word.contains(subString)) {
                wordsContainingSubstring.add(word);
            }
        }
        return wordsContainingSubstring;
    }
}
