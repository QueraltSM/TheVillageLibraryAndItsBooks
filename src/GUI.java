import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private static Biblioteca b = new Biblioteca();
    private JPanel a = new JPanel();
    private JFrame main = new JFrame();
    private JList<String> listalibros = new JList<String>();
    private DefaultListModel dlm = new DefaultListModel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p = new JPanel();
    private JPanel aux = new JPanel();

    /* Añadir ScrollBar y action Information jlist element */

    private JButton añadirlibro = new JButton("Añadir libro");
    private JButton añadirUsuario = new JButton("Añadir usuario");

    private JButton verprestados = new JButton("Ver prestados");
    private JButton reservar = new JButton("Reservar libro");

    private JRadioButton portitulo = new JRadioButton("Por titulo");
    private JRadioButton porautor = new JRadioButton("Por autor");
    private ButtonGroup bg = new ButtonGroup();

    private JButton salir = new JButton("Salir"); // esquina derecha del sur
    private JPanel sur = new JPanel();
    private JScrollBar derecha = new JScrollBar();


    public GUI(){
        init();

        porautor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista(1);
            }
        });

        portitulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista(0);
            }
        });


        aux.setLayout(new GridLayout(4,1));
        bg.add(porautor);
        bg.add(portitulo);

        a.add(listalibros);
        a.add(derecha);
        p1.add(a, BorderLayout.NORTH);


        p2.setLayout(new GridLayout(2, 1));

        JPanel aux4 = new JPanel();
        aux4.setLayout(new FlowLayout());
        aux4.add(añadirlibro);
        aux4.add(añadirUsuario);




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

        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReservarGUI();
                main.dispose();
            }
        });


        verprestados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VerPrestadosGUI();
                main.dispose();
            }
        });


        JPanel aux3 = new JPanel();
        aux3.setLayout(new FlowLayout());
        aux3.add(verprestados);
        aux3.add(reservar);

        p2.add(aux4);
        p2.add(aux3);


        p.add(new Label("Ordenar por: "));
        p.add(porautor);
        p.add(portitulo);


        aux.add(p1);
        aux.add(p2);
        aux.add(p);

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
        Poesia p2 = new Poesia("Gustavo Adolfo Bécquer","Amor Eterno");
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

        portitulo.setSelected(true);
        lista(0);

    }

    public void lista (int n) {
        // zona de reset
        listalibros.removeAll();
        dlm.removeAllElements();
        // ---- fin zona

        if (n==0) {
            // por titulo
            b.setOrden(0);
        } else {
            // por autor
            b.setOrden(1);
        }


        for (Libro l : b.getOrden()) {
            dlm.addElement(l);
        }
        listalibros.setModel(dlm);
    }


    public static Biblioteca getBiblioteca(){
        return b;
    }

    public static void main(String[] args) {
        new GUI();
    }

}


