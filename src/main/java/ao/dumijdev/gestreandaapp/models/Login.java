package ao.dumijdev.gestreandaapp.models;

import java.io.Serializable;
import java.util.Objects;

public class Login implements Serializable {

    private Long ID;
    private String username;
    private String password;
    private TipoUsuario tipoUsuario;
    private Long IDUsuario;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Long getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(Long IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return getID().equals(login.getID()) &&
                getUsername().equals(login.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getUsername());
    }

}
