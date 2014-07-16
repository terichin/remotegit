// �I�v�V�������7-1
class InheritAdvance1 {
    public static void main(String[] args) {
        // ���i��񏉊���
        Item[] itemArray = init();
        
        // ���v�l�̎擾�ƕ\��
        System.out.println("���i�̍��v���z��" + getTotal(itemArray) + "�~�ł�");
        
        // �{�̍��v�l�̎擾�ƕ\��
        System.out.println("�{�̍��v���z��" + getBookTotal(itemArray) + "�~�ł�");
        
        // DVD�̍��v�l�̎擾�ƕ\��
        System.out.println("DVD�̍��v���z��" + getDVDTotal(itemArray) + "�~�ł�");        
    }
    
    static Item[] init() {
        // Item�̔z��쐬
        Item[] itemArray = new Item[5];
        
        // ���i1���ݒ�
        ItemBook book1 = new ItemBook();
        book1.name = "Java�v���O���~���O��b";
        book1.price = 5000;
        book1.author = "NTT�f�[�^���j�o�[�V�e�B";
        book1.isbn = "XXXX-YYYYYY-ZZZZ";
        itemArray[0] = book1;
        
        // ���i2���ݒ�
        ItemDVD dvd1 = new ItemDVD();
        dvd1.name = "�v���W�F�N�gJ";
        dvd1.price = 12000;
        dvd1.time = 120;
        itemArray[1] = dvd1;
        
        // ���i3���ݒ�
        ItemBook book2 = new ItemBook();
        book2.name = "Java�v���O���~���O���p";
        book2.price = 3500;
        book2.author = "NTT�f�[�^���j�o�[�V�e�B";
        book2.isbn = "XXXX-YYYYYY-AAAA";
        itemArray[2] = book2;
        
        // ���i4���ݒ�
        ItemBook book3 = new ItemBook();
        book3.name = "�Ɩ��菇��b";
        book3.price = 7000;
        book3.author = "NTT�f�[�^";
        book3.isbn = "XXXX-ZZZZZZ-AAAA";
        itemArray[3] = book3;
        
        // ���i5���ݒ�
        ItemDVD dvd2 = new ItemDVD();
        dvd2.name = "�l�o�[�G���f�B���O�E�v���W�F�N�g";
        dvd2.price = 25000;
        dvd2.time = 250;
        itemArray[4] = dvd2;
        
        // �쐬�������i���z���Ԃ�
        return itemArray;
    }
    
    static int getTotal(Item[] itemArray) {
        // �����S���i�̍��v���z���v�Z���ĕԂ�
        int total = 0;
        for (int i = 0; i < itemArray.length; ++i) {
            total += itemArray[i].price;
        }
        
        // ���v�l
        return total;
    }
    
    static int getBookTotal(Item[] itemArray) {
        // �����{�̍��v���z���v�Z���ĕԂ�
        int bookTotal = 0;
        for (int i = 0; i < itemArray.length; ++i) {
            // �{���ǂ����𒲂ׁA�{�ł���΍��v�l�ɉ��Z���܂�
            if (itemArray[i] instanceof ItemBook) {
                bookTotal += itemArray[i].price;
            }
        }
        
        // �{�̍��v�l
        return bookTotal;
    }
    
    static int getDVDTotal(Item[] itemArray) {
        // ����DVD�̍��v���z���v�Z���ĕԂ�
        int dvdTotal = 0;
        for (int i = 0; i < itemArray.length; ++i) {
            // DVD���ǂ����𒲂ׁADVD�ł���΍��v�l�ɉ��Z���܂�
            if (itemArray[i] instanceof ItemDVD) {
                dvdTotal += itemArray[i].price;
            }
        }
        
        // DVD�̍��v�l
        return dvdTotal;
    }
}