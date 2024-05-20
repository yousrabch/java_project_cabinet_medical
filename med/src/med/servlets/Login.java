package med.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import med.DAO.DoctorDAO;
import med.DAO.UserDAO;
import med.javaBeans.HomeData;
import med.javaBeans.User;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	HttpSession session = request.getSession();
    	
    	if(session.getAttribute("user")!=null) {
    		User user = (User) session.getAttribute("user");
    		String  accountType = user.getAccountType() ;
            if(accountType.equals("medecin")) {
        		DoctorDAO doctorDAO = new DoctorDAO();
        		HomeData homeData;
        		homeData = doctorDAO.getData();
        		request.setAttribute("homeData",homeData);
            	this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            }
            else if(accountType.equals("patient")) {
            	this.getServletContext().getRequestDispatcher("/WEB-INF/home_patient.jsp").forward(request, response);
            }
			else if(accountType.equals("secritaire")) {
				this.getServletContext().
			}
    	}
    	
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDAO userDAO = new UserDAO();
		User user = null ;
		
		try {
			user=userDAO.checkLogin(email, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(user != null) {
			HttpSession session = request.getSession();
            session.setAttribute("user", user);
            
            //Vérifiez si est un médecin ou patient et dirige chacun vers sa espace
            String  accountType = user.getAccountType() ;
            if(accountType.equals("doctor")) {
        		DoctorDAO doctorDAO = new DoctorDAO();
        		HomeData homeData;
        		homeData = doctorDAO.getData();
        		request.setAttribute("homeData",homeData);
            	this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            }
            else if(accountType.equals("patient")) {
            	this.getServletContext().getRequestDispatcher("/WEB-INF/home_patient.jsp").forward(request, response);
            }
            				
		}
		else {
			String message = "Email et/ou Mot de passe incorrect(s)";
            request.setAttribute("message", message);
            doGet(request, response);                
		}
	}
}