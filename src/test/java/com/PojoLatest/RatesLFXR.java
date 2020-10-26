
package com.PojoLatest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatesLFXR {

    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("rates")
    @Expose
    private Rates1 rates1;
    @SerializedName("date")
    @Expose
    private String date;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Rates1 getRates() {
        return rates1;
    }

    public void setRates(Rates1 rates1) {
        this.rates1 = rates1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
