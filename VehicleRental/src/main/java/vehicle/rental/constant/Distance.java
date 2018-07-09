package vehicle.rental.constant;

public enum Distance {

    PUNE(0),MUMBAI(200),BANGLORE(1000),DELHI(2050),CHENNAI(1234.5);
    private Double value;
    Distance(double v){
        this.value=v;
    }

    public double getValue(){
        return value;
    }

    static public Double calculateDistance(Distance d1, Distance d2){
        return d1.getValue() + d2.getValue();
    }
}
