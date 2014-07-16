class CatchExpSample {
    public static void main(String[] args) {
        try {
            int number = Integer.parseInt(args[0]);
            System.out.println(number * 2);
        } catch (Exception e) {
            System.out.println("1‚Â‚Ì”’l‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B");
        }
    }
}