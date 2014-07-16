// 自動販売機とユーザクラスのインスタンスを生成し、
// ジュースを購入するプログラム
class JuiceApp {
    public static void main(String[] args) {

        // ユーザに持たせる所持金を指定する
        int argMoney = 0;

        // ３種類のジュースでユーザから要求されているジュースの個数を指定する
        int requestItems[] = new int[3];
        // ３種類のジュースで購入したジュースの個数を指定する
        int drinkItems[] = new int[3];

        // 引数チェックをする。
        if (args.length != 4) {
            System.out.println("指定する引数は4つです。"
                    + "ユーザの所持金ならびに3種類のジュースの個数を"
                    + "それぞれ指定してください。");
            return;
        }
        // 引数を受け取る。
        try {
            argMoney = Integer.parseInt(args[0]);
            requestItems[0] = Integer.parseInt(args[1]);
            requestItems[1] = Integer.parseInt(args[2]);
            requestItems[2] = Integer.parseInt(args[3]);
        } catch (Exception e) {
            // 正しい値が入力がされていない場合はメッセージを表示
            System.out.println("ユーザの所持金ならびに"
                    + "3種類のジュースの個数をそれぞれ指定してください。");
            // プログラムを終了
            return;
        }

        // 自動販売機のインスタンスを生成
        VendingMachine vm = new VendingMachine();
        // ユーザのインスタンスを生成
        JuiceUser user = new JuiceUser(argMoney);
        // ユーザがお金を支払う
        int money = user.pay();
        // 支払ったお金を自動販売機に投入する
        vm.insertCoin(money);

        try {
            for (drinkItems[0] = 0; drinkItems[0] < requestItems[0];
                    drinkItems[0] = drinkItems[0] + 1) {
                // コーヒーを購入する
                IJuice juice = vm.pushJuiceButton(IJuice.JUICE_COFFEE);
                // 購入したコーヒーを飲む
                user.receiveJuice(juice);
            }

            for (drinkItems[1] = 0; drinkItems[1] < requestItems[1];
                    drinkItems[1] = drinkItems[1] + 1) {
                // 紅茶を購入する
                IJuice juice = vm.pushJuiceButton(IJuice.JUICE_TEA);
                // 購入した紅茶を飲む
                user.receiveJuice(juice);
            }

            for (drinkItems[2] = 0; drinkItems[2] < requestItems[2];
                    drinkItems[2] = drinkItems[2] + 1) {
                // オレンジジュースを購入する
                IJuice juice = vm.pushJuiceButton(IJuice.JUICE_ORANGE);
                // 購入したオレンジジュースを飲む
                user.receiveJuice(juice);
            }
            // 合計金額が不足する場合は、
            // ユーザ定義例外NoMoneyExceptionがスローされる
        } catch (NoMoneyException e) {
            e.printErrorMessage(requestItems, drinkItems);
        }
        // 自動販売機からおつりを受け取る
        int change = vm.returnChange();
        // 出てきたおつりをユーザに設定
        user.receiveMoney(change);
    }
}