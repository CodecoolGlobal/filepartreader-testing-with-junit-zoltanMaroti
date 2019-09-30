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
}
