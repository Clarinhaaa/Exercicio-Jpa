package br.edu.ifba.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nomeCliente;
    private String cpfCliente;
    private String email;
    //* Relação com Endereço */
    @OneToOne
    @JoinColumn(name = "fkEndereco")
    private Endereco fkEndereco;
    //* Relação com Veículo */
    @OneToMany(mappedBy = "fkCliente", cascade = CascadeType.ALL)
    private List<Veiculo> listaVeiculos;

    public Cliente() {}

    public Cliente(int idCliente, String nomeCliente, String cpfCliente, String email, Endereco fkEndereco,
            List<Veiculo> listaVeiculos) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.email = email;
        this.fkEndereco = fkEndereco;
        this.listaVeiculos = listaVeiculos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getFkEndereco() {
        return fkEndereco;
    }

    public void setFkEndereco(Endereco fkEndereco) {
        this.fkEndereco = fkEndereco;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", cpfCliente=" + cpfCliente
                + ", email=" + email + ", fkEndereco=" + fkEndereco.getIdEndereco() + ", listaVeiculos=" + listaVeiculos + "]";
    }
}
