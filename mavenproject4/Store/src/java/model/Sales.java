package model;

public class Sales {
    private int productId;
    private int customerId;

    public Sales() {
    }

    public Sales(int productId, int customerId) {
        this.productId = productId;
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Sales{" + "productId=" + productId + ", customerId=" + customerId + '}';
    }
    
    
}
