package com.lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileAnalyzer {

    public static class FileStats {
        private final int lines;
        private final int words;
        private final int characters;

        public FileStats(int lines, int words, int characters) {
            this.lines = lines;
            this.words = words;
            this.characters = characters;
        }

        @Override
        public String toString() {
            return String.format("Строк: %d\nСлов: %d\nСимволов: %d", lines, words, characters);
        }
    }

    public FileStats analyze(String filename) {
        int lines = 0;
        int words = 0;
        int characters = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines++;
                words += countWords(line);
                characters += countCharacters(line);
            }
        } catch (IOException e) {
            System.out.println("Файл не найден!");
            return null;
        }

        return new FileStats(lines, words, characters);
    }

    private int countWords(String line) {
        if (line == null || line.trim().isEmpty()) {
            return 0;
        }
        String[] words = line.trim().split("\\s+");
        return words.length;
    }

    private int countCharacters(String line) {
        if (line == null) {
            return 0;
        }
        return line.replaceAll("\\s", "").length();
    }
}