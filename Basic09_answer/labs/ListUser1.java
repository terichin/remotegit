// ArrayList���g�p���鎞�͕K��import�s���L�q���Ă�������
import java.util.*;

class ListUser1 {
    public static void main(String[] args) {
        // �w��̒l��������ItemDTO�I�u�W�F�N�g��2��������
        ItemDTO dto1 = new ItemDTO("Java�v���O���~���O��b", 5000);
        ItemDTO dto2 = new ItemDTO("�v���W�F�N�gJ", 12000);
        // ������ItemDTO�I�u�W�F�N�g��ۑ����邽�߂�ArrayList�𐶐�����
        ArrayList<ItemDTO> list = new ArrayList<ItemDTO>();
        // ��������ArrayList��2��ItemDTO�I�u�W�F�N�g��ۑ�����
        list.add(dto1);
        list.add(dto2);
        // ArrayList�ɕۑ����ꂽ�I�u�W�F�N�g�̏���\������
        // print()���\�b�h�̌Ăяo��
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