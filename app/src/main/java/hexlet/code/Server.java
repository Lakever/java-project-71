package hexlet.code;

public class Server {
    private String hostname;
    private int timeout;
    private String proxy;
    private boolean follow;

    public Server(String hostname, int timeout, String proxy, boolean follow) {
        this.hostname = hostname;
        this.timeout = timeout;
        this.proxy = proxy;
        this.follow = follow;
    }

    public String getHostname() {
        return hostname;
    }

    public int getTimeout() {
        return timeout;
    }

    public String getProxy() {
        return proxy;
    }

    public boolean isFollow() {
        return follow;
    }

    public String setHostname(String hostname) {
        return this.hostname = hostname;
    }

    public int setTimeout(int timeout) {
        return this.timeout = timeout;
    }

    public String setProxy(String proxy) {
        return this.proxy = proxy;
    }

    public boolean setFollow(boolean follow) {
        return this.follow = follow;
    }

    /**
     * Выводит информацию о конфигурации подключения.
     */
    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format(
                "ConnectionConfig{hostname='%s', timeout=%d, proxy='%s', follow=%b}",
                hostname, timeout, proxy, follow
        );
    }
}