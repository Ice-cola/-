package com.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;

/**
 * Servlet implementation class repair
 */
@WebServlet("/repair.action")
public class repair extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public repair() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		rq.setCharacterEncoding("UTF-8");
		String name = rq.getParameter("name");
		String phone = rq.getParameter("phone");
		int address1 = Integer.parseInt(rq.getParameter("address1"));
		int address2 = Integer.parseInt(rq.getParameter("address2"));
		String content = rq.getParameter("content");
		if("ÆäËû".equals(content)){
			content = rq.getParameter("content2");
		}
		String img = rq.getParameter("img");
		Dao dao = new Dao();
		try {
			dao.insert(name, phone, address1,address2, content, img);
			rp.sendRedirect("success.html");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
