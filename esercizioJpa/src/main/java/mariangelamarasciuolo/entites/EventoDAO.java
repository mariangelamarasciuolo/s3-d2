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
        
    }

}
