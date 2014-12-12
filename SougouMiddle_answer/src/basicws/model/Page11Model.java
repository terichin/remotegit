package basicws.model;

import java.util.HashMap;
import basicws.entity.MemberBean;
import basicws.util.CsvDao;
/*
 * “o˜^‚·‚éĞˆõî•ñ‚ğæ“¾‚µA“o˜^ˆ—‚ÌÀs‚ğ§Œä‚·‚éƒNƒ‰ƒX
 */
public class Page11Model implements Model {

    public int execute(String parameter, HashMap session) {
        //ˆø”parameter‚Å“n‚³‚ê‚½“o˜^Šm”F”Ô†‚ª"1"‚Ìê‡‚Ì‚İ“o˜^‚·‚é
        if (parameter.equals("1")) {
            MemberBean bean = (MemberBean) session.get("insert");
            CsvDao.insert(bean);
        }
        return 2;
    }
}