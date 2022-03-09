package coursework_question1;

public class Car {
    private int id;
    private String name;
    private String colour;
    private double reservedPrice;
    private CarType gearbox;
    private CarBody body;
    private int numberOfSeats;
    private Condition condition;

    public String displayCarSpecification() {
        return id + " - " + name + " (£" + String.format("%.2f", reservedPrice) + ")\n" +
                "\t Type: " + gearbox + "\n" +
                "\t Style: " + body + "\n" +
                "\t Colour: " + colour + "\n" +
                "\t No. of Seats: " + numberOfSeats + "\n" +
                "\t Condition: " + condition;
    }

    public Car() {
    }

    public Car(int id, String name, double reservedPrice, Condition condition) {
        this.id = id;
        this.name = name;
        this.reservedPrice = reservedPrice;
        this.condition = condition;
    }

    public Car(String colour, CarType gearbox, CarBody body, int numberOfSeats) {
        this.colour = colour;
        this.gearbox = gearbox;
        this.body = body;
        this.numberOfSeats = numberOfSeats;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return reservedPrice;
    }

    public String getColour() {
        return colour;
    }

    public CarType getGearbox() {
        return gearbox;
    }

    public CarBody getBodyStyle() {
        return body;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setGearbox(CarType gearbox) {
        this.gearbox = gearbox;
    }

    public void setBody(CarBody body) {
        this.body = body;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
