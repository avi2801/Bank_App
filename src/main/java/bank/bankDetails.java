package bank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bankDetails
 */
public class bankDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public bankDetails() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String accno = request.getParameter("accountno");
		String phno = request.getParameter("phoneno");
		String ifsc = "SBIN0012345";
		String amount = "100000";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Pass@123");
			PreparedStatement prestm = con.prepareStatement("insert into bankacc values(?,?,?,?,?)");
			prestm.setString(1,name);
			prestm.setString(2, accno);
			prestm.setString(3, ifsc);
			
			prestm.setString(4, amount);
			
			prestm.setString(5, phno);
			prestm.execute();
			System.out.println("Data inserted");
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
