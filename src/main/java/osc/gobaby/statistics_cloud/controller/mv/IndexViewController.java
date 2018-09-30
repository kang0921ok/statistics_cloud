package osc.gobaby.statistics_cloud.controller.mv;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import osc.gobaby.statistics_cloud.admin.db.DbConnectUtils;
import osc.gobaby.statistics_cloud.interceptor.DbConnectionInterceptor;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ShinHyun.Kang on 2018. 9. 9..
 */
@Controller
public class IndexViewController {
    private static final Logger LOG = Logger.getLogger(DbConnectionInterceptor.class);

    @RequestMapping(value = {"/", "/gate"}, method = RequestMethod.GET)
    public String indexView(HttpServletResponse response) {
        if (DbConnectUtils.isCreatedDbConnectMetaFile()) {
            try {
                response.sendRedirect("/user/login");
            } catch (Exception e) {
                LOG.error(e);
            }
        }

        return "gate";
    }
}
