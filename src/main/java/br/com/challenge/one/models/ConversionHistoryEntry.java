package br.com.challenge.one.models;

import java.time.LocalDateTime;

import com.google.gson.annotations.SerializedName;

public class ConversionHistoryEntry {

  private LocalDateTime dataHora;

  @SerializedName("moedaOrigem")
  private String moedaOrigem;

  private double valorOriginal;

  @SerializedName("moedaDestino")
  private String moedaDestino;

  @SerializedName("valorConvertido")
  private double valorConvertido;

  @SerializedName("taxaConversao")
  private double taxaConversao;

  public LocalDateTime getDataHora() {
    return dataHora;
  }

  public void setDataHora(LocalDateTime dataHora) {
    this.dataHora = dataHora;
  }

  public String getMoedaOrigem() {
    return moedaOrigem;
  }

  public void setMoedaOrigem(String moedaOrigem) {
    this.moedaOrigem = moedaOrigem;
  }

  public double getValorOriginal() {
    return valorOriginal;
  }

  public void setValorOriginal(double valorOriginal) {
    this.valorOriginal = valorOriginal;
  }

  public String getMoedaDestino() {
    return moedaDestino;
  }

  public void setMoedaDestino(String moedaDestino) {
    this.moedaDestino = moedaDestino;
  }

  public double getValorConvertido() {
    return valorConvertido;
  }

  public void setValorConvertido(double valorConvertido) {
    this.valorConvertido = valorConvertido;
  }

  public double getTaxaConversao() {
    return taxaConversao;
  }

  public void setTaxaConversao(double taxaConversao) {
    this.taxaConversao = taxaConversao;
  }

}
