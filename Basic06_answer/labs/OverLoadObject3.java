class OverLoadObject3 {
    // ������ۑ�����ׂ̃����o�ϐ�
    int hour;
    int minute;
    int second;
    // �R���X�g���N�^
    OverLoadObject3() {
    	// �J�����_�[���玞�Ԃ��擾
    	java.util.Calendar cal = java.util.Calendar.getInstance();
    	hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
    	minute = cal.get(java.util.Calendar.MINUTE);
    	second = cal.get(java.util.Calendar.SECOND);
    }
    // ���{�W������\�����郁�\�b�h
    void printTime() {
	System.out.println("������" + hour + ":" + 
			   minute + ":" + second + "�ł��B");
    }
    // �����̎�����\�����郁�\�b�h
    void printTime(int time) {
    	// �␳�l�̃`�F�b�N
    	if ((time < -11) || (time > 11)) {
    		System.out.println("�������\���o���܂���B");
    		return;
    	}
    	// �����̕␳
    	int newhour = hour + time;
    	if (newhour < 0) {
    		newhour += 24;
    	} else if (newhour >= 24) {
    		newhour -= 24;
    	}
    	// �����̕\��
    	System.out.println("������" + newhour + ":" + 
    			minute + ":" + second + "�ł��B");
    }
}