public class Novela extends Libro {
    private String titulo, autor;
    private int maxId = 0, id;

    public Novela(String autor, String titulo){
        super(autor, titulo);
        this.titulo = titulo;
        this.autor = autor;
        id = ++maxId;
    }


    public int getId(){
        return id;
    }



    public String toString(){
        return "Tipo de libro: Novela, Título: " + titulo + ", Autor@: " + autor;
    }
}
