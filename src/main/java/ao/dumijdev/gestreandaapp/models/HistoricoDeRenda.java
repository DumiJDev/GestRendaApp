package ao.dumijdev.gestreandaapp.models;

import java.io.Serializable;
import java.util.Date;

public class HistoricoDeRenda implements Serializable {

    private Long ID;
    private Proprietario proprietario;
    private Inquilino inquilino;
    private Residencia residencia;
    private Date dataDeEntrada;
    private Date dataDeSaida;

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    public Date getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(Date dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public Date getDataDeSaida() {
        return dataDeSaida;
    }

    public void setDataDeSaida(Date dataDeSaida) {
        this.dataDeSaida = dataDeSaida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoricoDeRenda that = (HistoricoDeRenda) o;

        if (!ID.equals(that.ID)) return false;
        if (!getProprietario().equals(that.getProprietario())) return false;
        if (!getInquilino().equals(that.getInquilino())) return false;
        if (!getResidencia().equals(that.getResidencia())) return false;
        if (!getDataDeEntrada().equals(that.getDataDeEntrada())) return false;
        return getDataDeSaida().equals(that.getDataDeSaida());
    }

    @Override
    public int hashCode() {
        int result = ID.hashCode();
        result = 31 * result + getProprietario().hashCode();
        result = 31 * result + getInquilino().hashCode();
        result = 31 * result + getResidencia().hashCode();
        result = 31 * result + getDataDeEntrada().hashCode();
        result = 31 * result + getDataDeSaida().hashCode();
        return result;
    }
}
