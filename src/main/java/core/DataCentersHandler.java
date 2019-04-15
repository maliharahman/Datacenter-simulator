package core;

import domain.DataCenter;

import java.util.ArrayList;
import java.util.List;

public class DataCentersHandler{
    private static final DataCentersHandler dataCentersHandler = new DataCentersHandler();
    public List<DataCenter> availableDataCenters = new ArrayList<DataCenter>();

    private DataCentersHandler () {
    }

    public static DataCentersHandler getInstance() {
        return dataCentersHandler;
    }

    public static DataCentersHandler getDataCentersHandler() {
        return dataCentersHandler;
    }

    public List<DataCenter> getAvailableDataCenters() {
        return availableDataCenters;
    }

    public void setAvailableDataCenters(List<DataCenter> availableDataCenters) {
        this.availableDataCenters = availableDataCenters;
    }
}