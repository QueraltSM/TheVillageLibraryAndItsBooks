import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Biblioteca {
    private SortedSet<Libro> listadelibros = new TreeSet<Libro>();
    private SortedSet<Usuario> listadeusuarios = new TreeSet<Usuario>();
    private SortedSet<Libro> r;
    private List<Libro> resultado;

    protected static int orden;


    public Biblioteca(){}


    public boolean estaPrestado(int id) {
        return true;
    }

    /*
    * False: No se puede añadir
    * */
    public boolean añadirLibro(Libro l){
        if (listadelibros.contains(l)) return false;
            listadelibros.add(l);
            return true;

    }

    // CleanCode(int l) recicla código
    public boolean cleanCode(int l){
        for (Libro i : listadelibros) {
            if (i instanceof Relato) {
                if (i.getId() == l) {
                    return false;
                }

            } else if (i instanceof Poesia) {
                if (i.getId() == l) {
                    return false;
                }

            } else if (i instanceof Novela) {
                if (i.getId() == l) {
                    return false;
                }

            }
        }
        return true;
    }

    public Libro thisIs(int l) {
        for (Libro i : listadelibros) {
            if (i instanceof Relato) {
                if (i.getId() == l) {
                    return i;
                }

            } else if (i instanceof Poesia) {
                if (i.getId() == l) {
                    return i;
                }

            } else if (i instanceof Novela) {
                if (i.getId() == l) {
                    return i;
                }

            }
        }
        return null;
    }

    public Libro buscarLibro(int id){
        if (cleanCode(id)) return null; // no esta
        return thisIs(id);
    }


    public List<Libro> todoslibrosprestados(){
        List<Libro> aux = new LinkedList<Libro>();

        for (Libro i : listadelibros) {
            if (i.getEstado()) aux.add(i);
        }

        return aux;
    }


    public List<Libro> todosLosLibros(){
        List<Libro> result = new LinkedList<Libro>();
        for (Libro l : listadelibros) {
            result.add(l);
        }
        return result;
    }


    public List<Usuario> todosLosUsuarios(){
        List<Usuario> result = new LinkedList<Usuario>();
        for (Usuario l : listadeusuarios) {
            result.add(l);
        }
        return result;
    }


    // Devuelve true si no está añadido el usuario
    public boolean userIsnt(Usuario i){
        for (Usuario j : listadeusuarios) {
            if (j.equals(i)) return false;
        }

        return true;
    }

    public List<Libro> getOrden () {
        return resultado;
    }



    public void setOrden(int n){
        r = new TreeSet<Libro>();
        resultado = new LinkedList<Libro>();

        orden = n;

        for (Libro i : listadelibros) {
            r.add(i);
        }

        for (Libro i : r) {
            resultado.add(i);
        }


    }

    public boolean añadirUsuario(Usuario i){
        if (!userIsnt(i)) return false;
        listadeusuarios.add(i);
        return true;

    }
}