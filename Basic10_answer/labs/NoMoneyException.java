// 自作の例外クラス(Exceptionを継承して作成)
class NoMoneyException extends Exception {
	
    public void printErrorMessage(int requestItems[], int drinkItems[]) {
        int coffeeLeaveItems = requestItems[0] - drinkItems[0];
    	int teaLeaveItems = requestItems[1] - drinkItems[1];
    	int orangeLeaveItems = requestItems[2] - drinkItems[2];
    	StringBuffer msg = new StringBuffer();
    	if(coffeeLeaveItems != 0){
    		msg.append("コーヒーは、" + coffeeLeaveItems + "個、");
    	}
    	if(teaLeaveItems != 0){
    		msg.append("紅茶は、" + teaLeaveItems + "個、");
    	}
    	if(orangeLeaveItems != 0){
    		msg.append("オレンジジュースは、" + orangeLeaveItems + "個");
    	}
    	msg.append("買えませんでした。");
        System.out.println(msg);
    }
}