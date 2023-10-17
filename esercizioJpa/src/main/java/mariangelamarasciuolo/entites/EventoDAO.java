package mariangelamarasciuolo.entites;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        // 1. Inizio la transazione
        transaction.begin();

        // 2. Aggiungo il nuovo oggetto al Persistence Context (ma non è ancora salvato a DB in questo momento)
        em.persist(evento);

        // 3. Termino la transazione col salvataggio effettivo di una nuova riga nella tabella students
        transaction.commit();
        System.out.println("Nuovo evento salvato correttamente");
    }

    public Evento findById(long id) {
        return em.find(Evento.class, id);
    }

    public void findByIdAndDelete(long id) {
        Evento found = em.find(Evento.class, id);
        if (found != null) {
            // 2. Se lo studente c'è, lo elimino

            // 2.1 Ottengo la transazione
            EntityTransaction transaction = em.getTransaction();

            // 2.2 Faccio partire la transazione
            transaction.begin();

            // 2.3 Rimuovo l'oggetto dal persistence context
            em.remove(found);

            // 2.4 Faccio il commit della transazione per persistere a db l'operazione
            transaction.commit();
            System.out.println("Lo studente è stato cancellato correttamente");
        } else {
            // 3. Altrimenti --> "Student not found"
            System.err.println("Lo studente con l'id " + id + " non è stato trovato");
        }

    }
}
