public class Poesia extends Libro{
    private String titulo, autor;
    private int maxId = 0, id;

    public Poesia(String autor, String titulo){
        super(autor, titulo);
        this.titulo = titulo;
        this.autor = autor;
        id = ++maxId;
    }

    public int getId(){
        return id;
    }


    public String toString(){
        return "Tipo de libro: Poesía, Título: "  + titulo + ", Autor@: " + autor;
    }
}
