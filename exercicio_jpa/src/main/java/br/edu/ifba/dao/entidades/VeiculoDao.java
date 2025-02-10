package br.edu.ifba.dao.entidades;

import java.util.List;

import br.edu.ifba.dao.GetEntityManager;
import br.edu.ifba.dao.InterfaceDao;
import br.edu.ifba.model.Veiculo;
import jakarta.persistence.EntityManager;

public class VeiculoDao implements InterfaceDao<Veiculo> {
    EntityManager em = GetEntityManager.getConnectionJpa();

    public void insert(Veiculo vei) {
        em.getTransaction().begin();
        em.persist(vei);
        em.getTransaction().commit();
    }

    public List<Veiculo> getAll() {
        return em.createQuery("SELECT v FROM Veiculo v", Veiculo.class).getResultList();
    }

    public Veiculo getById(int id) {
        return em.find(Veiculo.class, id);
    }

    public void update(Veiculo vei) {
        em.getTransaction().begin();
        em.merge(vei);
        em.getTransaction().commit();
    }

    public void remove(Veiculo vei) {
        em.getTransaction().begin();
        em.remove(vei);
        em.getTransaction().commit();
    }
}
