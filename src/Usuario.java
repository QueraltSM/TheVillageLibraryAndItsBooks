/**
 * Created by QSM on 2/6/17.
 */
import java.util.*;

public class Usuario implements Comparable<Usuario> {

    private SortedSet<Usuario> usuariosbiblioteca = Biblioteca.getUsuarios();
    private SortedSet<Libro> librosbiblioteca = Biblioteca.getLibros();

    private String nombre, apellidos;
    private ArrayList<Libro>libros = new ArrayList<Libro>();
    private static int maxId = 0;
    private int idUser;
    private int librosprestados;

    public Usuario(String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
        idUser = ++maxId;
        librosprestados = 0;
    }

    public int getlibrosprestados(){
        return librosprestados;
    }

    public boolean reservarLibro(Libro l){
        if (!librosbiblioteca.contains(l) || l.getEstado()
                || !usuariosbiblioteca.contains(getUsuario()) || librosprestados>=7) return false;
            libros.add(l);
            librosprestados++;
            l.setEstado(true);
            return true;
    }

    public Usuario getUsuario(){
        return this;
    }

    public int getId(){
        return idUser;
    }

    public boolean equals(Usuario i){
        return idUser == i.getId();
    }

    public int compareTo(Usuario i){
        if (i.nombre.compareTo(nombre)<0) {
            return 1;
        } else if (i.nombre.compareTo(nombre)==0) {
            return 0;
        }
        return -1;
    }

    public String toString(){
        return "Usuario " + nombre + " " + apellidos;
    }


}
