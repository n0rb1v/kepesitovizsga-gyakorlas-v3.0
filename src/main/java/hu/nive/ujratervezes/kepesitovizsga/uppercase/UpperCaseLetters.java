package hu.nive.ujratervezes.kepesitovizsga.uppercase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UpperCaseLetters {
    public int getNumberOfUpperCase(String s) {
        try (BufferedReader bf = Files.newBufferedReader(Path.of("src/main/resources/characters.txt"))) {
            String line;
            int sum = 0;
            while ((line = bf.readLine()) != null) {
                for (char item : line.toCharArray()) {
                    if (Character.isUpperCase(item)) {
                        sum++;
                    }
                }
            }
            writeFile("" + sum);
            return sum;
        } catch (IOException e) {
            throw new IllegalStateException("file error");
        }
    }

    private void writeFile(String s) {
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/main/resources/out.txt"))) {
            bw.write(s + "\n");
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file", e);
        }
    }
}
