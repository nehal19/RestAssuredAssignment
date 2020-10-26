
package com.PojoSpecific;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatesSpecificwithSymbolandBase {

    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("rates")
    @Expose
    private Rates_SymbolandBase rates_SymbolandBase;
    @SerializedName("date")
    @Expose
    private String date;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Rates_SymbolandBase getRates() {
        return rates_SymbolandBase;
    }

    public void setRates(Rates_SymbolandBase rates_SymbolandBase) {
        this.rates_SymbolandBase = rates_SymbolandBase;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
