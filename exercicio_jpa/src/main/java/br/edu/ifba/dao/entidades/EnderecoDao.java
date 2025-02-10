package br.edu.ifba.dao.entidades;

import java.util.List;

import br.edu.ifba.dao.GetEntityManager;
import br.edu.ifba.dao.InterfaceDao;
import br.edu.ifba.model.Endereco;
import jakarta.persistence.EntityManager;

public class EnderecoDao implements InterfaceDao<Endereco> {
    EntityManager em = GetEntityManager.getConnectionJpa();

    public void insert(Endereco end) {
        em.getTransaction().begin();
        em.persist(end);
        em.getTransaction().commit();
    }

    public List<Endereco> getAll() {
        return em.createQuery("SELECT e FROM Endereco e", Endereco.class).getResultList();
    }

    public Endereco getById(int id) {
        return em.find(Endereco.class, id);
    }

    public void update(Endereco end) {
        em.getTransaction().begin();
        em.merge(end);
        em.getTransaction().commit();
    }

    public void remove(Endereco end) {
        em.getTransaction().begin();
        em.remove(end);
        em.getTransaction().commit();
    }
}
