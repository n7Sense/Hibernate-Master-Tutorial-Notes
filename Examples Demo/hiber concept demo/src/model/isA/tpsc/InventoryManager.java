package model.isA.tpsc;

public class InventoryManager extends Manager {

    private int invtId;
    private String inventoryManager;
    private String location;

    public InventoryManager() {
    }

    public InventoryManager(String managerName, String managerEmail, String inventoryManager, String location) {
        super(managerName, managerEmail);
        this.inventoryManager = inventoryManager;
        this.location = location;
    }

    public String getInventoryManager() {
        return inventoryManager;
    }

    public void setInventoryManager(String inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getInvtId() {
        return invtId;
    }
}
