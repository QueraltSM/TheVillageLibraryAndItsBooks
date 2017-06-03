public abstract class Libro implements Comparable<Libro> {
    private String titulo, autor;
    private Boolean prestado;

    public int getOrdenNum(){
        return Biblioteca.orden;
    }


    public Libro(String autor, String titulo){
        this.titulo = titulo;
        this.autor = autor;
        prestado = false;
    }


    public abstract int getId();

    public int compareTo(Libro l){

        if (getOrdenNum() == 0) {
            if (titulo.compareTo(l.getTitulo()) > 0) {
                return 1;
            } else if (titulo.compareTo(l.getTitulo()) == 0) {
                return 0;
            }
            return -1;

        } else if (getOrdenNum()==1) {
            if (autor.compareTo(l.getAutor()) > 0) {
                return 1;
            } else if (autor.compareTo(l.getAutor()) == 0) {
                return 0;
            }
            return -1;

        }
        return 2;
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
