package my.snacksquad.app;

public class Restaurant {
    private int logoResource;
    private String name;

    public Restaurant(int logoResource, String name) {
        this.logoResource = logoResource;
        this.name = name;
    }

    public int getLogoResource() {
        return logoResource;
    }

    public String getName() {
        return name;
    }
}
