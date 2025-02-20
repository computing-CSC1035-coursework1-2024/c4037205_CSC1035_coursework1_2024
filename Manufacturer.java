import java.util.ArrayList;

public class Manufacturer {
    private String name;
    private ArrayList<CarModel> carModels;

    public Manufacturer(String name) {
        this.name = name;
        this.carModels = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCarModel(CarModel carModel) {
        carModels.add(carModel);
    }

    public CarModel getMostExpensiveCarModel() {
        CarModel mostExpensive = carModels.get(0);
        for (CarModel car : carModels) {
            if (car.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = car;
            }
        }
        return mostExpensive;
    }

    public double getTotalRevenueByType(String type) {
        double totalRevenue = 0.0;
        for (CarModel car : carModels) {
            if (car.getType().equals(type)) {
                totalRevenue += car.totalRevenue();
            }
        }
        return totalRevenue;
    }

    public ArrayList<CarModel> getCarModelsAbovePrice(double price) {
        ArrayList<CarModel> result = new ArrayList<>();
        for (CarModel car : carModels) {
            if (car.getPrice() > price) {
                result.add(car);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Manufacturer{name='" + name + "', carModels=" + carModels + "}";
    }
}
