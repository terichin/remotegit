class CastSample {
    public static void main(String[] args) {
        Dog obj1 = new Dog();
        Animal obj2 = obj1;     // アップキャスト
        Dog obj3 = (Dog)obj2;   // ダウンキャスト
    }
}