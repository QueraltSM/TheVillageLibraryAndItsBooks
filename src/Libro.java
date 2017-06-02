public abstract class Libro implements Comparable<Libro> {
    private String titulo, autor;
    private Boolean prestado;

    public Libro(String autor, String titulo){
        this.titulo = titulo;
        this.autor = autor;
        prestado = false;
    }


    public abstract int getId();


    public int compareTo(Libro l){
        if (titulo.compareTo(l.getTitulo())>0) {
            return 1;
        } else if (titulo.compareTo(l.getTitulo())==0) {
            return 0;
        }
        return -1;
    }

    public boolean equals(Libro l){
        return l.getTitulo().equals(titulo);
    }

    public int setIdTipoDeLibro() {
        if (this instanceof Relato) {
            return 2;
        } else if (this instanceof Poesia) {
            return 3;
        } else if (this instanceof Novela) {
            return 1;
        }
        return -1;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public boolean getEstado(){
        return prestado;
    }

    public void setEstado(boolean estado){
        prestado = estado;
    }






}
