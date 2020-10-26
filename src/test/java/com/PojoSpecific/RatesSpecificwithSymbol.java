
package com.PojoSpecific;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatesSpecificwithSymbol {

    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("rates")
    @Expose
    private Rates_Symbol rates_Symbol;
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
        return rates_Symbol;
    }

    public void setRates(Rates_Symbol rates_Symbol) {
        this.rates_Symbol = rates_Symbol;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
