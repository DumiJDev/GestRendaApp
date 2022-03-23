package ao.dumijdev.gestreandaapp.models;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Residencia {

    private Long ID;
    private Proprietario proprietario;
    private Inquilino inquilino;
    private String municipio;
    private String bairro;
    private String rua;
    private String numeroCasa;
    private Ocupante ocupante;
    private Double preco;
    private Boolean ocupada;
    private Data dataDeEntrada;
    private Data dataDeSaida;
    private static long count = 0;

    public Residencia() {
        ++count;
        this.ID = count;
        this.proprietario = null;
        this.inquilino = null;
        this.preco = 0.0;
        this.ocupada = false;
        dataDeEntrada = null;
        dataDeSaida = null;
    }

    public Residencia(String municipio,
                      String bairro,
                      String rua,
                      String numeroCasa, Ocupante ocupante
                      ) {
        this();
        this.municipio = municipio;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.ocupante = ocupante;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

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

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public Ocupante getOcupante() {
        return ocupante;
    }

    public void setOcupante(Ocupante ocupante) {
        this.ocupante = ocupante;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getOcupada() {
        ocupada = inquilino != null;
        return ocupada;
    }

    public void setOcupada(Boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Data getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(Data dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public Data getDataDeSaida() {
        return dataDeSaida;
    }

    public void setDataDeSaida(Data dataDeSaida) {
        this.dataDeSaida = dataDeSaida;
    }

    private int tempoTotalPagoEmMes(){
        Calendar entrada = Calendar.getInstance();
        Calendar saida = Calendar.getInstance();

        entrada.setTime(dataDeEntrada.getTime());
        saida.setTime(dataDeSaida.getTime());

        return (saida.get(Calendar.DAY_OF_MONTH) - entrada.get(Calendar.DAY_OF_MONTH)) +
                (saida.get(Calendar.MONTH) - entrada.get(Calendar.MONTH)) * 12;

    }
    private int tempoGastoEmMes(){
        Calendar entrada = Calendar.getInstance();
        Calendar agora = Calendar.getInstance();

        entrada.setTime(dataDeEntrada.getTime());

        return (agora.get(Calendar.DAY_OF_MONTH) - entrada.get(Calendar.DAY_OF_MONTH)) +
                (agora.get(Calendar.MONTH) - entrada.get(Calendar.MONTH)) * 12;
    }
    private int tempoRestanteEmMes(){
        Calendar agora = Calendar.getInstance();
        Calendar saida = Calendar.getInstance();

        saida.setTime(dataDeSaida.getTime());

        return (saida.get(Calendar.DAY_OF_MONTH) - agora.get(Calendar.DAY_OF_MONTH)) +
                (saida.get(Calendar.MONTH) - agora.get(Calendar.MONTH)) * 12;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Residencia that = (Residencia) o;

        if (!getID().equals(that.getID())) return false;
        if (!getMunicipio().equals(that.getMunicipio())) return false;
        if (!getBairro().equals(that.getBairro())) return false;
        if (!getRua().equals(that.getRua())) return false;
        return getNumeroCasa().equals(that.getNumeroCasa());
    }

    @Override
    public int hashCode() {
        int result = getID().hashCode();
        result = 31 * result + getMunicipio().hashCode();
        result = 31 * result + getBairro().hashCode();
        result = 31 * result + getRua().hashCode();
        result = 31 * result + getNumeroCasa().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return municipio  +
                ", " + bairro +
                ", " + rua +
                ", " + numeroCasa;
    }
}
