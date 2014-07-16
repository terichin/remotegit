// �I�v�V�������7-2
class InheritAdvance2 {
    public static void main(String[] args) {
        // ���i��񏉊���
        Item[] itemArray = InheritAdvance1.init();
        
        if (args.length == 1) {
            // �l�i�݂̂Ō��������s
            int price = Integer.parseInt(args[0]);
            search(itemArray, price);
        } else if (args.length == 2) {
            // �l�i�Ǝ�ނŌ��������s
            int price = Integer.parseInt(args[0]);
            int kind = Integer.parseInt(args[1]);
            search(itemArray, price, kind);
        } else {
            System.out.println("�g�p�@: InheritAdvance2 �l�i [���]");
        }
        
    }
    
    static void search(Item[] itemArray, int price) {
        // �l�i�Ō��������s����
        System.out.println(price + "�~�ȉ��̏��i���X�g");
        for (int i = 0; i < itemArray.length; ++i) {
            // �w��̋��z�ȉ��̏��i�̖��O��\��
            if (itemArray[i].price <= price) {
                System.out.println(itemArray[i].name);
            }
        }
    }
    
    static void search(Item[] itemArray, int price, int kind) {
        // �l�i�Ǝ�ނŌ��������s����
        if (kind == 1) {
            // �w��̋��z�ȉ��̖{�̖��O��\��
            System.out.println(price + "�~�ȉ��̖{���X�g");
            for (int i = 0; i < itemArray.length; ++i) {
                if ((itemArray[i].price <= price) && 
                         (itemArray[i] instanceof ItemBook)){
                    System.out.println(itemArray[i].name);
                }
            }
        } else if (kind == 2) {
            // �w��̋��z�ȉ���DVD�̖��O��\��
            System.out.println(price + "�~�ȉ���DVD���X�g");
            for (int i = 0; i < itemArray.length; ++i) {
                if ((itemArray[i].price <= price) && 
                         (itemArray[i] instanceof ItemDVD)){
                    System.out.println(itemArray[i].name);
                }
            }
        } else {
            // ��ޕs��
            System.out.println("���i�̎�ނ�1��2�œ��͂��Ă�������");
        }
    }
}