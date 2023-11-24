package HotelRoomService;

public class PaymentInfo {

    private String paymentType;
    private double amount;
    private String description;

    public PaymentInfo(String paymentType, double amount, String description) {
        this.paymentType = paymentType;
        this.amount = amount;
        this.description = description;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}