class ExpSample5 {
    public static void main(String[] args) {
        try {
            print(args);
        } catch (NumberFormatException e) {
            System.out.println("���͂���l�͐��l�łȂ���΂����܂���B");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("1�̐��l����͂��ĉ������B");
        }
    }
    
    static void print(String[] args) throws
        NumberFormatException, ArrayIndexOutOfBoundsException {
        int number = Integer.parseInt(args[0]);
        System.out.println(number * 2);
    }
}