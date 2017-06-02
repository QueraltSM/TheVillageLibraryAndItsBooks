public class Main {
    public static void main(String[] args){
        Biblioteca b = new Biblioteca();
        Poesia p = new Poesia("Federico García Lorca","Romancero Gitano");
        Poesia p2 = new Poesia("Gustavo Adolfo Bécquer","Rimas y Leyendas");
        Novela n = new Novela("Vladimir Nabókov", "Lolita");
        Novela n2 = new Novela("Alexandre Dumas", "El conde de Monte Cristo");
        Relato r = new Relato("Lady Boopy", "La Manzana");
        Relato r2 = new Relato("Tejas verdes", "Hernán Valdés");

        b.añadirLibro(p);
        b.añadirLibro(p2);
        b.añadirLibro(n);
        b.añadirLibro(r);
        b.añadirLibro(n2);
        b.añadirLibro(r2);

    }
}
