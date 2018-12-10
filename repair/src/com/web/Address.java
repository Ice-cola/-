package com.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.bean.Pumproomregion;
import com.dao.Dao;

/**
 * Servlet implementation class Adress
 */
@WebServlet("/getAddress.action")
public class Address extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Address() {
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
		Dao dao = new Dao();
		try {
			List<Pumproomregion> list = dao.getAddress();
			if(list!=null){
				byte[] bs = JSONArray.toJSONString(list).getBytes();
				rp.setContentType("application/json;charset=GBK");
				rp.setContentLength(bs.length);
				rp.getOutputStream().write(bs, 0, bs.length);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
