// Assignment 1 - Sonal Pooja (N01474010)
import com.assignment1.ejb.MortgageCalculator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  @EJB
  MortgageCalculator mc = new MortgageCalculator();  // instance of session bean
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();  // to print 
    
    // getting parameters from jsp form
    double amount = Double.parseDouble(request.getParameter("amount")); 
    double rate = Double.parseDouble(request.getParameter("rate"));
    int years = Integer.parseInt(request.getParameter("years"));
    int months = Integer.parseInt(request.getParameter("months"));
    double term = years*12 + months;
    
    //setting values of amount, rate and term
	mc.setAmount(amount);
	mc.setRate(rate);
	mc.setTerm(term);
    
    out.println("<html>");
    
    out.println("<head>");
    out.println("<title>Assignment 1 - Sonal</title>");
    out.println("<style>\r\n"
    		+ "	form {\r\n"
    		+ "		position: relative;\r\n"
    		+ "		left: 400px;\r\n"
    		+ "		top: 50px;\r\n"
    		+ "		border: 1px solid grey;\r\n"
    		+ "		width: 450px;\r\n"
    		+ "		height: 350px;\r\n"
    		+ "		background-color:lightgrey;\r\n"
    		+ "     color: darkblue;\r\n"
    		+ "		padding: 5px;\r\n"
    		+ "	}\r\n"
    		+ "</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div>");
    out.println("<form>");
    out.println("<h3>Amount: $" + amount + "</h3>");
    out.println("<h3>Interest Rate: " + rate + "%</h3>");
    out.println("<h3>Interest Term: " + years + " years and " + months + " months</h3>");
    try
    {
      double result = mc.getMortgage();
      out.println("<h2>The monthly mortgage payment is:   $" + result + "</h2>");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    out.println("</form>");
    out.println("</div>");
    out.println("</body>");
    
    out.println("</html>");
  }
}