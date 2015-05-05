package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pretty.printer.PrettyPrinter;

/**
 * Servlet implementation class PrettyJson
 */
@WebServlet("/PrettyJson")
public class PrettyJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrettyJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonURL = request.getParameter("json");
		
		String pretty = null;
		if (null != jsonURL) {
		    PrettyPrinter pp = new PrettyPrinter(jsonURL);
		    pretty = pp.prettyPrint();
		}
		
		response.getWriter().println(pretty);
	}

}
