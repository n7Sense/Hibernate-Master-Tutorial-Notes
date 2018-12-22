package model.isA.tpsc;

public class ProductManager extends PPRUser {

    private String productManager;

    public ProductManager() {
    }

    public ProductManager(int userId, String userName, String userEmail, String productManager) {
        super(userId, userName, userEmail);
        this.productManager = productManager;
    }
    
    public String getProductManager() {
        return productManager;
    }

    public void setProductManager(String productManager) {
        this.productManager = productManager;
    }
}
