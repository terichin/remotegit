class FindUtility {
	// �����f�[�^�̒�`
	int[] extension = { 100, 200, 300 };
	String[] name = { "�R�c���Y", "��؈�Y", "�����Ԏq" };

	// �ԍ��ɂ�錟�����\�b�h
	ValueObject findByExtension(int extension) {
		for (int i = 0; i < this.extension.length; i++) {
			// ���������Ƃ�
			if (extension == this.extension[i]) {
				ValueObject obj = new ValueObject(this.extension[i], name[i]);
				return obj;
			}
		}
		return null; // ������Ȃ�����null��Ԃ�
	}

	// ���O�ɂ�錟�����\�b�h
	ValueObject findByName(String name) {
		for (int i = 0; i < this.name.length; i++) {
			// ���������Ƃ�
			if (this.name[i].indexOf(name) != -1) {
				ValueObject obj = new ValueObject(extension[i], this.name[i]);
				return obj;
			}
		}
		return null; // ������Ȃ�����null��Ԃ�
	}
}