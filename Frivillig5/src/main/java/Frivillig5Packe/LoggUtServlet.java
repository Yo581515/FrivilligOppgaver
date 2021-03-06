package Frivillig5Packe;

import static Frivillig5Packe.UrlMappings.LOGOUT_URL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/"+LOGOUT_URL)
public class LoggUtServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	/* 
	 * GET /logout er forespoorselen for ? logge ut.
	 * Burde kanskje vaert POST og PRG til kvitteing for utlogget ...
	 */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
        // Utlogging av bruker ...
    	LoggInnUtil.loggUt(request);
        response.setContentType("text/html; charset=ISO-8859-1");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Logget ut</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Du er naa logget ut!</p>");
        out.println("</body>");
        out.println("</html>");
    }
    

}
