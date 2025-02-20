import java.util.ArrayList;

public class ManufacturerTest {
    public static void main(String[] args) {

        Manufacturer byd = new Manufacturer("BYD");

        CarModel car1 = new CarModel("BYD Tang", 2000.5, 45000.0, 150, "saloon");
        CarModel car2 = new CarModel("BYD Qin", 1500.3, 30000.0, 500, "hatchback");
        CarModel car3 = new CarModel("BYD Song", 1600.2, 50000.0, 200, "estate");

        byd.addCarModel(car1);
        byd.addCarModel(car2);
        byd.addCarModel(car3);

        System.out.println("Most expensive car model: " + byd.getMostExpensiveCarModel());

        System.out.println("Total revenue for saloon cars: " + byd.getTotalRevenueByType("saloon"));

        ArrayList<CarModel> carsAbovePrice = byd.getCarModelsAbovePrice(30000);
        System.out.println("Cars above price 30000: ");
        for (CarModel car : carsAbovePrice) {
            System.out.println(car);
        }

        System.out.println(byd);
    }
}
