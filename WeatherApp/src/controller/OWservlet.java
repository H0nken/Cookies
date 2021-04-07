package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cookies.ApiCookie;
import model.GetTheWeather;
import model.weatherBean;

/**
 * Servlet implementation class OWservlet
 */
@WebServlet("/OWservlet")
public class OWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OWservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");
		
		
		weatherBean wBean = new weatherBean(cityStr, countryStr);
		
		GetTheWeather.getWeather(wBean);
		
		String cookieResult = ApiCookie.getApiCookie(wBean.getCityStr(), wBean.getcloudsStr(), wBean.getspeedStr());		
		
		System.out.print(cookieResult);
		
		Cookie cookie = new Cookie(cityStr, cookieResult);
	
	
		cookie.setMaxAge(1000);
		
		
		response.addCookie(cookie);
		
		request.setAttribute("wBean", wBean);
		
		RequestDispatcher rd= request.getRequestDispatcher("showWeather.jsp");
		rd.forward(request, response);
		
		
		
		
		
		
		
		
		
		
	}

}
