class StringUseSample {
    public static void main(String[] args) {
        String str1 = "JavaBasic";
        String str2 = new String("JavaBasic");
        System.out.println("������̒�����" + str1.length() + "�ł�");
        if (str1 == str2) {
            System.out.println("(str1 == str2)��true�ł�");
        } else {
            System.out.println("(str1 == str2)��false�ł�");
        }
        if (str1.equals(str2)) {
            System.out.println("(str1.equals(str2))��true�ł�");
        } else {
            System.out.println("(str1.equals(str2))��false�ł�");
        }
    }
}
