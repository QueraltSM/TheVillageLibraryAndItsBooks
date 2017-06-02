/**
 * Created by QSM on 2/6/17.
 */
import java.util.*;

public class Usuario implements Comparable<Usuario> {
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
        if (l.getEstado()) return false; // esta prestado
        if (librosprestados<7) {
            libros.add(l);
            librosprestados++;
            l.setEstado(true);
            return true;
        }
        return false;
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
