import java.util.*;

class CollectionAdvance1 {
    public static ArrayList<ItemDTO> init() {
        // �w��̏���������5��ItemDTO�I�u�W�F�N�g�𐶐�����
        ItemDTO dto1 = new ItemDTO("Java�v���O���~���O��b", 5000);
        ItemDTO dto2 = new ItemDTO("�v���W�F�N�gJ", 12000);
        ItemDTO dto3 = new ItemDTO("Java�v���O���~���O���p", 7000);
        ItemDTO dto4 = new ItemDTO("�Ɩ��菇��b", 3500);
        ItemDTO dto5 = new ItemDTO("�l�o�[�G���f�B���O�E�v���W�F�N�g", 25000);
        
        // ��������������ItemDTO�I�u�W�F�N�g��1��ArrayList�ɕۑ�����
        ArrayList<ItemDTO> list = new ArrayList<ItemDTO>();
        list.add(dto1);
        list.add(dto2);
        list.add(dto3);
        list.add(dto4);
        list.add(dto5);
        
        // ��������ArrayList��Ԃ�
        return list;
    }
    
    // ArrayList�ɕۑ����ꂽ���i�̉��i�̍��v�l�����߂�
    public static int getTotal(ArrayList<ItemDTO> list) {
        // ���v�l��ۑ�����ϐ�total���`����
        int total = 0;
        // ArrayList�̃I�u�W�F�N�g�����̃��[�v
        for (int i = 0; i < list.size(); i++) {
            // ���Ԃ�ItemDTO�I�u�W�F�N�g�����o��
            ItemDTO dto = list.get(i);
            // ���i�������o���A�ϐ�total�ɉ�����
            total += dto.getPrice();
        }
        // ���߂����v�l��Ԃ�
        return total;
    }
    
    public static void main(String[] args) {
        // ���i����ۑ�����ArrayList�𐶐����A�ϐ�list�ɕۑ�����
        ArrayList<ItemDTO> list = init();
        // ���v�l�����߂�getTotal���\�b�h���Ăяo���A���ʂ�\������
        System.out.println("���i�̍��v���z��" + getTotal(list) + "�~�ł�");
    }
}