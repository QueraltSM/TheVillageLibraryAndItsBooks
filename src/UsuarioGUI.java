import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioGUI extends JFrame {

    private JFrame main = new JFrame();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JDialog dialogo = new JDialog();


    private JTextField nombre = new JTextField(10);
    private JTextField apellidos = new JTextField(10);

    private JPanel p4 = new JPanel();
    private JButton añadir = new JButton("Añadir");
    private JButton cancelar = new JButton("Cancelar");
    private JButton salir = new JButton("Salir");





    public UsuarioGUI(){
        p3.setLayout(new FlowLayout());

        p1.add(new Label("Introduce nombre: "));
        p1.add(nombre);
        p3.add(p1, BorderLayout.NORTH);


        p2.add(new Label("Introduce apellidos: "));
        p2.add(apellidos);
        p3.add(p2, BorderLayout.CENTER);

        p4.setLayout(new FlowLayout());
        p4.add(salir);
        p4.add(añadir);
        p4.add(cancelar);
        p3.add(p4, BorderLayout.SOUTH);

        main.add(p3);



        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apellidos.setText("");
                nombre.setText("");
            }
        });


        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUI();
                main.dispose();
            }
        });

        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (GUI.getBiblioteca().añadirUsuario(new Usuario(nombre.getText(), apellidos.getText()))){
                    JOptionPane.showMessageDialog(UsuarioGUI.this, "Se ha añadido el usuario");
                } else {
                    JOptionPane.showMessageDialog(UsuarioGUI.this, "No se ha podido añadir");
                }


            }
        });

        main.setTitle("Nuevo Usuario");
        main.setVisible(true);
        main.setSize(500, 500);

    }
}
