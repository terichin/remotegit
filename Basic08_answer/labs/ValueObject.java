class ValueObject {
	int extension = 0; // �����ԍ�
	String name = null; // ����
	// �R���X�g���N�^
	ValueObject(int extension, String name) {
		this.extension = extension;
		this.name = name;
	}
	// �l�̕\�����\�b�h
	void printInformation() {
		System.out.println("�����ԍ���" + extension + "�ł��B");
		System.out.println("������" + name + "�ł��B");
	}
}