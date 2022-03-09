package coursework_question1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Auctioneer{
    private String name;
    private Map<Advert, User> carsForSale;
    private Map<Advert, User> soldCars;
    private Map<Advert, User> unsoldCars;

    public boolean checkExistence(Car car){
        return carsForSale == null ? false : carsForSale.containsKey(new Advert(car));
    }

    public String displaySoldCars(){
        String ans = "SOLD CARS:\n";
        if (soldCars == null)
            return ans;
        for (Map.Entry<Advert, User> sold :
                soldCars.entrySet()) {
            ans += sold.getKey().getCar().getID() + " - Purchased by " + sold.getValue().getName() + " with a successful £" + String.format("%.2f",sold.getKey().getCar().getPrice()) + " bid. ";
            ans += "\n";
        }
        return ans;
    }

    public String displayStatistics(){
        return "Statistics";
    }

    public String displayUnsoldCars(){
        String ans = "UNSOLD CARS:\n";
        if (unsoldCars == null)
            return ans;
        for (Map.Entry<Advert, User> unsold :
                unsoldCars.entrySet()) {
            ans += unsold.getKey();
            ans += "\n";
        }
        return ans;
    }

    public void endSale(Advert advert){
        if (unsoldCars == null)
            return;
        if (advert == null)
            return;
        unsoldCars.remove(advert);
    }

    public boolean placeOffer(Advert carAdvert, User user, double value){
        if (carAdvert == null)
            return false;
        if (checkExistence(carAdvert.getCar()))
            return false;
        carAdvert.placeOffer(user, value);
        if (soldCars == null)
            soldCars = new HashMap<>();
        soldCars.put(carAdvert, user);
        return true;
    }

    public void registerCar(Advert carAdvert, User user, String colour, CarType type, CarBody body, int noOfSeats){
        if (carAdvert == null)
            carAdvert = new Advert();
        if (user == null)
            user = new User();
        carAdvert.getCar().setColour(colour);
        carAdvert.getCar().setGearbox(type);
        carAdvert.getCar().setBody(body);
        carAdvert.getCar().setNumberOfSeats(noOfSeats);
        if (carsForSale == null)
            carsForSale = new HashMap<>();
        carsForSale.put(carAdvert, user);
        if (unsoldCars == null)
            unsoldCars = new HashMap<>();
        unsoldCars.put(carAdvert, user);
    }

    public Auctioneer(String name) {
        this.name = name;
    }
}
