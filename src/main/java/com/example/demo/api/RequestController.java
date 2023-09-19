package com.example.demo.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

  @GetMapping("/")
  public String index() throws IOException {

    //request
    //TODO: remove hardcoding of url, get it from env variable
    URL url = new URL("http://localhost:8080/");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    //reading the response
    int status = con.getResponseCode();
    BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      content.append(inputLine);
    }
    in.close();

    //close the connection
    con.disconnect();

    return "In app2 reading the request from app1: "+ content.toString();

  }


}
