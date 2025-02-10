package br.edu.ifba.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEndereco;
    private String rua;
    private int numCasa;
    private String bairro;
    private String cidade;
    private int cep;
    //* Relação com Cliente */
    @OneToOne(mappedBy = "fkEndereco", cascade = CascadeType.ALL)
    private Cliente fkCliente;

    public Endereco() {}

    public Endereco(int idEndereco, String rua, int numCasa, String bairro, String cidade, int cep,
            Cliente fkCliente) {
        this.idEndereco = idEndereco;
        this.rua = rua;
        this.numCasa = numCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.fkCliente = fkCliente;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public Cliente getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Cliente fkCliente) {
        this.fkCliente = fkCliente;
    }

    @Override
    public String toString() {
        return "Endereco [idEndereco=" + idEndereco + ", rua=" + rua + ", numCasa=" + numCasa + ", bairro=" + bairro
                + ", cidade=" + cidade + ", cep=" + cep + ", fkCliente=" + fkCliente.getIdCliente() + "]";
    }
}
