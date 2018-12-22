package model.isA.tpsc;

public class ProductManager extends Manager {

    private int prodId;
    private String productManager;
    private String state;
    public ProductManager() {
    }

    public ProductManager(String managerName, String managerEmail, String productManager, String state) {
        super(managerName, managerEmail);
        this.productManager = productManager;
        this.state = state;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProductManager() {
        return productManager;
    }

    public void setProductManager(String productManager) {
        this.productManager = productManager;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
