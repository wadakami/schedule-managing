package controllers.users;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class UsersEditServlet
 */
public class UsersEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        User u = em.find(User.class, Integer.parseInt(request.getParameter("id")));

        List<String> allbooks = em.createNamedQuery("getBookName", String.class)
                .getResultList();

        em.close();

        request.setAttribute("user", u);
        request.setAttribute("_token", request.getSession().getId());
        request.getSession().setAttribute("user_id", u.getId());

        String[] books = null;

        try {
            if(!u.getBook().equals("")) {
                books = u.getBook().split(",");
            }

            for(int i = 0; i < books.length; i++) {
                allbooks.remove(allbooks.indexOf(books[i]));
            }

        } catch (NullPointerException e){

        }


/*
        List<String> set = new ArrayList<>();
        Collections.addAll(set, books);
        allbooks.removeAll(set);//booksの要素を消そうとするが消えず→Allbookの取得がStringじゃなかったため
*/

        request.setAttribute("allbooks", allbooks);
        request.setAttribute("books", books);


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/users/edit.jsp");
        rd.forward(request, response);
	}

}
