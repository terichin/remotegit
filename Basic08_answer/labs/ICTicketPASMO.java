class ICTicketPASMO implements ICTicket {
	// �`���[�W����Ă�����z
	int money = 0;
	// ��ԉw
	String startStation;
	// ���p����
	ICTicketInfo[] history = new ICTicketInfo[3];

	public void charge(int price) {
		// �w��̋��z���`���[�W����
		this.money += price;
	}

	public boolean pay(String endStation, int price) {
		if (price > money) {
			// �`���[�W�z���s������ꍇ�̓I�[�g�`���[�W����
			System.out.println("�I�[�g�`���[�W���܂�");
			this.money += 3000;
		}
		// �w��̋��z���`���[�W�z���猸�炷
		this.money -= price;
		// �g�p�����X�V
		for (int i = history.length - 1; i > 0; --i) {
			// ���݂̗�������1�����ɂ��炷
			history[i] = history[i - 1];
		}
		// �z��̐擪�ɍŐV�̗�������ۑ�����
		history[0] = new ICTicketInfo(startStation, endStation, price);
		return true;
	}

	public void printHistory() {
		// �c����\������
		System.out.println("�c�z��" + money + "�~�ł�");
		System.out.println("��ԉw\t�~�ԉw\t�^��");
		for (int i = 0; i < history.length; ++i) {
			// �z�񂩂痚������1���o���A�\������
			ICTicketInfo info = history[i];
			if (info == null) {
				break;
			}
			System.out.println(info.startStation + "\t" + info.endStation
					+ "\t" + info.price);
		}
	}

	public void saveStart(String startStation) {
		// ��ԉw���L�^����
		this.startStation = startStation;
	}
}