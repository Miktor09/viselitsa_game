package viselitsa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class GameManager {

    WordsPool wp = new WordsPool();
    private final String word = "хуй";
    private final char[] aboba = word.toCharArray();
    private String zalupa = wp.makeZalupa(aboba);
    private Hashtable<Character, ArrayList<Integer>> letters = new Hashtable<>();
    private final ArrayList<Character> mistakes = new ArrayList<>();
    private String head = " ";
    private String larm = " ";
    private String body = " ";
    private String rarm = " ";
    private String lleg = " ";
    private String rleg = " ";

    private Hashtable<Character, ArrayList<Integer>> convert(String word) {
        Hashtable<Character, ArrayList<Integer>> a = new Hashtable<>();
        for (int i = 0; i < aboba.length; i++) {
            if (!a.containsKey(aboba[i])) {
                ArrayList<Integer> c = new ArrayList<>();
                c.add(i);
                a.put(aboba[i], c);
            } else {
                ArrayList<Integer> c = a.get(aboba[i]);
                c.add(i);
                a.put(aboba[i], c);
            }
        }
        System.out.println(a);
        return a;
    }

    public void play() {
        System.out.println("Игра началась!");
        System.out.println("Ввводите только буквы в нижнем регистре!");
        System.out.println(aboba);
        letters = convert(word);
        Paint();
        while (mistakes.size() < 6) {
            System.out.println("Ввведите букву:");
            char answer;
            try {
                answer = (char) System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (letters.containsKey(answer)) {
                zalupa = wp.getZalupa(aboba, answer);
                Paint();
            } else {
                switch (mistakes.size()) {
                    case (1):
                        head = "0";
                        break;
                    case (2):
                        body = "|";
                        break;
                    case (3):
                        larm = "/";
                        break;
                    case (4):
                        rarm = "\\";
                        break;
                    case (5):
                        lleg = "/";
                        break;
                    case (6):
                        head = "\\";
                        break;
                }
                Paint();
            }
            if (zalupa.equals(word)) {
                break;
            }
        }
        if (mistakes.size() < 6) {
            System.out.println("Вы выиграли!");
        } else {
            System.out.println("Вы проиграли(");
        }
    }

    public String getWord() {
        return word;
    }

    public ArrayList<Character> getMistakes() {
        return mistakes;
    }

    private void Paint() {
        System.out.println("  __  ");
        System.out.println(" |  | ");
        System.out.println(" " + head + "  | ");
        System.out.println(larm + body + rarm + " | ");
        System.out.println(lleg + " " + rleg + " | ");
        System.out.println("    | ");
        System.out.println("   ___");
        System.out.println(zalupa);
    }
}
