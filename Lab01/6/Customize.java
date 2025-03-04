import javax.swing.JOptionPane;

public class Customize {
    public static void main(String[] args) {
        String[] options = {"I do", "I don't"};
        int choice = JOptionPane.showOptionDialog( null, "Do you agree ", "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );


        JOptionPane.showMessageDialog(null, "You have chosen: " + options[choice]);
        System.exit(0);
    }
}
