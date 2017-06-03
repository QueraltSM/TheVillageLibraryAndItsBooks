import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private static Biblioteca b = new Biblioteca();

    private JFrame main = new JFrame();
    private JList<Libro> listalibros = new JList<Libro>();
    private DefaultListModel dlm = new DefaultListModel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p = new JPanel();
    private JPanel aux = new JPanel();

    private JButton añadirlibro = new JButton("Añadir libro");
    private JButton añadirUsuario = new JButton("Añadir usuario");

    private JRadioButton portitulo = new JRadioButton("Por titulo");
    private JRadioButton porautor = new JRadioButton("Por autor");
    private ButtonGroup bg = new ButtonGroup();

    private JButton salir = new JButton("Salir"); // esquina derecha del sur

    private JPanel sur = new JPanel();
    private JPanel sureste = new JPanel();
    private JPanel sursureste = new JPanel();


    private JScrollBar derecha = new JScrollBar();





    public static Biblioteca getBiblioteca(){
        return b;
    }

    public static void main(String[] args)
    {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception e){

        }

        new GUI();
    }


    public GUI(){
        init();



        aux.setLayout(new GridLayout(4,1));
        bg.add(porautor);
        bg.add(portitulo);


        for (Libro i : b.todosLosLibros()) {
            dlm.addElement(i);
        }

        JPanel a = new JPanel();
        listalibros.setModel(dlm);
        a.add(listalibros);
        a.add(derecha);

        p1.add(a, BorderLayout.CENTER);


        p2.setLayout(new FlowLayout());
        p2.add(añadirUsuario);

        añadirUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new UsuarioGUI();
                main.dispose();
            }
        });


        añadirlibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LibroGUI();
                main.dispose();
            }
        });

        p2.add(añadirlibro);

        p.add(new Label("Ordenar por: "));
        p.add(porautor);
        p.add(portitulo);

        aux.add(p1);
        aux.add(p2);
        aux.add(p);



        //sureste.add(salir, BorderLayout.EAST);
        main.add(sur, BorderLayout.SOUTH);
        sur.add(salir, BorderLayout.EAST);

        main.add(aux, BorderLayout.CENTER);




        main.setTitle("Biblioteca GUI");
        main.setLocationRelativeTo(null);
        main.setVisible(true);
        main.setSize(500, 500);

    }


    public void init(){
        Poesia p = new Poesia("Federico García Lorca","Romancero Gitano");
        Poesia p2 = new Poesia("Gustavo Adolfo Bécquer","Rimas y Leyendas");
        Novela n = new Novela("Vladimir Nabókov", "Lolita");
        Novela n2 = new Novela("Alexandre Dumas", "El conde de Monte Cristo");
        Relato r = new Relato("Lady Boopy", "La Manzana");
        Relato r2 = new Relato("Tejas verdes", "Hernán Valdés");

        Usuario u1 = new Usuario("Jorge", "García");
        Usuario u2 = new Usuario("Víctor", "López");
        Usuario u3 = new Usuario("Aarón", "Velázquez");

        b.añadirUsuario(u1);
        b.añadirUsuario(u2);
        b.añadirUsuario(u3);

        b.añadirLibro(p);
        b.añadirLibro(p2);
        b.añadirLibro(n);
        b.añadirLibro(r);
        b.añadirLibro(n2);
        b.añadirLibro(r2);

        u1.reservarLibro(p);
        u1.reservarLibro(p2);
        u2.reservarLibro(p);

    }
}
