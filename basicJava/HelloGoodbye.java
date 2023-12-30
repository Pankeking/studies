public class HelloGoodbye {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide two names as CLI arguments");
        }
        String firstName = args[0];
        String secondName = args[1];

        System.out.println("Hello " + firstName + " and " + secondName + ".");
        System.out.println("Goodbye " + secondName + " and " + firstName + ".");
    }
}