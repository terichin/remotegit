class ICTicketInfo {
	// ��ԉw
	String startStation;
	// �~�ԉw
	String endStation;
	// �^��
	int price;

	ICTicketInfo(String startStation, String endStation, int price) {
		// ��ԉw�E�~�ԉw�E�^�����������o�ϐ��ɕۑ�
		this.startStation = startStation;
		this.endStation = endStation;
		this.price = price;
	}
}