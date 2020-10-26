package com.PojoLatest;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RateswithSymbol {

@SerializedName("base")
@Expose
private String base;
@SerializedName("rates")
@Expose
private Rates_Symbol rates_symbol;
@SerializedName("date")
@Expose
private String date;

public String getBase() {
return base;
}

public void setBase(String base) {
this.base = base;
}

public Rates_Symbol getRates() {
return rates_symbol;
}

public void setRates(Rates_Symbol rates_symbol) {
this.rates_symbol = rates_symbol;
}

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

}
