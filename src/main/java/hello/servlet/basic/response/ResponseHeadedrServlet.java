package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseHeadedrServlet", urlPatterns = "/response-header")
public class ResponseHeadedrServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //[status-line]
        res.setStatus(HttpServletResponse.SC_OK);

        //[response-headers]
        res.setHeader("Content-Type", "text/plain;charset=utf-8");
        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("my-header", "hello"); //커스텀 헤더 셋팅이 가능

        //[Header 편의 메서드]
        content(res);
        cookie(res);
        redirect(res);
    }

    private void content(HttpServletResponse res) {
        //Content-Type: text/plain;charset=utf08
        //Content-Length: 2
        //res.setHeader("Content-type", "text/plain;charset=utf-8");

        // 아래처럼 입력하면 위에처럼 res.setHeader를 안해도됨
        res.setContentType("text/plain");
        res.setCharacterEncoding("utf-8");
        //res.setContentLength(2); // 생략시 자동 생성
    }

    private void cookie(HttpServletResponse res) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //res.setHeader("Set-Cookie", "myCookie=good; Max-Age=600")

        // 아래처럼 입력하면 위에처럼 res.setHeader를 안해도됨
        Cookie cookie = new Cookie("myCookie", "good");
        res.addCookie(cookie);
    }

    private void redirect(HttpServletResponse res) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html

        //res.setStatus(HttpServletResponse.SC_FOUND); // 302
        //res.setHeader("Location" "/basic/hello-form.html");

        // 아래처럼 입력하면 위에처럼 res.setHeader를 안해도됨
        res.sendRedirect("/basic/hello-form.html");
    }
}
