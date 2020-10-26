
package com.PojoSpecific;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatesSpecificwithBase {

    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("rates")
    @Expose
    private Rates_Base rates_Base;
    @SerializedName("date")
    @Expose
    private String date;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Rates_Base getRates() {
        return rates_Base;
    }

    public void setRates(Rates_Base rates_Base) {
        this.rates_Base = rates_Base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
