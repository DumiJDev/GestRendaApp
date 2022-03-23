package ao.dumijdev.gestreandaapp.models;

import java.util.*;

public class Inquilino {

    private Long ID;
    private String nome;
    private String sobrenome;
    private String telefone;
    private Sexo sexo;
    private Residencia residencia;
    private Data Entrada;
    private Data Saida;
    private List<Data> pagamentos;
    private static long count = 0;

    public Inquilino(){
        ++count;
        setID(count);
        setNome("");
        setSobrenome("");
        setTelefone("");
        setSexo(Sexo.Masculino);
        setEntrada(new Data());
        setSaida(new Data());
        setPagamentos(new ArrayList<>());
    }

    public Inquilino(String nome, String sobrenome, Sexo sexo) {
        this();
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
    }

    public Inquilino(Residencia residencia) {
        this.residencia = residencia;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    public Data getEntrada() {
        return Entrada;
    }

    public void setEntrada(Data entrada) {
        Entrada = entrada;
    }

    public Data getSaida() {
        return Saida;
    }

    public void setSaida(Data saida) {
        Saida = saida;
    }

    public List<Data> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Data> pagamentos) {
        this.pagamentos = pagamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inquilino inquilino = (Inquilino) o;
        return getID().equals(inquilino.getID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID());
    }

    @Override
    public String toString() {
        return  (Sexo.Masculino.equals(sexo) ? "Sr. " : "Sra.") + sobrenome ;
    }
}
