class OverLoadCall3 {
    public static void main(String[] args) {
        // �R�}���h���C�������̃`�F�b�N
        if (args.length != 1) {
            System.out.println("�����̕␳�l���P����ĉ�����");
            return;
        } else {
            int time = Integer.parseInt(args[0]);
            OverLoadObject3 obj = new OverLoadObject3();
            obj.printTime();
            obj.printTime(time);
        }
    }
}