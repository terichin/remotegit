import java.util.*;

class ListUser2 {
    public static void main(String[] args) {
        // �w��̏���������ItemDTO�I�u�W�F�N�g��5��������
        ItemDTO dto1 = new ItemDTO("Java�v���O���~���O��b", 5000);
        ItemDTO dto2 = new ItemDTO("�v���W�F�N�gJ", 12000);
        ItemDTO dto3 = new ItemDTO("Java�v���O���~���O���p", 7000);
        ItemDTO dto4 = new ItemDTO("�Ɩ��菇��b", 3500);
        ItemDTO dto5 = new ItemDTO("�l�o�[�G���f�B���O�E�v���W�F�N�g", 25000);
        // ��������ItemDTO�I�u�W�F�N�g��1��ArrayList�ɕۑ�����
        ArrayList<ItemDTO> list = new ArrayList<ItemDTO>();
        list.add(dto1);
        list.add(dto2);
        list.add(dto3);
        list.add(dto4);
        list.add(dto5);
        // 3�Ԗ�ItemDTO�I�u�W�F�N�g�̈���폜����
        // ArrayList��0����ԍ����n�܂�̂ŁAdto4�������I�u�W�F�N�g���폜�����
        list.remove(3);
        // ArrayList�ɕۑ����ꂽ�SItemDTO�I�u�W�F�N�g�̏���\������
        print(list);
    }
    
    public static void print(ArrayList<ItemDTO> list) {
        // �����œn���ꂽArrayList�ɕۑ�����Ă���
        // �I�u�W�F�N�g�����̃��[�v���쐬
        for (int i = 0; i < list.size(); i++) {
            // ���ԂɃI�u�W�F�N�g�����o��
            ItemDTO obj = list.get(i);
            // DTO�I�u�W�F�N�g��������擾����
            String name = obj.getName();
            int price = obj.getPrice();
            // DTO�I�u�W�F�N�g������o��������\������
            System.out.println(name);
            System.out.println(price);
        }
    }
}