package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import db.DBconnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Connection conn=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   response.setContentType("html/text");
		   response.setCharacterEncoding("UTF_8");
		   String v_name=null;
		   int i_grade=0;
		   int i_class=0;
		   String v_address=null;
		   String v_wechat=null;
		   String v_qq=null;
		   String v_phone_number=null;
		   int i_age=0;
		   v_name=request.getParameter("v_name");
		   i_grade= Integer.valueOf(request.getParameter("i_grade"));
		   i_class=Integer.valueOf(request.getParameter("i_class"));
		   v_address=request.getParameter("v_address");
		   v_wechat=request.getParameter("v_wechat");
		   v_qq=request.getParameter("v_qq");
		   v_phone_number=request.getParameter("v_phone_number");
		   i_age=Integer.valueOf(request.getParameter("i_age"));
		   
		   PrintWriter out=response.getWriter();
		   ResultSet result=null;
		   Statement stm=null;
		   String insertsql="insert into t_user(v_name,i_grade,i_class,v_address,v_wechat,v_qq,v_phone_number,i_age) values('"+v_name+"',"+i_grade+","+i_class+",'"+v_address+"','"+v_wechat+"','"+v_qq+"','"+v_phone_number+"',"+i_age+")";
		   int is=0;
		   try {
			conn=DBconnection.getConnector();
			stm=(Statement) conn.createStatement();
			is=stm.executeUpdate(insertsql);
			if(is!=0)
			{
				out.println("≤Â»Î≥…π¶");
			}
			   
			   
		} catch (Exception e) {
			// TODO: handle exception
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
