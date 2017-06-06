import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibroGUI extends Frame {
    private JFrame main = new JFrame();
    private JTextField nombre = new JTextField(10);
    private JTextField autor = new JTextField(10);

    private JPanel p1 = new JPanel();

    private JButton salir = new JButton("Salir");
    private Button añadir = new Button("Añadir");
    private Button cancelar = new Button("Cancelar");
    private Checkbox poesia;
    private Checkbox novela;
    private Checkbox relato;
    private CheckboxGroup cbg = new CheckboxGroup();

    public LibroGUI(){

        poesia = new Checkbox("Poesía", cbg, false);
        novela  = new Checkbox("Novela", cbg, false);
        relato = new Checkbox("Relato", cbg, false);




        p1.setLayout(new GridLayout(4, 1));
        Panel p = new Panel();
        p.add(new JLabel("Introduce nombre: "));
        p.add(nombre);
        p1.add(p);


        Panel aux = new Panel();
        aux.add(new Label("Introduce autor: "));
        aux.add(autor);
        p1.add(aux);

        Panel aux2 = new Panel();
        aux2.add(novela);
        aux2.add(poesia);
        aux2.add(relato);
        p1.add(aux2);


        Panel aux3 = new Panel();
        aux3.add(salir);
        aux3.add(añadir);
        aux3.add(cancelar);
        p1.add(aux3);


        main.add(p1, BorderLayout.NORTH);



        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autor.setText("");
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
                if (cbg.getSelectedCheckbox().equals(poesia)) {
                    if (GUI.getBiblioteca().añadirLibro(new Poesia(nombre.getText(), autor.getText()))) {
                        JOptionPane.showMessageDialog(LibroGUI.this, "Se ha añadido el libro de poesía");
                    } else {
                        JOptionPane.showMessageDialog(LibroGUI.this, "No se ha añadido el libro de poesía");
                    }
                } else if (cbg.getSelectedCheckbox().equals(relato)) {
                    if (GUI.getBiblioteca().añadirLibro(new Relato(nombre.getText(), autor.getText()))) {
                        JOptionPane.showMessageDialog(LibroGUI.this, "Se ha añadido el relato");
                    } else {
                        JOptionPane.showMessageDialog(LibroGUI.this, "No se ha añadido el relato");
                    }
                } else {
                    if (GUI.getBiblioteca().añadirLibro(new Novela(nombre.getText(), autor.getText()))) {
                        JOptionPane.showMessageDialog(LibroGUI.this, "Se ha añadido la novela.");
                    } else {
                        JOptionPane.showMessageDialog(LibroGUI.this, "No se ha añadido la novela");
                    }
                }
            }
        });







        main.setTitle("Añadir Libro GUI");
        main.setLocationRelativeTo(null);
        main.setVisible(true);
        main.setSize(500, 500);

    }
}
