package br.edu.ifba.dao.entidades;

import java.util.List;

import br.edu.ifba.dao.GetEntityManager;
import br.edu.ifba.dao.InterfaceDao;
import br.edu.ifba.model.HistoricoServico;
import jakarta.persistence.EntityManager;

public class HistoricoServicoDao implements InterfaceDao<HistoricoServico> {
    EntityManager em = GetEntityManager.getConnectionJpa();
    
    public void insert(HistoricoServico histServ) {
        em.getTransaction().begin();
        em.persist(histServ);
        em.getTransaction().commit();
    }

    public List<HistoricoServico> getAll() {
        return em.createQuery("SELECT hs FROM HistoricoServico hs", HistoricoServico.class).getResultList();
    }

    public HistoricoServico getById(int id) {
        return em.find(HistoricoServico.class, id);
    }

    public void update(HistoricoServico histServ) {
        em.getTransaction().begin();
        em.merge(histServ);
        em.getTransaction().commit();
    }

    public void remove(HistoricoServico histServ) {
        em.getTransaction().begin();
        em.remove(histServ);
        em.getTransaction().commit();
    }
}
