interface ICTicket {
	// �J�[�h�c�z�𑝂₵�܂�
	void charge(int price);
	// �~�ԉw�ł̏��������{���܂�
	boolean pay(String endStation, int price);
	// ���p������\�����܂�
	void printHistory();
	// ��ԉw���L�^���܂�
	void saveStart(String startStation);
}