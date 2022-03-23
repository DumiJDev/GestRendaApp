package ao.dumijdev.gestreandaapp.models;

import java.io.Serializable;
import java.util.Objects;

public class Administrador implements Serializable, Usuario {

    private Long ID;
    private String nome;
    private String sobrenome;

    public Administrador() {
        this.ID = 1L;
        this.nome = "";
        this.sobrenome = "";
    }

    public Administrador(Long ID, String nome, String sobrenome) {
        this.ID = ID;
        this.nome = nome;
        this.sobrenome = sobrenome;
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

    @Override
    public Class<Administrador> getControl() {
        return Administrador.class;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return getNome().toLowerCase();
    }

    @Override
    public boolean login() {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return getID().equals(that.getID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID());
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                '}';
    }

}
