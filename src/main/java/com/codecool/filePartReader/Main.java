package main.java.com.codecool.filePartReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("/Users/Home/Codecool/OOP/5th-SI-week/filepartreader-testing-with-junit-zoltanMaroti/src/main/resources/text.txt", 1, 10);

        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        System.out.println(fileWordAnalyzer.getWordsContainingSubstring("us"));
    }
}
