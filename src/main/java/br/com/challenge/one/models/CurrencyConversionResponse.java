package br.com.challenge.one.models;

import com.google.gson.annotations.SerializedName;

public class CurrencyConversionResponse {

  @SerializedName("result")
  private String resultStatus;

  @SerializedName("base_code")
  private String baseCode;

  @SerializedName("target_code")
  private String targetCode;

  @SerializedName("conversion_rate")
  private double conversionRate;

  @SerializedName("conversion_result")
  private double conversionResult;

  @SerializedName("documentation")
  private String documentationUrl;

  @SerializedName("terms_of_use")
  private String termsOfUseUrl;

  @SerializedName("time_last_update_utc")
  private String lastUpdateUtc;

  public String getResultStatus() {
    return resultStatus;
  }

  public String getBaseCode() {
    return baseCode;
  }

  public String getTargetCode() {
    return targetCode;
  }

  public double getConversionRate() {
    return conversionRate;
  }

  public double getConversionResult() {
    return conversionResult;
  }

  public String getDocumentationUrl() {
    return documentationUrl;
  }

  public String getTermsOfUseUrl() {
    return termsOfUseUrl;
  }

  public String getLastUpdateUtc() {
    return lastUpdateUtc;
  }

  @Override
  public String toString() {
    return "CurrencyConversionResponse{" +
        "resultStatus='" + resultStatus + '\'' +
        ", baseCode='" + baseCode + '\'' +
        ", targetCode='" + targetCode + '\'' +
        ", conversionRate=" + conversionRate +
        ", conversionResult=" + conversionResult +
        ", lastUpdateUtc='" + lastUpdateUtc + '\'' +
        '}';
  }
}
