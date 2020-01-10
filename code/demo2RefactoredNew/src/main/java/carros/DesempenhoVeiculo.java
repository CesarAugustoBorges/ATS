package carros;

import utils.Weather;

import java.util.Objects;

public class DesempenhoVeiculo {

    public DesempenhoVeiculo(){
        this.velocidade = 0;
        this.preco = 0.0;
        this.consumo = 0.0;
        this.autonomia = 0;
        this.posicao = new Coordinate(0,0);
    }

    /**
     * @param velocidade  Velocidade média por Km.
     * @param preco       Preço base por cada Km percorrido.
     * @param consumo     Consumo por Km percorrido.
     * @param autonomia   Autonomia em Km do veículo.
     * @param cords       Coordenadas em que o veículo se encontra.
     */
    public DesempenhoVeiculo(int velocidade, double preco, double consumo,
                             int autonomia, Coordinate cords){
        this.velocidade = velocidade;
        this.preco = preco;
        this.consumo = consumo;
        this.autonomia = autonomia;
        this.posicao = cords;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public Coordinate getPosicao() {
        return posicao;
    }

    public void setPosicao(Coordinate posicao) {
        this.posicao = posicao;
    }

    /* Velocidade média por Km */
    private int velocidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DesempenhoVeiculo)) return false;
        DesempenhoVeiculo that = (DesempenhoVeiculo) o;
        return getVelocidade() == that.getVelocidade() &&
                Double.compare(that.getPreco(), getPreco()) == 0 &&
                Double.compare(that.getConsumo(), getConsumo()) == 0 &&
                getAutonomia() == that.getAutonomia() &&
                getPosicao().equals(that.getPosicao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVelocidade(), getPreco(), getConsumo(), getAutonomia(), getPosicao());
    }

    /* Preço base por Km */
    private double preco;
    /* Consumo por Km percorrido */
    private double consumo;
    /* Autonomia total do veículo */
    private int autonomia;
    /* Posição (Latitude / Longitude) do veículo */
    private Coordinate posicao;


    /** Método que devolve o tempo a pé até ao veículo, mediante uma posição recebida como parâmetro.
     * @param posicaoCli Posição inicial.
     * @return int Tempo em minutos a pé até ao veículo.
     */
    public int tempoAteVeiculoPe(Coordinate posicaoCli){
        double dist = posicaoCli.getDistancia(this.posicao);
        Long tempo = Math.round((dist * 60) / 4 * Weather.getPercentage(this.posicao.getLatitude(), this.posicao.getLongitude()));
        return tempo.intValue();
    }

    /** Método que devolve o preço de uma viagem mediante uma distância recebida como parâmetro.
     * @param destino Destino.
     * @return int Representa o tempo em minutos da viagem.
     */
    public int tempoViagemCarro(Coordinate destino){
        double dist = this.posicao.getDistancia(destino);
        Long tempoMin = Math.round((dist * 60) / 70 * Weather.getPercentage(this.posicao.getLatitude(), this.posicao.getLongitude()));
        return tempoMin.intValue();
    }

    /** Método que devolve o tempo a pé até ao veículo, mediante uma posição recebida como parâmetro.
     * @param posicaoCli Posição inicial.
     * @return int Tempo em minutos a pé até ao veículo.
     */
    public int tempoAteVeiculoPeJa(Coordinate posicaoCli){
        double dist = posicaoCli.getDistancia(this.posicao);
        Long tempo = Math.round((dist * 60) / 4);
        return Integer.valueOf(tempo.intValue());
    }

    /** Método que devolve o preço de uma viagem mediante uma distância recebida como parâmetro.
     * @param destino Destino.
     * @return int Representa o tempo em minutos da viagem.
     */
    public int tempoViagemCarroJa(Coordinate destino){
        double dist = this.posicao.getDistancia(destino);
        Long tempoMin = Math.round((dist * 60));
        return Integer.valueOf(tempoMin.intValue());
    }
}
