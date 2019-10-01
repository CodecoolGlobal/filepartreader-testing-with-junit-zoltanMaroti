import main.java.com.codecool.filePartReader.FilePartReader;
import main.java.com.codecool.filePartReader.FileWordAnalyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    FileWordAnalyzer fileWordAnalyzer = null;

    @BeforeEach
    public void setUp() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("/Users/Home/Codecool/OOP/5th-SI-week/filepartreader-testing-with-junit-zoltanMaroti/src/main/resources/text.txt", 3, 5);
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }

    @Test
    public void testGetWordsOrderedAlphabetically() throws IOException {
        List<String> expected = Arrays.asList("ac", "aliquam", "amet", "arcu", "blandit", "dolor", "Donec", "egestas",
                "eleifend", "erat", "eu", "In", "justo", "laoreet", "mauris", "nec", "non", "nulla", "pellentesque",
                "porttitor", "Proin", "sed", "sit", "tincidunt", "urna", "Ut");

        assertEquals(expected, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void testGetWordsContainingSubStrings() throws IOException {
        List<String> expected = Arrays.asList("pellentesque", "egestas");

        assertEquals(expected, fileWordAnalyzer.getWordsContainingSubstring("es"));
    }

    @Test
    public void testGetStringsWhichPalindromes() throws IOException {
        List<String> expected = Arrays.asList("non");

        assertEquals(expected, fileWordAnalyzer.getStringsWhichPalindromes());
    }
}
