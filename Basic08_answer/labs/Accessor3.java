class Accessor3 {
	// ������ێ����邽�߂̃����o�ϐ�
	private int hour;
	private int minute;
	private int second;
	// �R���X�g���N�^
	public Accessor3() {
		// �J�����_�[���玞�Ԃ��擾
		java.util.Calendar cal = java.util.Calendar.getInstance();
		hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
		minute = cal.get(java.util.Calendar.MINUTE);
		second = cal.get(java.util.Calendar.SECOND);
	}
	// �A�N�Z�b�T���\�b�h
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}

	public static void main(String[] args) {
		Accessor3 obj = new Accessor3();
		System.out.println("���݂̎�����" + obj.getHour() 
                + "��" + obj.getMinute()
                + "��" + obj.getSecond() + "�b�ł��B");
	}
}