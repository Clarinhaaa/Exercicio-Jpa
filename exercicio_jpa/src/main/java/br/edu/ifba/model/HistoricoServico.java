package br.edu.ifba.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class HistoricoServico implements Serializable {
    @EmbeddedId
    private HistoricoServicoId id;
    
    //* Relação com Veículo */
    @ManyToOne
    @MapsId("fkVeiculo")
    @JoinColumn(name = "fkVeiculo")
    private Veiculo fkVeiculo;

    //* Relação com Serviço */
    @ManyToOne
    @MapsId("fkServico")
    @JoinColumn(name = "fkServico")
    private Servico fkServico;

    //* Relação com Funcionário */
    @ManyToOne
    @JoinColumn(name = "fkFuncionario")
    private Funcionario fkFuncionario;

    public HistoricoServico() {}

    public HistoricoServico(HistoricoServicoId id, Veiculo fkVeiculo, Servico fkServico, Funcionario fkFuncionario) {
        this.id = id;
        this.fkVeiculo = fkVeiculo;
        this.fkServico = fkServico;
        this.fkFuncionario = fkFuncionario;
    }

    public HistoricoServicoId getId() {
        return id;
    }

    public void setId(HistoricoServicoId id) {
        this.id = id;
    }

    public Veiculo getFkVeiculo() {
        return fkVeiculo;
    }

    public void setFkVeiculo(Veiculo fkVeiculo) {
        this.fkVeiculo = fkVeiculo;
    }

    public Servico getFkServico() {
        return fkServico;
    }

    public void setFkServico(Servico fkServico) {
        this.fkServico = fkServico;
    }

    public Funcionario getFkFuncionario() {
        return fkFuncionario;
    }

    public void setFkFuncionario(Funcionario fkFuncionario) {
        this.fkFuncionario = fkFuncionario;
    }
}
