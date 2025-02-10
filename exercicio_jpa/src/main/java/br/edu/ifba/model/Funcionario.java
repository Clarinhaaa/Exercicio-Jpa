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
public class Funcionario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFuncionario;
    private String nomeFuncionario;
    private String cpfFuncionario;
    private String funcao;
    //* Relação com HistóricoServiço */
    @OneToMany(mappedBy = "fkFuncionario", cascade = CascadeType.ALL)
    private List<HistoricoServico> listaHistoricoServico;

    public Funcionario() {}

    public Funcionario(int idFuncionario, String nomeFuncionario, String cpfFuncionario, String funcao,
            List<HistoricoServico> listaHistoricoServico) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.funcao = funcao;
        this.listaHistoricoServico = listaHistoricoServico;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public List<HistoricoServico> getListaHistoricoServico() {
        return listaHistoricoServico;
    }

    public void setListaHistoricoServico(List<HistoricoServico> listaHistoricoServico) {
        this.listaHistoricoServico = listaHistoricoServico;
    }

    @Override
    public String toString() {
        return "Funcionario [idFuncionario=" + idFuncionario + ", nomeFuncionario=" + nomeFuncionario
                + ", cpfFuncionario=" + cpfFuncionario + ", funcao=" + funcao + "]";
    }
}
