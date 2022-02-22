package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import juice.Juice;
import juice.Mock;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import crud.Lab2CrudInterface;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1/*")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Juice> lj = new Mock().getJuiceList();
	
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
		setAccessControlHeaders(response);
		response.setContentType("application/json");
		lab2Crud.updateJuice(lj);
		lj = lab2Crud.readJuice();
		PrintWriter out = response.getWriter();
		out.println(lj);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		Juice juice = Helpers.juiceParse(request);
		juice.setId(Helpers.getNextId(lj));
		lj.add(juice);
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		Juice juice = Helpers.juiceParse(request);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		response.setContentType("application/json");
		int index = Helpers.getIndexByJuiceId(id, lj);
		lj.set(index, juice);
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doDelete(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		response.setContentType("application/json");
		int index = Helpers.getIndexByJuiceId(id, lj);
		lj.remove(index);
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doOptions(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setStatus(HttpServletResponse.SC_OK);
	}
	
	private void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "*");
		resp.setHeader("Access-Control-Allow-Headers", "*");
	}
	
	

}
