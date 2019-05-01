package domain;

public class Server {
    String id;
    long load;
    int busyTickCount = 0;
    boolean isBusy = false;

    public Server(String id, long load) {
        this.id = id;
        this.load = load;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getLoad() {
        return load;
    }

    public void setLoad(long load) {
        this.load = load;
    }

    public int getBusyTickCount() {
        return busyTickCount;
    }

    public void setBusyTickCount(int busyTickCount) {
        this.busyTickCount = busyTickCount;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public void updateStatus() {
        if (this.isBusy) {
            busyTickCount --;
            if (busyTickCount == 0) {
                isBusy = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Server{" +
                "id='" + id + '\'' +
                ", busyTickCount=" + busyTickCount +
                ", isBusy=" + isBusy +
                '}';
    }
}