package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UserService;
import util.AppException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//  Get login information
		String id = request.getParameter("name");
		String password = request.getParameter("password");
		
		// 初始化姓名
		String name = null;
		// 初始化提示信息
		String message = "";

		try {
			UserService userService = new UserService();
			
			// Call business logic layer for user login
			name = userService.login(id, password);
			if (name != null) { // login successfully  
				//  Declare session
				HttpSession session = null;
				// Get session by using request
				session = request.getSession();
				// Save userId and user name into session
				session.setAttribute("userId", id);
				session.setAttribute("userName", name);
				// Declare role
				Role role = null;
				//Call business logic layer to get role's information
				role = userService.getUserRole(id);
				
				// Process page jump according to the user's role
				if ( role == null) {
					//Redirect to new user page
					message = "您当前未拥有权限";
					request.setAttribute("message", message); // Save prompt message into request
					request.getRequestDispatcher("/result.jsp").forward(request,
							response);
				} else{
					//Redirect to administrator page
					PermissionDetailModel pdm = userService.getPermissionDetail(userId);
					session.setAttribute("pdm", pdm);
					response.sendRedirect("toAdmin");
				}
			} else {// Login failed
				// Set prompt message
				message = "错误的用户或者密码！";
				request.setAttribute("message", message); // Save prompt message into request
				// Save user name into request
				request.setAttribute("userName", name);	
				// Forward to login page
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
			}
		} catch (AppException e) {
			e.printStackTrace();
			// Redirect to exception page
			response.sendRedirect("toError");
		}		
	}

}
