package mariangelamarasciuolo;

import mariangelamarasciuolo.entites.Evento;
import mariangelamarasciuolo.entites.EventoDAO;
import mariangelamarasciuolo.entites.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");

    public static void main(String[] args) {
        //Evento evento1 = new Evento("Comicon", LocalDate.of(2023, 10, 20), "Videogame", TipoEvento.PUBBLICO, 200);
        //Evento evento2 = new Evento("Italia alla moda", LocalDate.of(2023, 12, 8), "Sfilata di Grandi Marche", TipoEvento.PRIVATO, 80);
        //Evento evento3 = new Evento("Calici di vino", LocalDate.of(2023, 12, 26), "Sorseggiando Vino", TipoEvento.PUBBLICO, 600);
        //Evento evento4 = new Evento("Puglia Sposi", LocalDate.of(2023, 11, 20), "Abiti da matrimonio per lei e per lui", TipoEvento.PRIVATO, 150);
        //Evento evento5 = new Evento("Natale 2023", LocalDate.of(2023, 12, 7), "Fiera Natalizia", TipoEvento.PUBBLICO, 500);


        EntityManager em = emf.createEntityManager();
        try {

            EventoDAO sd = new EventoDAO(em);
            System.out.println("Hello World!");

            // 1. Salvataggio nuovo evento
            Evento evento1 = new Evento("Comicon", LocalDate.of(2023, 10, 20), "Videogame", TipoEvento.PUBBLICO, 200);
            sd.save(evento1);

            //salvo secondo evento
            Evento evento2 = new Evento("Italia alla moda", LocalDate.of(2023, 12, 8), "Sfilata di Grandi Marche", TipoEvento.PRIVATO, 80);
            sd.save(evento2);

            // 2. Find By Id
            Evento evento = sd.findById(1);
            if (evento != null)
                System.out.println(evento1);

            Evento eventob = sd.findById(2);
            if (eventob != null)
                System.out.println(evento2);


            // 3. Find By Id And Delete
            sd.findByIdAndDelete(8);
            sd.findByIdAndDelete(7);
            sd.findByIdAndDelete(6);
            sd.findByIdAndDelete(5);
            sd.findByIdAndDelete(4);


            // 4. Esempio di refresh
           /* Evento evento1b = sd.findById(6);
            if (evento1b != null) {
                evento1b.setTitolo("Comiconzzzzz");
                System.out.println("PRE REFRESH");
                System.out.println(evento1b);

                em.refresh(evento1b); // ripristina un oggetto modificato "sincronizzandolo" con i valori provenienti dal DB
                System.out.println("POST REFRESH");
                System.out.println(evento1b);
            }

            Evento evento2b = sd.findById(3);
            if (evento2b != null) {
                evento2b.setTitolo("Mondo alla moda");
                System.out.println("PRE REFRESH");
                System.out.println(evento2b);

                em.refresh(evento2b); // ripristina un oggetto modificato "sincronizzandolo" con i valori provenienti dal DB
                System.out.println("POST REFRESH");
                System.out.println(evento2b);
            }*/

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            // Ricordiamoci alla fine di tutto di chiudere sia entitymanager che entitymanager factory
            em.close();
            emf.close();
        }
    }
}
