package basicws.model;

import java.util.HashMap;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
/*
 * •ÏX‚·‚éĞˆõî•ñ‚ğæ“¾‚µA•ÏX‘®«”Ô†‚ğsession‚ÉŠi”[‚·‚éƒNƒ‰ƒX
 */
public class Page6Model implements Model {

    public int execute(String parameter, HashMap session) {
        //"search"‚Æ‚¢‚¤–¼‘O‚ÅŠi”[‚³‚ê‚½Ğˆõî•ñ1Œ‚ğsession‚©‚çæ“¾‚·‚é
        MemberBean bean = (MemberBean) session.get("search");

        if (bean == null) {
            return 4;
        } else {
            //ˆø”parameter‚Å“n‚³‚ê‚½•ÏX‘®«”Ô†‚ğ"key"‚Æ‚¢‚¤–¼‘O‚Å
            //session‚ÉŠi”[‚·‚é
            session.put("key", parameter);
            return 8;
        }
    }
}