package br.com.challenge.one.util.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {

  // Formato padrão ISO para LocalDateTim - é uma boa prática.
  // Exemplo: "2025-05-25T04:30:00"
  private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

  /**
   * Método chamado pelo Gson para converter um objeto LocalDateTime em JSON.
   * Vamos converter o LocalDateTime em uma String JSON.
   *
   * @param out   O escritor JSON para onde enviaremos a string.
   * @param value O objeto LocalDateTime a ser serializado.
   */
  @Override
  public void write(JsonWriter out, LocalDateTime value) throws IOException {
    if (value == null) {
      // Se o objeto LocalDateTime for nulo, escrevemos um null no JSON.
      out.nullValue();
      return;
    }
    // Formata o LocalDateTime para uma String e escreve essa string no JSON.
    String formattedDateTime = value.format(formatter);
    out.value(formattedDateTime);
  }

  /**
   * Método chamado pelo Gson para converter um JSON (que esperamos ser uma
   * string)
   * de volta para um objeto LocalDateTime.
   *
   * @param in O leitor JSON de onde pegaremos a string.
   * @return O objeto LocalDateTime desserializado.
   */
  @Override
  public LocalDateTime read(JsonReader in) throws IOException {
    // Verifica se o token atual no JSON é um valor nulo.
    if (in.peek() == JsonToken.NULL) {
      in.nextNull(); // Consome o token nulo.
      return null; // Retorna um objeto Java nulo.
    }

    // Lê o valor do JSON como uma string.
    String jsonValue = in.nextString();

    try {
      // Tenta converter a string de volta para um LocalDateTime usando nosso
      // formatador.
      return LocalDateTime.parse(jsonValue, formatter);
    } catch (DateTimeParseException e) {
      // Se a string não estiver no formato esperado, dispara uma exceção.
      throw new IOException("Erro ao desserializar LocalDateTime: formato inválido '" + jsonValue + "'", e);
    }
  }
}
