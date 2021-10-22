package stemmePacke;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setemmeResulatat")
public class setemmeResulatat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static int epler = 0;
	private static int appelsiner = 0;
	private static int bananer = 0;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>FavorittfruktResultat</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + "Favorittfrukt Resultat" +   "</h1><br><br>");
		out.println("Eple: " + epler+"<br>");
		out.println("Appelsin: " + appelsiner+"<br>");
		out.println("Banan: " + bananer+"<br>");
		out.println(
				"<a href=\"http://localhost:8080/Frivillig3/stemmeskjema.html\" style=\"color:blue;\" "
				+ "style=\"text-decoration: underline;\">Stemm en gang til</a>");
		
		out.println("</body>");
		out.println("</html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String valg = request.getParameter("valg");
		System.out.println("du har stemt på " + valg);
		oppdater(valg);
		request.getSession().setAttribute("valg", valg);
		response.sendRedirect("setemmeResulatat");
	}
	
	public static synchronized void oppdater(String valg) {
		if (valg.equals("elpe")) {
			epler++;
		}
		else if(valg.equals("appelsin")) {
			appelsiner++;
		}
		else if(valg.equals("banan")) {
			bananer++;
		}
	}

}
