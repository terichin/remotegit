class OverrideChild3 extends InheritChild3{
	// ���E�W�������擾���郁�\�b�h
    String getWorldTime() {
    	return "���E�W������" + super.getWorldTime() + "�ł��B";
    }
    // ���{�W�������I�[�o�[���C�h�������\�b�h
    String getTime() {
    	return "���{�W������" + super.getTime() + "�ł��B";
    }
}