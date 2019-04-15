package domain;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    String id;
    DataCenterStatus status;
    List<Server> serverList = new ArrayList<Server>();

    public DataCenter(String id, String region, long pvGeneration, long gridGeneration) {
        this.id = id;
        this.status = new DataCenterStatus(region, pvGeneration, gridGeneration);

        Server server1 = new Server(this.id + "-1" , 0);
        serverList.add(server1);

        Server server2 = new Server(this.id + "-2", 0);
        serverList.add(server2);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DataCenterStatus getStatus() {
        return status;
    }

    public void setStatus(DataCenterStatus status) {
        this.status = status;
    }

    public List<Server> getServerList() {
        return serverList;
    }

    public void setServerList(List<Server> serverList) {
        this.serverList = serverList;
    }

    @Override
    public String toString() {
        return "DataCenter{" +
                "id=" + id +
                ", status=" + status +
                ", serverList=" + serverList +
                '}';
    }
}