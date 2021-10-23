package Frivillig5Packe;

import static Frivillig5Packe.UrlMappings.LOGOUT_URL;
import static Frivillig5Packe.UrlMappings.LOGIN_URL;
import static Frivillig5Packe.UrlMappings.HEMELIGSIDE_URL;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/"+HEMELIGSIDE_URL)
public class HemmeligSide extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Inn noe kode her i forbindelse med autentisering, autorisasjon
		// og feilhoondtering?
		if (!LoggInnUtil.erInnlogget(request)) {
			response.sendRedirect(LOGIN_URL);

		} else {

			// Inn noe kode her i forbindelse med uthenting av sesjonsdata?
			HttpSession sesjon = request.getSession(true);
			String brukernavn = (String) sesjon.getAttribute("username");

			response.setContentType("text/html; charset=ISO-8859-1");

			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<title>Web Shop</title>");
			out.println("</head>");
			out.println("<body>");

			// Inn noe kode her for "Du er innlogget som <bruker>"?
			out.println("Du er innloget inn som: " + brukernavn + "<br />");

			out.println("<form action=\"" + LOGOUT_URL + "\" method=\"get\">");
			out.println("<fieldset>");
			out.println("<p><input type=\"submit\" value=\"Logg ut\" /></p>");
			out.println("</fieldset>");
			out.println("</form>");

			out.println("</body>");
			out.println("</html>");

		}
	}
}
