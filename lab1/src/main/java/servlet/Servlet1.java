package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import juice.Juice;

import java.io.IOException;
import java.io.PrintWriter;

import crud.Lab2CrudInterface;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletConfigInterface servletConfig;
	Lab2CrudInterface lab2Crud;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet1() {
		super();
		this.servletConfig = new ServletConfig();
		this.lab2Crud = servletConfig.getCrud();
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.addHeader("Access-Control-Allow-Origin", "*");
			
		out.println("["+lab2Crud.readJuice()+"]");
	}
	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String descr = request.getParameter("descr");
		String img = request.getParameter("img");
		
		lab2Crud.updateJuice(new Juice(title, descr, img));
	}
	
	

}
