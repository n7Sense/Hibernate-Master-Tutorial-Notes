package model;

public class NamedQueryModel {
    private int namedId;
    private String name;
    private String rashi;

    public NamedQueryModel() {
    }

    public NamedQueryModel(String name, String rashi) {
        this.name = name;
        this.rashi = rashi;
    }

    public int getNamedId() {
        return namedId;
    }

    public void setNamedId(int namedId) {
        this.namedId = namedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRashi() {
        return rashi;
    }

    public void setRashi(String rashi) {
        this.rashi = rashi;
    }

    @Override
    public String toString() {
        return "NamedQueryModel{" +
                "namedId=" + namedId +
                ", name='" + name + '\'' +
                ", rashi='" + rashi + '\'' +
                '}';
    }
}
