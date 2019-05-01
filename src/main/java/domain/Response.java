package domain;

import java.util.Date;

public class Response {
    Date timestamp;
    double responseSize;
    double energyConsumed;
    double pvGeneration;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getResponseSize() {
        return responseSize;
    }

    public void setResponseSize(double responseSize) {
        this.responseSize = responseSize;
    }

    public double getEnergyConsumed() {
        return energyConsumed;
    }

    public void setEnergyConsumed(double energyConsumed) {
        this.energyConsumed = energyConsumed;
    }

    public double getPvGeneration() {
        return pvGeneration;
    }

    public void setPvGeneration(double pvGeneration) {
        this.pvGeneration = pvGeneration;
    }

    @Override
    public String toString() {
        return "Response{" +
                "timestamp=" + timestamp +
                ", responseSize=" + responseSize +
                ", energyConsumed=" + energyConsumed +
                ", pvGeneration=" + pvGeneration +
                '}';
    }
}