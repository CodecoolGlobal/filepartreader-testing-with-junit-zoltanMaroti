import main.java.com.codecool.filePartReader.FilePartReader;
import main.java.com.codecool.filePartReader.FileWordAnalyzer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    @Test
    public void testGetWordsOrderedAlphabetically() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("/Users/Home/Codecool/OOP/5th-SI-week/filepartreader-testing-with-junit-zoltanMaroti/src/main/resources/text.txt", 3, 5);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        fileWordAnalyzer.getWordsOrderedAlphabetically();
        List<String> expected = Arrays.asList("ac", "aliquam", "amet", "arcu", "blandit", "dolor", "Donec", "egestas",
                "eleifend", "erat", "eu", "In", "justo", "laoreet", "mauris", "nec", "nulla", "pellentesque",
                "porttitor", "Proin", "sed", "sit", "tincidunt", "urna", "Ut");

        assertEquals(expected, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

}
