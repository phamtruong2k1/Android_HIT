package coursework_question1;

public class Offer {
    private double value;
    private User buyer;

    public User getBuyer() {
        return buyer;
    }

    public double getValue() {
        return value;
    }

    public Offer(double value, User buyer) {
        this.value = value;
        this.buyer = buyer;
    }

    public Offer(User buyer, double value) {
        this.value = value;
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return buyer + " offered £" + value;
    }
}
