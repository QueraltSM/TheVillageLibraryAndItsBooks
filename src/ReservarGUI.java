import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReservarGUI extends Frame {
    private JFrame main = new JFrame();
    private JTextField nombreusuario = new JTextField(10);
    private JTextField idlibro = new JTextField(5);
    private JPanel a = new JPanel();
    private JPanel b = new JPanel();
    private JButton salir = new JButton("Salir");


    public ReservarGUI(){
        a.setLayout(new GridLayout(2, 1));
        a.add(nombreusuario);
        a.add(idlibro);

        nombreusuario.setText("Nombre usuario");
        idlibro.setText("ID Libro");


        nombreusuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nombreusuario.setText("");
            }
        });

        idlibro.addMouseListener(new MouseAdapter () {
            @Override
            public void mouseClicked(MouseEvent e) {
                idlibro.setText("");
            }
        });


        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI();
                main.dispose();
            }
        });



        b.setLayout(new GridLayout(2, 1));
        b.add(a);
        b.add(salir);
        main.add(b);


        main.setTitle("Reservar GUI");
        main.setLocationRelativeTo(null);
        main.setVisible(true);
        main.setSize(500, 500);

    }
}
