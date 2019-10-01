package main.java.com.codecool.filePartReader;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenToLineIsSmallerThenFromLine() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("/Users/Home/Codecool/OOP/5th-SI-week/filepartreader-testing-with-junit-zoltanMaroti/src/main/resources/text.txt", 5, 1));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFromLineIsSmallerThen1() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("/Users/Home/Codecool/OOP/5th-SI-week/filepartreader-testing-with-junit-zoltanMaroti/src/main/resources/text.txt", - 1, 1));
    }

    @Test
    public void shouldThrowIOException() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/nope.txt", 1, 2);
        assertThrows(IOException.class, () -> filePartReader.read());
    }


    @Test
    public void testReader() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("/Users/Home/Codecool/OOP/5th-SI-week/filepartreader-testing-with-junit-zoltanMaroti/src/main/resources/text.txt", 1, 1);

        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                "Integer tempor pulvinar nunc, et malesuada quam convallis blandit.\n" +
                "Proin blandit pellentesque nulla nec aliquam.\n" +
                "Ut ac tincidunt erat. Donec sed eleifend dolor.\n" +
                "In justo mauris, laoreet eu urna sit amet, egestas porttitor arcu.\n" +
                "Morbi pharetra, neque vitae pellentesque posuere, justo dui suscipit justo, vitae convallis eros felis sed arcu.\n" +
                "Pellentesque sit amet ultrices erat, nec aliquam nulla.\n" +
                "Proin et tellus non quam interdum luctus nec quis lectus.\n" +
                "Praesent porttitor urna et elit egestas, at rutrum nisl vehicula.\n" +
                "Proin gravida interdum rhoncus. Pellentesque efficitur neque ut viverra volutpat.\n", filePartReader.read());
    }

    @Test
    public void testReadLines() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("/Users/Home/Codecool/OOP/5th-SI-week/filepartreader-testing-with-junit-zoltanMaroti/src/main/resources/text.txt", 2, 2);

        assertEquals("Integer tempor pulvinar nunc, et malesuada quam convallis blandit.", filePartReader.readLines());
    }


}
