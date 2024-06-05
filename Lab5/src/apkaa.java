import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class apkaa {
    private JTextField textField1;  // Liczba wygenerowanych liczb
    private JTextField textField2;  // Seed
    private JTextField textField3;  // Capacity
    private JTextField textField4;  // Wynik
    private JTextField textField5;  // Wszystkie wygenerowane liczby
    private JButton button1;        // Przycisk do uruchamiania obliczeń
    private JPanel panel1;          // Panel główny
    private JLabel Capacity;
    private JTextArea textArea1;
    private JTextArea textArea2;

    public apkaa() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int liczbaPrzedmiotów = Integer.parseInt(textField1.getText());
                    long seed = Long.parseLong(textField2.getText());
                    int capacity = Integer.parseInt(textField3.getText());

                    Problem problem = new Problem(liczbaPrzedmiotów, seed, 1, 10);
                    textArea1.setText(problem.toString());

                    Result result = problem.solve(capacity);
                    textArea2.setText(result.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel1, "Proszę wprowadzić poprawne dane wejściowe.");
                }
            }
        });
    }

    
    public static void main(String[] args) {
        JFrame frame = new JFrame("apkaa");
        frame.setContentPane(new apkaa().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}

//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class apkaa {
//    private JTextField textField1;  // Liczba wygenerowanych liczb
//    private JTextField textField2;  // Seed
//    private JTextField textField3;  // Capacity
//    private JTextField textField4;  // Wynik
//    private JTextField textField5;  // Wszystkie wygenerowane liczby
//    private JButton button1;        // Przycisk do uruchamiania obliczeń
//    private JPanel panel1;          // Panel główny
//    private JLabel Capacity;
//
//    public apkaa() {
//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    int liczbaPrzedmiotów = Integer.parseInt(textField1.getText());
//                    long seed = Long.parseLong(textField2.getText());
//                    int capacity = Integer.parseInt(textField3.getText());
//
//                    // Stwórz instancję problemu plecakowego
//                    Problem problem = new Problem(liczbaPrzedmiotów, seed, 1, 100);
//                    Result result = problem.solve(capacity);
//
//                    // Wyświetl wyniki
//                    textField4.setText(result.toString());
//                    textField5.setText(problem.toString());
//                } catch (NumberFormatException ex) {
//                    JOptionPane.showMessageDialog(panel1, "Proszę wprowadzić poprawne dane wejściowe.");
//                }
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("apkaa");
//        frame.setContentPane(new apkaa().panel1);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    private void createUIComponents() {
//        // Custom component creation code
//    }
//}
//
////import javax.swing.*;
////
////public class apkaa {
////    private JTextField textField1;
////    private JTextField textField2;
////    private JTextField textField3;
////    private JTextField textField4;
////    private JTextField textField5;
////    private JButton button1;
////    private JLabel Capacity;
////
////
////    private void createUIComponents() {
////    }
////}
