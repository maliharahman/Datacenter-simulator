package domain;

public class DataCenterStatus {
    String region;
    long pvGeneration;
    long gridGeneration;
    long load;

    DataCenterStatus(String region, long pvGeneration, long gridGeneration) {
        this.region = region;
        this.pvGeneration = pvGeneration;
        this.gridGeneration = gridGeneration;
        this.load = 0;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public long getPvGeneration() {
        return pvGeneration;
    }

    public void setPvGeneration(long pvGeneration) {
        this.pvGeneration = pvGeneration;
    }

    public long getGridGeneration() {
        return gridGeneration;
    }

    public void setGridGeneration(long gridGeneration) {
        this.gridGeneration = gridGeneration;
    }

    public long getLoad() {
        return load;
    }

    public void setLoad(long load) {
        this.load = load;
    }

    @Override
    public String toString()
    {
        return "DataCenterStatus{" +
                "region='" + region + '\'' +
                ", pvGeneration=" + pvGeneration +
                ", gridGeneration=" + gridGeneration +
                ", load=" + load +
                '}';
    }
}