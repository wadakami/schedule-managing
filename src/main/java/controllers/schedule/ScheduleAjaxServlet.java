package controllers.schedule;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.MessageBean;
import models.User;
import models.validators.AjaxValidation;
import net.arnx.jsonic.JSON;
import utils.DBUtil;

/**
 * Servlet implementation class ScheduleAjaxServlet
 */
public class ScheduleAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String parameter1 = request.getParameter("requestJs");//{"message":" "}を受け取る
        System.out.println(parameter1);

        MessageBean bean = JSON.decode(parameter1, MessageBean.class);//JSONをStringに変換
        //サーブレットに送信されたメッセージが表示される。
        System.out.println(bean.getMessage());
        System.out.println(bean.getClassTime());
        System.out.println(bean.getDate());
        System.out.println(bean.getMain_user());
        System.out.println(bean.getMain());

        String ajax_message = bean.getMessage();
        int ajax_classTime = bean.getClassTime();
        Date ajax_date = bean.getDate();
        String ajax_Muser = bean.getMain_user();
        String ajax_main = bean.getMain();

        EntityManager em = DBUtil.createEntityManager();

        User u;

        u = em.createNamedQuery("getUser", User.class)
                .setParameter("name", ajax_message)
                .getSingleResult();
        em.close();

        String[] books = u.getBook().split(",");


                //JSONマップ
        Map<String, String[]> mapMsg = new HashMap<String, String[]>();

        //追加
        mapMsg.put("bookName", books);

        if(bean.getMain().equals("teacher")) {

                String[] errors = AjaxValidation.valifySchedule(u, ajax_classTime, ajax_date, ajax_Muser, ajax_main);

                mapMsg.put("errors", errors);

        }

        //マッパ(JSON <-> Map, List)
        ObjectMapper mapper = new ObjectMapper();

        //json文字列
        String jsonStr = mapper.writeValueAsString(mapMsg);  //list, map
        System.out.println(jsonStr);

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
	}

}
