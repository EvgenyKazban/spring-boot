package web.model;

public class Car {
    private String owner;
    private String model;
    private int series;

    public Car(String owner, String model, int series) {
        this.owner = owner;
        this.model = model;
        this.series = series;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
