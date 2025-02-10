package br.edu.ifba.dao.entidades;

import java.util.List;

import br.edu.ifba.dao.GetEntityManager;
import br.edu.ifba.dao.InterfaceDao;
import br.edu.ifba.model.Servico;
import jakarta.persistence.EntityManager;

public class ServicoDao implements InterfaceDao<Servico> {
    EntityManager em = GetEntityManager.getConnectionJpa();

    public void insert(Servico serv) {
        em.getTransaction().begin();
        em.persist(serv);
        em.getTransaction().commit();
    }

    public List<Servico> getAll() {
        return em.createQuery("SELECT s FROM Servico s", Servico.class).getResultList();
    }

    public Servico getById(int id) {
        return em.find(Servico.class, id);
    }

    public void update(Servico serv) {
        em.getTransaction().begin();
        em.merge(serv);
        em.getTransaction().commit();
    }

    public void remove(Servico serv) {
        em.getTransaction().begin();
        em.remove(serv);
        em.getTransaction().commit();
    }
}
