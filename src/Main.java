import javax.swing.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                Game game = new Game();
                game.setVisible(true);
            }
        });
    }
}