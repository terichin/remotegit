package basicws;

import java.util.HashMap;

import org.apache.log4j.Logger;

import basicws.model.Model;
import basicws.model.Page10Model;
import basicws.model.Page11Model;
import basicws.model.Page1Model;
import basicws.model.Page2Model;
import basicws.model.Page3Model;
import basicws.model.Page4Model;
import basicws.model.Page5Model;
import basicws.model.Page6Model;
import basicws.model.Page7Model;
import basicws.model.Page8Model;
import basicws.model.Page9Model;
import basicws.view.Page10View;
import basicws.view.Page11View;
import basicws.view.Page1View;
import basicws.view.Page2View;
import basicws.view.Page3View;
import basicws.view.Page4View;
import basicws.view.Page5View;
import basicws.view.Page6View;
import basicws.view.Page7View;
import basicws.view.Page8View;
import basicws.view.Page9View;
import basicws.view.View;


public class MemberController {

    private static int status = 1;
    private static HashMap session = new HashMap();

    private final static Logger logger = Logger.getLogger(MemberController.class);


    public static void main(String[] args) {
        while (true) {
            if (status < 1 || status > 11) {
                System.out.println("想定していないステータスです。");
                logger.error("想定していないステータスです。"+status);
                System.exit(0);
                break;
            }
            View view = createView(status);
            Model model = createModel(status);

            String input = null;
            input = view.render(session);
            status = model.execute(input, session);

        }
    }

    private static View createView(int status) {

        View[] views = {
            new Page1View(), new Page2View(), new Page3View(), new Page4View(),
            new Page5View(), new Page6View(), new Page7View(), new Page8View(),
            new Page9View(), new Page10View(), new Page11View()
        };
        return views[status - 1];
    }

    private static Model createModel(int status) {
        Model[] models = {
            new Page1Model(), new Page2Model(), new Page3Model(), new Page4Model(),
            new Page5Model(), new Page6Model(), new Page7Model(), new Page8Model(),
            new Page9Model(), new Page10Model(), new Page11Model()
        };
        return models[status - 1];
    }
}