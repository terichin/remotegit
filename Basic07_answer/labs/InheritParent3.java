class InheritParent3 {
    int hour;
    int minute;
    int second;
    // �R���X�g���N�^
    InheritParent3() {
    	// �J�����_�[���玞�Ԃ��擾
    	java.util.Calendar cal = java.util.Calendar.getInstance();
    	hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
    	minute = cal.get(java.util.Calendar.MINUTE);
    	second = cal.get(java.util.Calendar.SECOND);
    }
    // ���{�W�������擾����
    String getTime() {
    	return hour + ":" + minute + ":" + second;
    }
}