class ExpSample6 {
    public static void main(String[] args) {
        try {
            System.out.println("意図的にユーザ定義例外を起こします。");
            throw new UserExp();
        } catch (UserExp e) {
            e.printMessage();
        }
    }
}