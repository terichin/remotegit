package basicws.model;

import java.util.HashMap;
/*
 * ŒŸõƒL[”Ô†‚ğsession‚ÉŠi”[‚·‚éƒNƒ‰ƒX
 */
public class Page3Model implements Model {

    public int execute(String parameter, HashMap session) {
        //ˆø”parameter‚Å“n‚³‚ê‚½ŒŸõƒL[”Ô†‚ğ"key"‚Æ‚¢‚¤–¼‘O‚Åsession‚ÉŠi”[‚·‚é
        session.put("key", parameter);
        return 4;
    }
}