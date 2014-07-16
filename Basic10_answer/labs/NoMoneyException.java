// ����̗�O�N���X(Exception���p�����č쐬)
class NoMoneyException extends Exception {
	
    public void printErrorMessage(int requestItems[], int drinkItems[]) {
        int coffeeLeaveItems = requestItems[0] - drinkItems[0];
    	int teaLeaveItems = requestItems[1] - drinkItems[1];
    	int orangeLeaveItems = requestItems[2] - drinkItems[2];
    	StringBuffer msg = new StringBuffer();
    	if(coffeeLeaveItems != 0){
    		msg.append("�R�[�q�[�́A" + coffeeLeaveItems + "�A");
    	}
    	if(teaLeaveItems != 0){
    		msg.append("�g���́A" + teaLeaveItems + "�A");
    	}
    	if(orangeLeaveItems != 0){
    		msg.append("�I�����W�W���[�X�́A" + orangeLeaveItems + "��");
    	}
    	msg.append("�����܂���ł����B");
        System.out.println(msg);
    }
}