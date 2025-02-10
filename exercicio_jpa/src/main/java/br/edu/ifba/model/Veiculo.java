package br.edu.ifba.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Veiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVeiculo;
    private String modelo;
    private String montadora;
    //* Relação com Cliente */
    @ManyToOne
    @JoinColumn(name = "fkCliente")
    private Cliente fkCliente;
    //* Relação com Serviço */
    @OneToMany(mappedBy = "fkVeiculo", cascade = CascadeType.ALL)
    private List<HistoricoServico> listaHistoricoServico;

    public Veiculo() {}

    public Veiculo(int idVeiculo, String modelo, String montadora, Cliente fkCliente,
            List<HistoricoServico> listaHistoricoServico) {
        this.idVeiculo = idVeiculo;
        this.modelo = modelo;
        this.montadora = montadora;
        this.fkCliente = fkCliente;
        this.listaHistoricoServico = listaHistoricoServico;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public Cliente getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Cliente fkCliente) {
        this.fkCliente = fkCliente;
    }

    public List<HistoricoServico> getListaHistoricoServico() {
        return listaHistoricoServico;
    }

    public void setListaHistoricoServico(List<HistoricoServico> listaHistoricoServico) {
        this.listaHistoricoServico = listaHistoricoServico;
    }

    @Override
    public String toString() {
        return "Veiculo [idVeiculo=" + idVeiculo + ", modelo=" + modelo + ", montadora=" + montadora + ", fkCliente="
                + fkCliente.getIdCliente() + "]";
    }
}
