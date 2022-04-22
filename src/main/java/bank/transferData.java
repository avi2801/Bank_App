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
 * Servlet implementation class transferData
 */
public class transferData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transferData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String saccno = request.getParameter("accno");
		String raccno = request.getParameter("raccno");
		String amount = request.getParameter("amount");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Pass@123");
			//Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Pass@123");
			PreparedStatement prestm = con.prepareStatement("update bankacc set amount = amount-(?) where accno =?");
			prestm.setString(1, amount);
			prestm.setString(2, saccno);
			prestm.executeUpdate();
			PreparedStatement prestm1 = con.prepareStatement("update bankacc set amount = amount+(?) where accno =?");
			prestm1.setString(1, amount);
			prestm1.setString(2, raccno);
			
			prestm1.executeUpdate();
			con.close();
			System.out.println("Transfer done");
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
