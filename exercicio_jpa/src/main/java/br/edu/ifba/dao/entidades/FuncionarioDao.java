package br.edu.ifba.dao.entidades;

import java.util.List;

import br.edu.ifba.dao.GetEntityManager;
import br.edu.ifba.dao.InterfaceDao;
import br.edu.ifba.model.Funcionario;
import jakarta.persistence.EntityManager;

public class FuncionarioDao implements InterfaceDao<Funcionario> {
    EntityManager em = GetEntityManager.getConnectionJpa();

    public void insert(Funcionario fun) {
        em.getTransaction().begin();
        em.persist(fun);
        em.getTransaction().commit();
    }

    public List<Funcionario> getAll() {
        return em.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
    }

    public Funcionario getById(int id) {
        return em.find(Funcionario.class, id);
    }

    public void update(Funcionario fun) {
        em.getTransaction().begin();
        em.merge(fun);
        em.getTransaction().commit();
    }

    public void remove(Funcionario fun) {
        em.getTransaction().begin();
        em.remove(fun);
        em.getTransaction().commit();
    }
}
