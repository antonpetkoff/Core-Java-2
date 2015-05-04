package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.sun.syndication.io.FeedException;

import news.parser.NewsParser;

/**
 * Servlet implementation class NewsFeed
 */
@WebServlet("/NewsFeed")
public class NewsFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsFeed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsParser np = new NewsParser();
	    response.setContentType(MediaType.TEXT_HTML);
	    response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
	    PrintWriter out = response.getWriter();
	    try {
            out.println(np.getNews());
        } catch (FeedException e) {
            e.printStackTrace();
        }
	}

}
