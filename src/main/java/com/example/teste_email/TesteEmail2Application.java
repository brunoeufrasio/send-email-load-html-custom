package com.example.teste_email;

import com.example.teste_email.mail.JavaMailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootApplication
public class TesteEmail2Application {

    public static void main(String[] args) {
        SpringApplication.run(TesteEmail2Application.class, args);

        JavaMailService javaMailService = new JavaMailService();
        List<String> emails = new ArrayList<>();
        emails.add("bruno10tere@gmail.com");
        javaMailService.sendEmail(com.example.teste_email.mail.BodyType.RESET_PASSWORD,
                emails,
                "teste envio e-mail",
                Map.of("XXLINKXX", "D:\\workspace\\teste_email\\src\\main\\resources\\reset-password.html", /*FRONT_LINK + URI + task.getId()*/
                        "XXTYPEXX",
                        "INVOLVED",
                        "XXTASKNAMEXX",
                        "task.getName()"));
    }

}
