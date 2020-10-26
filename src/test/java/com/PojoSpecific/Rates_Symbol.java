
package com.PojoSpecific;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rates_Symbol {

    @SerializedName("USD")
    @Expose
    private Double uSD;
    @SerializedName("GBP")
    @Expose
    private Double gBP;

    public Double getUSD() {
        return uSD;
    }

    public void setUSD(Double uSD) {
        this.uSD = uSD;
    }

    public Double getGBP() {
        return gBP;
    }

    public void setGBP(Double gBP) {
        this.gBP = gBP;
    }

}
