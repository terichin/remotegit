class ExpSample3 {
    public static void main(String[] args) {
        try {
            int number = Integer.parseInt(args[0]);
            System.out.println(number * 2);
        } catch (NumberFormatException e) {
            System.out.println("���͂���l�͐��l�łȂ���΂����܂���B");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("1�̐��l����͂��ĉ������B");
        }
    }
}