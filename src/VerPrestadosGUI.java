import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerPrestadosGUI extends JFrame {
    private JFrame main = new JFrame();
    private JList<Usuario> users = new JList<Usuario>();
    private DefaultListModel d = new DefaultListModel();
    private JPanel aux = new JPanel();
    private JButton salir = new JButton("Exit");

    public VerPrestadosGUI(){
        for (Usuario i : GUI.getBiblioteca().usuariosConLibrosPrestados()) {
            d.addElement(i);
        }

        users.setModel(d);
        aux.add(users ,BorderLayout.CENTER);
        aux.add(salir, BorderLayout.SOUTH);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI();
                main.dispose();
            }
        });

        main.add(aux, BorderLayout.NORTH);

        main.setTitle("Ver prestados GUI");
        main.setLocationRelativeTo(null);
        main.setVisible(true);
        main.setSize(500, 300);

    }
}
