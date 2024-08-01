package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();
    // IOException : 클라이언트-서버 통신간 발생 가능한 여러 문제가 발생 시 예외 시켜주기 위함
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        ServletInputStream inputStream = req.getInputStream();
        String messagebody = StreamUtils.copyToString(inputStream , StandardCharsets.UTF_8);

        System.out.println("messagebody = " + messagebody);

        HelloData helloData = objectMapper.readValue(messagebody, HelloData.class);

        System.out.println("username = " + helloData.getUsername());
        System.out.println("age = " + helloData.getAge());

        res.getWriter().write("OK");
    }
}
