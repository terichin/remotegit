class ExpSample7 {
    public static void main(String[] args) {
        try {
            print(args);
        } catch (UserExp e) {
            e.printMessage();
        }
    }
    
    static void print(String[] args) throws UserExp {
        try {
            int number = Integer.parseInt(args[0]);
            System.out.println(number * 2);
        } catch (NumberFormatException e) {
            throw new UserExp();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new UserExp();
        }
    }
}