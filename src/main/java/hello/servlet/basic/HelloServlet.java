package hello.servlet.basic;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Parameter;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json");
        response.getWriter().write("hello " + username);
    }
}
