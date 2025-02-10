package br.edu.ifba.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Servico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServico;
    private String descricao;
    private double valor;
    //* Relação com Veículo */
    @OneToMany(mappedBy = "fkServico", cascade = CascadeType.ALL)
    private List<HistoricoServico> listaHistoricoServico;

    public Servico() {}

    public Servico(int idServico, String descricao, double valor, List<HistoricoServico> listaHistoricoServico) {
        this.idServico = idServico;
        this.descricao = descricao;
        this.valor = valor;
        this.listaHistoricoServico = listaHistoricoServico;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<HistoricoServico> getListaHistoricoServico() {
        return listaHistoricoServico;
    }

    public void setListaHistoricoServico(List<HistoricoServico> listaHistoricoServico) {
        this.listaHistoricoServico = listaHistoricoServico;
    }

    @Override
    public String toString() {
        return "Servico [idServico=" + idServico + ", descricao=" + descricao + ", valor=" + valor
                + "]";
    }
}