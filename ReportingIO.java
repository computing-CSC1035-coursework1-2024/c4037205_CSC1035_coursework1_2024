import java.util.Scanner;

/**
 * The ReportingIO class is responsible for interacting with the user through the console.
 * It provides a menu for users to choose different operations such as entering manufacturer data,
 * entering car model data, listing manufacturers, showing statistics, and more.
 */
public class ReportingIO {
    private Reporting reporting; // The Reporting instance that handles manufacturers and car models data
    private Scanner scanner; // Scanner for reading user input from the console

    /**
     * Constructs a new ReportingIO object with the given Reporting instance.
     *
     * @param reporting The Reporting instance that manages manufacturers and car models
     */
    public ReportingIO(Reporting reporting) {
        this.reporting = reporting;
        this.scanner = new Scanner(System.in); // Initialize the scanner for user input
    }

    /**
     * Displays the menu options for the user to choose from.
     * The options include entering manufacturer data, entering car model data, listing manufacturers, and more.
     */
    public void printMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Enter manufacturer data");
        System.out.println("2. Enter car model data");
        System.out.println("3. List all manufacturers");
        System.out.println("4. List all car models by a given manufacturer");
        System.out.println("5. Show statistics");
        System.out.println("6. Exit");
    }

    /**
     * Prompts the user to enter their choice from the menu and returns the choice.
     *
     * @return The choice selected by the user
     */
    public int getMenuChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt(); // Read and return the user's menu choice
    }

    /**
     * Processes the user's menu choice by calling the appropriate method
     * based on the user's input.
     *
     * @param choice The user's menu choice
     */
    public void processMenuChoice(int choice) {
        switch (choice) {
            case 1:
                enterManufacturerData(); // Calls the method to enter manufacturer data
                break;
            case 2:
                enterCarModelData(); // Calls the method to enter car model data
                break;
            case 3:
                listAllManufacturers(); // Calls the method to list all manufacturers
                break;
            case 4:
                listCarModelsByManufacturer(); // Calls the method to list car models by a given manufacturer
                break;
            case 5:
                showStatistics(); // Calls the method to show statistics
                break;
            case 6:
                System.out.println("Exiting..."); // Exits the program
                break;
            default:
                System.out.println("Invalid choice, please try again."); // If the user enters an invalid choice
        }
    }

    /**
     * Prompts the user to enter the manufacturer name and adds it to the report.
     */
    private void enterManufacturerData() {
        System.out.print("Enter manufacturer name: ");
        scanner.nextLine();  // Consume the leftover newline character from previous input
        String manufacturerName = scanner.nextLine(); // Read the manufacturer name
        Manufacturer manufacturer = new Manufacturer(manufacturerName); // Create a new Manufacturer object
        reporting.addManufacturer(manufacturer); // Add the manufacturer to the report
        System.out.println("Manufacturer " + manufacturerName + " added."); // Confirmation message
    }

    /**
     * Prompts the user to enter car model data (such as name, weight, price, etc.)
     * and adds it to the given manufacturer's list of car models.
     */
    private void enterCarModelData() {
        System.out.print("Enter manufacturer name: ");
        scanner.nextLine();  // Consume the leftover newline character
        String manufacturerName = scanner.nextLine(); // Read the manufacturer name

        Manufacturer manufacturer = findManufacturer(manufacturerName); // Find the manufacturer by name
        if (manufacturer != null) {
            // If manufacturer is found, ask for car model data
            System.out.print("Enter car model name: ");
            String modelName = scanner.nextLine();
            System.out.print("Enter weight: ");
            double weight = scanner.nextDouble();
            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter number sold: ");
            int numberSold = scanner.nextInt();
            System.out.print("Enter car type (saloon, hatchback, estate): ");
            scanner.nextLine();  // Consume the leftover newline character
            String type = scanner.nextLine();

            CarModel carModel = new CarModel(modelName, weight, price, numberSold, type); // Create a new CarModel
            manufacturer.addCarModel(carModel); // Add the car model to the manufacturer
            System.out.println("Car model " + modelName + " added."); // Confirmation message
        } else {
            System.out.println("Manufacturer not found."); // If manufacturer is not found
        }
    }

    /**
     * Finds a manufacturer by its name from the list of manufacturers in the report.
     *
     * @param name The name of the manufacturer to find
     * @return The manufacturer object if found, or null if not found
     */
    private Manufacturer findManufacturer(String name) {
        for (Manufacturer manufacturer : reporting.getManufacturers()) {
            if (manufacturer.getName().equalsIgnoreCase(name)) { // Compare names case-insensitively
                return manufacturer; // Return the manufacturer if found
            }
        }
        return null; // Return null if no manufacturer is found
    }

    /**
     * Lists all the manufacturers present in the report.
     */
    private void listAllManufacturers() {
        System.out.println("Manufacturers:");
        for (Manufacturer manufacturer : reporting.getManufacturers()) {
            System.out.println(manufacturer.getName()); // Print the name of each manufacturer
        }
    }

    /**
     * Lists all the car models of a given manufacturer.
     *
     * @param manufacturerName The name of the manufacturer whose car models need to be listed
     */
    private void listCarModelsByManufacturer() {
        System.out.print("Enter manufacturer name: ");
        scanner.nextLine();  // Consume the leftover newline character
        String manufacturerName = scanner.nextLine(); // Read the manufacturer name

        Manufacturer manufacturer = findManufacturer(manufacturerName); // Find the manufacturer by name
        if (manufacturer != null) {
            System.out.println("Car models by " + manufacturerName + ":");
            for (CarModel carModel : manufacturer.getCarModels()) {
                System.out.println(carModel); // Print each car model of the manufacturer
            }
        } else {
            System.out.println("Manufacturer not found."); // If manufacturer is not found
        }
    }

    /**
     * Shows the statistics based on car types and price thresholds.
     * It displays the most expensive car model, the manufacturer with the highest revenue
     * for a given car type, and car models above a given price.
     */
    private void showStatistics() {
        System.out.println("Statistics:");
        CarModel mostExpensiveCar = reporting.getMostExpensiveCarModel(); // Get the most expensive car
        System.out.println("Most expensive car model: " + mostExpensiveCar);

        System.out.print("Enter car type for statistics (saloon, hatchback, estate): ");
        scanner.nextLine();  // Consume the leftover newline character
        String carType = scanner.nextLine(); // Read the car type

        Manufacturer highestRevenueManufacturer = reporting.getManufacturerWithHighestRevenueByType(carType); // Get the manufacturer with the highest revenue for the selected car type
        if (highestRevenueManufacturer != null) {
            System.out.println("Manufacturer with highest revenue for " + carType + " cars: " + highestRevenueManufacturer.getName());
        } else {
            System.out.println("No manufacturer found with revenue for " + carType + " cars."); // If no manufacturer is found
        }

        System.out.print("Enter price threshold for cars: ");
        double priceThreshold = scanner.nextDouble(); // Read the price threshold
        System.out.println("Cars above price " + priceThreshold + ":");
        for (CarModel car : reporting.getAllCarModelsAbovePrice(priceThreshold)) {
            System.out.println(car); // List cars above the price threshold
        }
    }
}
