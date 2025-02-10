package br.edu.ifba.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class HistoricoServicoId implements Serializable {
    private int fkVeiculo;
    private int fkServico;

    public HistoricoServicoId() {}

    public HistoricoServicoId(int fkVeiculo, int fkServico) {
        this.fkVeiculo = fkVeiculo;
        this.fkServico = fkServico;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + fkVeiculo;
        result = prime * result + fkServico;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HistoricoServicoId other = (HistoricoServicoId) obj;
        if (fkVeiculo != other.fkVeiculo)
            return false;
        if (fkServico != other.fkServico)
            return false;
        return true;
    }

}
