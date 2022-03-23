package ao.dumijdev.gestreandaapp.models;

import java.io.Serializable;
import java.util.*;

public class Proprietario implements Serializable {

    private static long count = 0;
    private Long ID;
    private String nome;
    private String sobrenome;
    private String telefone;
    private Sexo sexo ;
    private String caminhoDaImagem;
    private Residencia residencia;
    private Set<Residencia> residencias;

    public Proprietario() {
    }

    public Proprietario(String nome, String sobrenome, String telefone, Sexo  sexo, Residencia residencia) {
        this();
        ++count;
        this.ID = count;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.caminhoDaImagem = Sexo.Masculino.equals(sexo) ? "/images/user-male.png" : "/images/user-female.png";
        this.residencia = residencia;
        this.residencias = new LinkedHashSet<>();

        if(residencia != null) {
            this.residencia.setOcupada(true);
            this.residencia.setInquilino(new Inquilino(nome, sobrenome, sexo));
            this.residencia.setProprietario(this);
        }

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

    public String getCaminhoDaImagem() {
        return caminhoDaImagem;
    }

    public void setCaminhoDaImagem(String caminhoDaImagem) {
        this.caminhoDaImagem = caminhoDaImagem;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    public Set<Residencia> getResidencias() {
        return residencias;
    }

    public void setResidencias(Set<Residencia> residencias) {
        this.residencias = residencias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Proprietario that = (Proprietario) o;

        if (!getID().equals(that.getID())) return false;
        return getTelefone().equals(that.getTelefone());
    }

    @Override
    public int hashCode() {
        int result = getID().hashCode();
        result = 31 * result + getTelefone().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return (Sexo.Masculino.equals(sexo) ? "Sr. ": "Sra. ") + sobrenome;
    }

}
