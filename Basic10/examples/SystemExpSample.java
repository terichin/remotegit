class SystemExpSample {
    public static void main(String[] args) {
        try {
            print(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    static void print(String[] args) throws Exception {
        try {
            int number = Integer.parseInt(args[0]);
            System.out.println(number * 2);
        } catch (NumberFormatException e) {
            throw new Exception("”’l‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢B");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("“ü—Í‚ª‚ ‚è‚Ü‚¹‚ñB");
        }
    }
}