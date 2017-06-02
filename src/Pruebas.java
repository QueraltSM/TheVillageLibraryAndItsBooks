import org.junit.*;
import org.junit.runner.JUnitCore;
import static org.junit.Assert.*;

public class Pruebas {
    Biblioteca b;
    Usuario u1;
    Usuario u2;
    Usuario u3;
    Poesia p;
    Poesia p2;
    Novela n;
    Novela n2;
    Relato r;
    Relato r2;

    @Before
    public void inicio(){
        b = new Biblioteca();
        p = new Poesia("Federico García Lorca","Romancero Gitano");
        p2 = new Poesia("Gustavo Adolfo Bécquer","Rimas y Leyendas");
        n = new Novela("Vladimir Nabókov", "Lolita");
        n2 = new Novela("Alexandre Dumas", "El conde de Monte Cristo");
        r = new Relato("Lady Boopy", "La Manzana");
        r2 = new Relato("Tejas verdes", "Hernán Valdés");

        u1 = new Usuario("Jorge", "García");
        u2 = new Usuario("Víctor", "López");
        u3 = new Usuario("Aarón", "Velázquez");
    }

    @Test
    public void añadirUsuario(){
        assertTrue("Prueba Biblioteca sin usuarios: ", b.todosLosUsuarios().size() == 0);



    }

    @After
    public void fin(){
        System.out.print("Fin de la prueba.");
    }
}
