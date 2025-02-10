package br.edu.ifba.dao.entidades;

import java.util.List;

import br.edu.ifba.dao.GetEntityManager;
import br.edu.ifba.dao.InterfaceDao;
import br.edu.ifba.model.Cliente;
import jakarta.persistence.EntityManager;

public class ClienteDao implements InterfaceDao<Cliente> {
    EntityManager em = GetEntityManager.getConnectionJpa();
    
    public void insert(Cliente cli) {
        em.getTransaction().begin();
        em.persist(cli);
        em.getTransaction().commit();
    }

    public List<Cliente> getAll() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    public Cliente getById(int id) {
        return em.find(Cliente.class, id);
    }

    public void update(Cliente cli) {
        em.getTransaction().begin();
        em.merge(cli);
        em.getTransaction().commit();
    }

    public void remove(Cliente cli) {
        em.getTransaction().begin();
        em.remove(cli);
        em.getTransaction().commit();
    }
}
