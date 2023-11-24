package viselitsa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordsPool {

    private final ArrayList<String> words = new ArrayList<>();
    private int number = 0;
    private final File file = new File("russian_nouns.txt");

    public WordsPool() {
    }

    private void makeListOfWords() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
                number++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandomWord() {
        makeListOfWords();
        Random random = new Random();
        int a = random.nextInt(number);
        return words.get(a);
    }

    public String getZalupa(char[] word, char letter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length; i++) {
            if (word[i] == letter) {
                sb.append(letter);
            } else {
                sb.append('_');
            }
        }
        return sb.toString();
    }

    public String makeZalupa(char[] word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length; i++) {
            sb.append('_');
        }
        return sb.toString();
    }
}
