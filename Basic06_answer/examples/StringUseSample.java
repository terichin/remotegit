class StringUseSample {
    public static void main(String[] args) {
        String str1 = "JavaBasic";
        String str2 = new String("JavaBasic");
        System.out.println("文字列の長さは" + str1.length() + "です");
        if (str1 == str2) {
            System.out.println("(str1 == str2)はtrueです");
        } else {
            System.out.println("(str1 == str2)はfalseです");
        }
        if (str1.equals(str2)) {
            System.out.println("(str1.equals(str2))はtrueです");
        } else {
            System.out.println("(str1.equals(str2))はfalseです");
        }
    }
}
