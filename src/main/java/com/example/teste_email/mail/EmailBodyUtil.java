package com.example.teste_email.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


@Slf4j
@Component
public class EmailBodyUtil {

    private static ResourceLoader resourceLoader;

    @Inject
    @SuppressWarnings("static-access")
    public EmailBodyUtil(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public static String getBodyHtml(final BodyType bodyType) {

        try{
            InputStream file = resourceLoader.getResource("classpath:" + bodyType.getName() + ".html").getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(file);
            BufferedReader br = new BufferedReader(inputStreamReader);
            StringBuffer sb = new StringBuffer();

            String line;

            while((line = br.readLine()) != null){
                sb.append(line + "\n");
            }

            inputStreamReader.close();
            br.close();

            return sb.toString();
        }catch (IOException e){
         //   log.error("Email sending failed. (" +bodyType.getName() + ") " + e.getMessage() + " | " + e.getCause(), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}