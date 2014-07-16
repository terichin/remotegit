import java.util.*;

class CollectionAdvance2 {
    public static ArrayList<ItemDTO> search(ArrayList<ItemDTO> list, String target) {
        // ����list�Ɋi�[���ꂽ���i�ꗗ�̂����A
        // ����target�ɂ��錟����Ə��i�̖��O�̐擪��������v����
        // ItemDTO�̈ꗗ��Ԃ�
        ArrayList<ItemDTO> glist = new ArrayList<ItemDTO>();
        // ArrayList�̃I�u�W�F�N�g�����̃��[�v
        for (int i = 0; i < list.size(); i++) {
            // ���Ԃ�ItemDTO�I�u�W�F�N�g�����o��
            ItemDTO dto = list.get(i);
            // �擾����ItemDTO�I�u�W�F�N�g���珤�i�����擾����
            String name = dto.getName();
            // DTO����擾�����l�ƁA�����œn���ꂽ���i����O����v��������
            if (startsmatch(name, target)) {
                // �Y�����鏤�i��ItemDTO�I�u�W�F�N�g��z��Ɋi�[����
                glist.add(dto);
            }
        }
        // �����Ƀq�b�g�������i���i�[�����z���Ԃ�
        // ��v���鏤�i�����������ꍇ�͗v�f���O��ArrayList�I�u�W�F�N�g��Ԃ�
        return glist;
    }

    public static void main(String[] args) {
        // ���i����ۑ�����ArrayList�𐶐����A�ϐ�list�ɕۑ�����
        ArrayList<ItemDTO> list = CollectionAdvance1.init();
        // ���i���X�g�Ə��i���������Ƃ���search���\�b�h���Ăяo��
        ArrayList<ItemDTO> glist = search(list, args[0]);
        if (glist.size() == 0) {
            // glist�̃T�C�Y���O�̏ꍇ�͏��i��������Ȃ������̂ŃG���[��\������
            System.out.println(args[0] + "�ł͂��܂閼�O�̏��i�͂���܂���");
        } else {
            for (int i = 0; i < glist.size(); i++) {
                // ���Ԃ�ItemDTO�I�u�W�F�N�g�����o��
                ItemDTO dto = glist.get(i);
                // �w��̏��i�̉��i��\������
                System.out.println(dto.getName() + "�̉��i��" 
                                          + dto.getPrice() + "�~�ł�");
            }
        }
    }

    public static boolean startsmatch(String seq, String target) {
        // ����target�Ɋi�[����Ă��镶���񂪁A
        // ����seq�̐擪�����ƈ�v����ꍇ��true���A
        // ��v���Ȃ��ꍇ��false��Ԃ�
        // �����L�[�Ɏw�肳��Ă��镶�������̃��[�v����

        // ����target�̕�����������seq�̕�������葽���ꍇ�́A
        // �O����v�����ΏۊO�Ȃ̂�false��Ԃ�
        if (target.length() > seq.length()) {
            return false;
        }
        for (int i = 0; i < target.length(); i++) {
            // �����Ώۂ�i�Ԗڂ̕������i�[����
            char seqchr = seq.charAt(i);
            // �����L�[��i�Ԗڂ̕������i�[����
            char tgtchr = target.charAt(i);
            // ��v���Ȃ��������������ꍇ��
            // �O����v�����Ƀq�b�g���Ȃ�����false��Ԃ�
            if (seqchr != tgtchr) {
                return false;
            }
        }
        // ��L���[�v�ł��ׂĂ̕�������v���Ă����ꍇ�A
        // �O����v�����Ƀq�b�g���邽��true��Ԃ�
        return true;
    }
}