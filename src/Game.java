import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private JButton OKButton;
    private JPanel panel1;
    private JButton cancelButton;
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    int pcPoint = 0, userPoint = 0;

    public Game() {
        add(panel1);
        setSize(400, 200);
        setTitle("Round");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JOptionPane.showMessageDialog(null,"The first player who reaches 5 points wins.");
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (textField1.getText().toLowerCase().equals("rock") || textField1.getText().toLowerCase().equals("paper") || textField1.getText().toLowerCase().equals("scissor")) {
                    play();
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid value!!");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void play() {

        String pcChoose = null;


        double prediction = Math.floor((Math.random() * 3) + 1);

        String conserve = textField1.getText();
        conserve.toLowerCase();


        switch ((int) prediction) {
            case 1:
                pcChoose = "rock";
                break;
            case 2:
                pcChoose = "scissor";
                break;
            case 3:
                pcChoose = "paper";
                break;

        }


        if (conserve.equals(pcChoose)) {
            JOptionPane.showMessageDialog(null, "It's a tie");
        } else if (conserve.equals("scissor") && pcChoose.equals("paper")) {
            JOptionPane.showMessageDialog(null, "My Answer was paper. Scissor cuts paper. You win!!");
            userPoint++;
        } else if (conserve.equals("paper") && pcChoose.equals("scissor")) {
            JOptionPane.showMessageDialog(null, "My Answer was scissor. Scissor cuts paper. You lose!!!");
            pcPoint++;
        } else if (conserve.equals("rock") && pcChoose.equals("scissor")) {
            JOptionPane.showMessageDialog(null, "My Answer was scissor. Rock breaks scissor. You win!!");
            userPoint++;
        } else if (conserve.equals("scissor") && pcChoose.equals("rock")) {
            JOptionPane.showMessageDialog(null, "My Answer was rock. Rock breaks scissor. You lose!!!");
            pcPoint++;
        } else if (conserve.equals("paper") && pcChoose.equals("rock")) {
            JOptionPane.showMessageDialog(null, "My Answer was rock. Paper eats rock. You win!!");
            userPoint++;
        } else if (conserve.equals("rock") && pcChoose.equals("paper")) {
            JOptionPane.showMessageDialog(null, "My Answer was paper. Paper eats rock. You lose!!!");
            pcPoint++;
        }

        label1.setText("Your Score= " + userPoint + " - My score= " + pcPoint);
        if (userPoint == 5) {
            JOptionPane.showMessageDialog(null, "Congrats! You Win");
            System.exit(0);
        } else if (pcPoint == 5) {
            JOptionPane.showMessageDialog(null, "Sorry! You Lose");
            System.exit(0);
        }
    }


}
