import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Check if exactly one argument (the file path) is provided
        if (args.length != 1) {
            System.out.println("Usage: java ReadabilityScoreAnalyzer <file_path.txt>");
            return;
        }

        // Check if the provided argument ends with a .txt extension
        if (!args[0].endsWith(".txt")) {
            System.out.println("Error: The program accepts only text files with a .txt extension.");
            return;
        }

        // Check if the provided path points to an existing file
        File file = new File(args[0]);
        if (!file.exists() || !file.isFile()) {
            System.out.println("Error: The specified file does not exist.");
            return;
        }

        try {
            // Read the content of the text file
            String text = Files.readString(Paths.get(args[0]));
            System.out.println("The text is:");
            System.out.println(text);
            System.out.println();

            // Call the method to analyze the text and display readability scores
            displayReadabilityScores(text);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static double readabilityScore(String text) {
        long chars = charsCount(text);
        long words = wordCount(text);
        long sentences = sentenceCount(text);
        return 4.71 * chars / words + 0.5 * words / sentences - 21.43;
    }

    public static long charsCount(String text) {
        return text.replaceAll("\\s+", "").length();
    }

    public static long wordCount(String text) {
        return text.split("\\s+").length;
    }

    public static long sentenceCount(String text) {
        return text.split("[.!?]+").length;
    }

    public static long syllableCount(String word) {
        word = word.toLowerCase().replaceAll("e$", "").replaceAll("[aeiouy]{2}", "a").replaceAll("[^aeiouy]", "");
        return Math.max(word.length(), 1);
    }

    public static long totalSyllables(String text) {
        long count = 0;
        for (String word : text.split("\\s+")) {
            count += syllableCount(word);
        }
        return count;
    }

    public static long polysyllableCount(String text) {
        long count = 0;
        for (String word : text.split("\\s+")) {
            long sylCount = syllableCount(word);
            if (sylCount > 2) {
                count++;
            }
        }
        return count;
    }

    public static double fleschKincaidScore(long words, long sentences, long syllables) {
        return 0.39 * (double) words / sentences + 11.8 * (double) syllables / words - 15.59;
    }

    public static double smogIndex(long polysyllables, long sentences) {
        return 1.043 * Math.sqrt(polysyllables * 30.0 / sentences) + 3.1291;
    }

    public static double colemanLiauIndex(long words, long sentences, long characters) {
        double L = (double) characters / words * 100;
        double S = (double) sentences / words * 100;
        return 0.0588 * L - 0.296 * S - 15.8;
    }

    public static void displayReadabilityScores(String text) {
        long words = wordCount(text);
        long sentences = sentenceCount(text);
        long characters = charsCount(text);
        long syllables = totalSyllables(text);
        long polysyllables = polysyllableCount(text);

        // Displaying word, sentence, character, syllable, and polysyllable counts
        System.out.printf("Words: %d\n", words);
        System.out.printf("Sentences: %d\n", sentences);
        System.out.printf("Characters: %d\n", characters);
        System.out.printf("Syllables: %d\n", syllables);
        System.out.printf("Polysyllables: %d\n", polysyllables);

        // Calculating and displaying readability scores
        double ariScore = readabilityScore(text);
        double fkScore = fleschKincaidScore(words, sentences, syllables);
        double smogScore = smogIndex(polysyllables, sentences);
        double clScore = colemanLiauIndex(words, sentences, characters);

        System.out.printf("Automated Readability Index: %.2f (about %s-year-olds).\n", ariScore, ageBracket((int) Math.round(ariScore)));
        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s-year-olds).\n", fkScore, ageBracket((int) Math.round(fkScore)));
        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s-year-olds).\n", smogScore, ageBracket((int) Math.round(smogScore)));
        System.out.printf("Coleman–Liau index: %.2f (about %s-year-olds).\n", clScore, ageBracket((int) Math.round(clScore)));
    }


    public static String ageBracket(int score) {
        if (score <= 1) return "5-6";
        if (score == 2) return "6-7";
        if (score == 3) return "7-8";
        if (score == 4) return "8-9";
        if (score == 5) return "9-10";
        if (score == 6) return "10-11";
        if (score == 7) return "11-12";
        if (score == 8) return "12-13";
        if (score == 9) return "13-14";
        if (score == 10) return "14-15";
        if (score == 11) return "15-16";
        if (score == 12) return "16-17";
        if (score == 13) return "17-18";
        return "18-24";
    }
}
