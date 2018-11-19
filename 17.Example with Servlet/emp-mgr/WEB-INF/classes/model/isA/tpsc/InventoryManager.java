package model.isA.tpsc;

public class InventoryManager extends PPRUser {

    private String inventoryManager;

    public InventoryManager() {
    }

    public InventoryManager(int userId, String userName, String userEmail, String inventoryManager) {
        super(userId, userName, userEmail);
        this.inventoryManager = inventoryManager;
    }
    
    public String getInventoryManager() {
        return inventoryManager;
    }

    public void setInventoryManager(String inventoryManager) {
        this.inventoryManager = inventoryManager;
    }
}
