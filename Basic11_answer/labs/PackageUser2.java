// �ʃp�b�P�[�W��Greeting2���g���̂�import�錾���K�v
import util.etc.Greeting2;

class PackageUser2 {
    public static void main(String[] args) {
        // import���Ă��Ȃ��N���X�͊��S�C�����ŗ��p�ł���
        util.etc.Greeting1 obj1 = new util.etc.Greeting1();
        // import�錾���Ă���N���X�𗘗p
        Greeting2 obj2 = new Greeting2();
        
        // �C���X�^���X�̃��\�b�h�Ăяo��
        obj1.sayHello();
        obj2.sayHello();
    }
}