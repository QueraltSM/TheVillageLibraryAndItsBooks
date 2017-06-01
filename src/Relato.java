public class Relato extends Libro {
    private String titulo,autor;
    private Boolean prestado;
    private int maxId = 0, id;

    public Relato(String autor, String titulo){
        super(autor, titulo);
        this.titulo = titulo;
        this.autor = autor;
        prestado = false;
        id = ++maxId;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return "Tipo de libro: Relato, Título: " + titulo + ", Autor@: " + autor;
    }
}
