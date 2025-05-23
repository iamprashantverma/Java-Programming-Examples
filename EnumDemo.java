enum OrderStatus {
    PLACED(100, "Order Placed"),
    SHIPPED(200, "Order Shipped"),
    DELIVERED(300, "Order Delivered");

    private final int code;
    private final String description;

    // Constructor
    OrderStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    // Getter methods
    public int getStatusCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}

public class EnumDemo{
    public static void main(String[] args) {
        OrderStatus os = OrderStatus.DELIVERED ;
        System.out.println(os.getDescription());
        System.err.println(os.getStatusCode());
        System.out.println(os.name());
    }
}