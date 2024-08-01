package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHtmlServlet", urlPatterns="/response-html")
public class ResponseHtmlServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //Content-type: text/html;charset=utf-8
        res.setContentType("text/html");
        res.setCharacterEncoding("utf-8");

        PrintWriter printWriter = res.getWriter();
        printWriter.println("<html>");
        printWriter.println("<body>");
        printWriter.println("<div>여기는 html입니다.</div>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}
