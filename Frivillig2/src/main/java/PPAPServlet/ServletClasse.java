package PPAPServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servilet")
public class ServletClasse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String escapeHtml(String s) {
		String resultat = s;
		resultat = resultat.replaceAll("<", "&lt;");
		resultat = resultat.replaceAll(">", "&gt;");
		resultat = resultat.replaceAll("\"", "&quot;");
		resultat = resultat.replaceAll(" ", "&nbsp;");
		return resultat;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String navn = request.getParameter("navn");
		navn = escapeHtml(navn);

		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();

		String hello = request.getHeader("accept-language").substring(0, 2).equals("en") ? "hello" : "hallo";

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Hallo</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + hello + "&nbsp;" + navn + "!</h1>");
		out.println("</body>");
		out.println("</html>");

	}

}
