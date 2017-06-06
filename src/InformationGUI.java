import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InformationGUI extends JFrame {
    private JFrame main = new JFrame();
    private JTextArea ta = new JTextArea(20, 20);
    private JPanel p = new JPanel();
    private JButton salir = new JButton("Salir");


    public InformationGUI(){
        main.add(p, BorderLayout.NORTH);
        main.add(salir, BorderLayout.CENTER);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI();
                main.dispose();
            }
        });


        main.setTitle("Information GUI");
        main.setLocationRelativeTo(null);
        main.setVisible(true);
        main.setSize(500, 500);

    }
}
