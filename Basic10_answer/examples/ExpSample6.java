class ExpSample6 {
    public static void main(String[] args) {
        try {
            System.out.println("�Ӑ}�I�Ƀ��[�U��`��O���N�����܂��B");
            throw new UserExp();
        } catch (UserExp e) {
            e.printMessage();
        }
    }
}