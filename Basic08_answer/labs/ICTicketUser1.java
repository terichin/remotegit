class ICTicketUser1 {
	public static void main(String[] args) {
		// Suica�I�u�W�F�N�g���쐬���A500�~���`���[�W
		ICTicket ic = new ICTicketSuica();
		ic.charge(500);

		// �V�h�`�H�t���Ԃ����
		ic.saveStart("�V�h");
		pay(ic, "�H�t��", 160);

		// �H�t���`�V�h�Ԃ����
		ic.saveStart("�H�t��");
		pay(ic, "�V�h", 160);

		// �V�h�`�r�܊Ԃ����
		ic.saveStart("�V�h");
		pay(ic, "�r��", 150);

		// �r�܁`���Ԃ����
		ic.saveStart("�r��");
		pay(ic, "���", 160);

		// ����\��
		ic.printHistory();
	}

	static void pay(ICTicket ic, String endStation, int price) {
		// �c�z�s�����m�F���A�s�����̓G���[���b�Z�[�W���o�͂���
		if (ic.pay(endStation, price) == false) {
			System.out.println("�c�z�s���ł��B�`���[�W���Ă��������B");
		}
	}
}