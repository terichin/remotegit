class InheritChild3 extends InheritParent3 {
    // ���E�W�������擾���郁�\�b�h
    String getWorldTime() {
        int whour = hour - 9;
        // �������}�C�i�X�̎��͕␳����
        if (whour < 0) {
            whour += 24;
        }
        return whour + ":" + minute + ":" + second;
    }
}