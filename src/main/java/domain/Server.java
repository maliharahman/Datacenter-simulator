package domain;

public class Server {
    String id;
    long load;

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
}