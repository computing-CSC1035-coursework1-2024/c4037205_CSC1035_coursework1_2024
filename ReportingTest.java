import java.util.ArrayList;

public class ReportingTest {
    public static void main(String[] args) {
        Manufacturer byd = new Manufacturer("BYD");

        CarModel car1 = new CarModel("BYD Tang", 2000.5, 45000.0, 150, "saloon");
        CarModel car2 = new CarModel("BYD Qin", 1500.3, 30000.0, 500, "hatchback");
        CarModel car3 = new CarModel("BYD Song", 1600.2, 50000.0, 200, "estate");

        byd.addCarModel(car1);
        byd.addCarModel(car2);
        byd.addCarModel(car3);
        Manufacturer xiaomi = new Manufacturer("Xiaomi");

        CarModel car4 = new CarModel("Xiaomi Su 7", 1800.4, 35000.0, 400, "saloon");
        CarModel car5 = new CarModel("Xiaomi Su 8", 1400.2, 25000.0, 600, "hatchback");
        CarModel car6 = new CarModel("Xiaomi Su 9", 1600.1, 40000.0, 300, "estate");

        xiaomi.addCarModel(car4);
        xiaomi.addCarModel(car5);
        xiaomi.addCarModel(car6);

        Reporting reporting = new Reporting();
        reporting.addManufacturer(byd);
        reporting.addManufacturer(xiaomi);

        System.out.println("Most expensive car model: " + reporting.getMostExpensiveCarModel());

        Manufacturer highestRevenueManufacturer = reporting.getManufacturerWithHighestRevenueByType("saloon");
        System.out.println("Manufacturer with highest revenue for saloon cars: " + highestRevenueManufacturer.getName());

        ArrayList<CarModel> carsAbovePrice = reporting.getAllCarModelsAbovePrice(40000);
        System.out.println("Cars above price 40000: ");
        for (CarModel car : carsAbovePrice) {
            System.out.println(car);
        }

        System.out.println(reporting);
    }
}
