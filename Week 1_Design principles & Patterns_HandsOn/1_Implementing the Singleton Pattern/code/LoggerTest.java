public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("message from logger1.");
        logger2.log("message from logger2.");

        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same. Singleton successful.");
        } else {
            System.out.println("Different logger instances. Singleton failed.");
        }
    }
}
