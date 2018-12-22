package model;

public class NamedNativeQueryModel {
    private int namedId;
    private String name;
    private String rashi;

    public NamedNativeQueryModel() {
    }

    public NamedNativeQueryModel(String name, String rashi) {
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
}
