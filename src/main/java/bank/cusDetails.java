package bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cusDetails
 */
public class cusDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cusDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String name = request.getParameter("name");
		String accno = request.getParameter("accountno");
		//String phno = request.getParameter("phoneno");
		//String ifsc = "SBIN0012345";
		//String amount = "100000";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Pass@123");
			PreparedStatement prestm = con.prepareStatement("select * from bankacc where accno= (?)");
			prestm.setString(1, accno);
			//java.sql.Statement st =  con.createStatement();
			ResultSet rs = prestm.executeQuery();
			
	
			PrintWriter out = response.getWriter();
			while(rs.next())
			{
				out.println(rs.getInt(2)+" : "+rs.getString(1));
			}
			//prestm.setString(2,id);
			
			
			
			//prestm.execute();
			System.out.println("Data Deleted");
			
			
			
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
