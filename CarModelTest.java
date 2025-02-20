public class CarModelTest {
    public static void main(String[] args) {
        CarModel car1 = new CarModel("BYD Tang", 2000.5, 45000.0, 150, "polo");
        CarModel car2 = new CarModel("BYD Qin", 1500.3, 30000.0, 500, "didi");

        System.out.println(car1.getName() + " total revenue: " + car1.totalRevenue());
        System.out.println(car2.getName() + " total revenue: " + car2.totalRevenue());

        System.out.println(car1);
        System.out.println(car2);
    }
}
