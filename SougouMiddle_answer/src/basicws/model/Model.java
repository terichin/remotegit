package basicws.model;

import java.util.HashMap;
/*
 * 各Modelクラスのインターフェース
 * 各Modelクラスはこのインターフェースを実装して作成する
 */
public interface Model {
    int execute(String parameter, HashMap session);
}