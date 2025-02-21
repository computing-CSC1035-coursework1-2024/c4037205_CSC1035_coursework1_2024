import java.util.ArrayList;

public class Reporting {
    private ArrayList<Manufacturer> manufacturers;

    public Reporting() {
        this.manufacturers = new ArrayList<>();
    }

    public void addManufacturer(Manufacturer manufacturer) {
        manufacturers.add(manufacturer);
    }

    public ArrayList<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public CarModel getMostExpensiveCarModel() {
        CarModel mostExpensive = null;
        for (Manufacturer manufacturer : manufacturers) {
            CarModel expensiveCar = manufacturer.getMostExpensiveCarModel();
            if (mostExpensive == null || expensiveCar.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = expensiveCar;
            }
        }
        return mostExpensive;
    }

    public Manufacturer getManufacturerWithHighestRevenueByType(String type) {
        Manufacturer highestRevenueManufacturer = null;
        double highestRevenue = 0.0;
        for (Manufacturer manufacturer : manufacturers) {
            double revenue = manufacturer.getTotalRevenueByType(type);
            if (revenue > highestRevenue) {
                highestRevenue = revenue;
                highestRevenueManufacturer = manufacturer;
            }
        }
        return highestRevenueManufacturer;
    }

    public ArrayList<CarModel> getAllCarModelsAbovePrice(double price) {
        ArrayList<CarModel> result = new ArrayList<>();
        for (Manufacturer manufacturer : manufacturers) {
            ArrayList<CarModel> carsAbovePrice = manufacturer.getCarModelsAbovePrice(price);
            result.addAll(carsAbovePrice);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Reporting{manufacturers=" + manufacturers + "}";
    }
}
