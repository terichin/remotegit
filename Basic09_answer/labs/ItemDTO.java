class ItemDTO {
    // ���i����ۑ����郁���o�ϐ�(����J)
    private String name;
    // ���i��ۑ����郁���o�ϐ�(����J)
    private int price;
    
    public ItemDTO(String name, int price) {
        // �����Ŏ󂯎�������i���������o�ϐ��ɑ������
        this.name = name;
        // �����Ŏ󂯎�������i�������o�ϐ��ɑ������
        this.price = price;
    }
    
    // ���i����Ԃ�getter���\�b�h
    public String getName() {
        return name;
    }
    
    // ���i��Ԃ�getter���\�b�h
    public int getPrice() {
        return price;
    }
}