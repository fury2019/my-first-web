package com.Hotel.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/Cuscheck.do")
public class Cuscheck extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      String resp = request.getReader().readLine();
      JsonParser parser = new JsonParser();
      JsonObject jsonObj = (JsonObject)parser.parse(resp);
      String impUid = jsonObj.get("imp_uid").getAsString();
      System.out.println(">>>>>>>>>>" + impUid);
      
      //인증토큰 받기
      String imp_key = "7847636624887352";
      String imp_secret = "yinTYMUdaCDq4jMix9RMsjVx0LuDvNOQmrrjX2miRFZ46YCMRpGKfWWb8CY761BVPD8VEerP7AqY9L6x";
      
      //java.net.http
      HttpRequest req = HttpRequest.newBuilder()
          .uri(URI.create("https://api.iamport.kr/users/getToken"))
          .header("Content-Type", "application/json")
          .method("POST", HttpRequest.BodyPublishers.ofString("{\"imp_key\":\""+imp_key+"\",\"imp_secret\":\""+imp_secret+"\"}"))
          .build();
      
      HttpResponse<String> res = null;
      try {
         res = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString());
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      String body = res.body();
      JsonObject jsonObject = (JsonObject)parser.parse(body);
      JsonObject resJson = jsonObject.get("response").getAsJsonObject();
      String token = resJson.get("access_token").getAsString();
      System.out.println(token);
      
      //인증정보 얻기
      HttpRequest req1 = HttpRequest.newBuilder()
             .uri(URI.create("https://api.iamport.kr/certifications/"+impUid))
             .header("Authorization", token)
             .method("GET", HttpRequest.BodyPublishers.ofString("{\"Authorization\":\""+token+"\"}"))
             .build();
      
      HttpResponse<String> res1 = null;
      try {
         res1 = HttpClient.newHttpClient().send(req1, HttpResponse.BodyHandlers.ofString());
      } catch (IOException e) {
         e.printStackTrace();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println(">>>>" + res1.body());
      String body1 = res1.body();
      JsonObject jsonObject1 = (JsonObject)parser.parse(body1);
      JsonObject resJson1 = jsonObject1.get("response").getAsJsonObject();
      String name = resJson1.get("name").getAsString();
      String birth = resJson1.get("birthday").getAsString();
      String phone = resJson1.get("phone").getAsString();
      String gender = resJson1.get("gender").getAsString();
      String info = "{\"name\":\""+name+"\", \"birth\":\""+birth+"\", \"phone\":\""+phone+"\",\"gender\":\"" + gender + "\"}";
      
      response.getWriter().print(info);
      
   }

}
