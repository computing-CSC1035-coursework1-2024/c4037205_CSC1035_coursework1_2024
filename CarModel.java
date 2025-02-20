public class CarModel {
    private String name;
    private double weight;
    private double price;
    private int numberSold;
    private String type;

    public CarModel(String name, double weight, double price, int numberSold, String type) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.numberSold = numberSold;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberSold() {
        return numberSold;
    }

    public void setNumberSold(int numberSold) {
        this.numberSold = numberSold;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // 计算车辆的总收入
    public double totalRevenue() {
        return price * numberSold;
    }

    @Override
    public String toString() {
        return "CarModel{name='" + name + "', weight=" + weight + ", price=" + price + ", numberSold=" + numberSold + ", type='" + type + "'}";
    }
}

