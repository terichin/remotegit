class StringUseSample {
    public static void main(String[] args) {
        String str1 = "JavaBasic";
        String str2 = new String("JavaBasic");
        System.out.println("•¶Žš—ñ‚Ì’·‚³‚Í" + str1.length() + "‚Å‚·");
        if (str1 == str2) {
            System.out.println("(str1 == str2)‚Ítrue‚Å‚·");
        } else {
            System.out.println("(str1 == str2)‚Ífalse‚Å‚·");
        }
        if (str1.equals(str2)) {
            System.out.println("(str1.equals(str2))‚Ítrue‚Å‚·");
        } else {
            System.out.println("(str1.equals(str2))‚Ífalse‚Å‚·");
        }
    }
}
