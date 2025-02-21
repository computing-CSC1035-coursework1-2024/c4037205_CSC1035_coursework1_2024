public class ReportingIOTest {
    public static void main(String[] args) {
        Reporting reporting = new Reporting();
        ReportingIO reportingIO = new ReportingIO(reporting);
        int choice;
        do {
            reportingIO.printMenu();
            choice = reportingIO.getMenuChoice();
            reportingIO.processMenuChoice(choice);
        } while (choice != 6);
    }
}
