/**
 * Created by QSM on 2/6/17.
 */
public class Usuario implements Comparable<Usuario> {
    private String nombre, apellidos;
    private static int maxId = 0;
    private int idUser;

    public Usuario(String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
        idUser = ++maxId;
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
