package coursework_question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Advert {
    private Car car;
    private List<Offer> offers;

    public Offer getHighestOffer(){
        if (offers.size() == 0)
            return null;
        Offer offerAns = offers.get(0);
        for (Offer offer :
                offers) {
            if (offerAns.getValue() < offer.getValue())
                offerAns = offer;
        }
        return offerAns;
    }

    public Car getCar() {
        return car;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public boolean placeOffer(User buyer, double value){
        if (offers == null)
            offers = new ArrayList<>();
        return offers.add(new Offer(value, buyer));
    }

    public Advert(Car car) {
        this.car = car;
    }

    public Advert() {
        this.car = new Car();
    }

    @Override
    public String toString() {
        return "Ad: " + car.displayCarSpecification();
    }
}
