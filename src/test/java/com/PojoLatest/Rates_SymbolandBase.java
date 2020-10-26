
package com.PojoLatest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rates_SymbolandBase {

    @SerializedName("GBP")
    @Expose
    private Double gBP;

    public Double getGBP() {
        return gBP;
    }

    public void setGBP(Double gBP) {
        this.gBP = gBP;
    }

}
