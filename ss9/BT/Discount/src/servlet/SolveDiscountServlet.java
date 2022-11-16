package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SolveDiscountServlet", value = "/SolveDiscountServlet")
public class SolveDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("discount"));
        float price = Float.parseFloat(request.getParameter("price"));
        float discount = rate*price;
        float finalCost = price - discount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>"+
                " <h1>Discount  = "+discount+"</h1><br>" +
                "<h1> Final price = " + finalCost+"</h1> </html>");
    }
}
