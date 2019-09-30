package main.java.com.codecool.filePartReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = - 1;
        this.toLine = - 1;
    }

    public void setup (String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine) throw new IllegalArgumentException("toLine can't be smaller than fromLine");
        if (fromLine < 1) throw new IllegalArgumentException("fromLine must be bigger than 0");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public String readLines() throws IOException {
        String originalText = read();
        String[] splittedText = originalText.split(System.lineSeparator());
        String[] selectedLines = Arrays.copyOfRange(splittedText, fromLine - 1, toLine);
        return String.join(" ", selectedLines);

    }
}
