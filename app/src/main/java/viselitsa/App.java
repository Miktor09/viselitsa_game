/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package viselitsa;

import java.io.IOException;

public class App {


    public static void main(String[] args) {

        char start;
        GameManager gm = new GameManager();
        System.out.println("Вы хотите начать игру?");
        System.out.println("Введите 1 для начала игры или 0 для прекращения игры");
        try {
            start = (char) System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (start == '1') {
            gm.play();
            System.out.println("Сыграем еще?");
            System.out.println("1 - начать игру, 0 - прекратить");
        }


    }
}
