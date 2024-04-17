package com.devmuromi.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        // 그냥 스트링을 리턴하면 뷰 이름이라 생각한다. @ResponseBody를 붙여서 스트링을 리턴하면 뷰 이름이 아니라 리턴값이 된다.
        return "Hello, World!";
    }

    @RequestMapping("/hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>Hello</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1>Hello, World!</h1>");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }
}
