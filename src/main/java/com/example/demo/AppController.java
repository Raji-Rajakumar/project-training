package com.example.demo;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${spring.application.name}")
    String name;
    @Value("${spring.userName}")
    String userName;
    @Value("${spring.userEmail}")
    String userEmail;

    @GetMapping("/hello")
    public String showHelloWorld(){

        return "Hello world";
    }

    @GetMapping("/listOfTeamMembers")
    public List<String> showTeamMembersName(){
        List<String> nameList = new ArrayList<>();
        nameList.add("Vijay Ramanujam");
        nameList.add("B Jebin Sam");
        nameList.add("Gokulaprakaash Arumugham");
        nameList.add("Kalai Selvan");
        nameList.add("Kanagarathinam Ravi");
        nameList.add("Kowshikbharathi Mani");
        nameList.add("Maharaja Kadarkarai");
        nameList.add("Manisha Arunraj");
        nameList.add("Nataraj Manivannan");
        nameList.add("Parameswaran L");
        nameList.add("Raji Rajakumar");
        return nameList;
    }

    @GetMapping("/appDetail")
    public String showAppDetail(){
        String appDetail = "The name of the application is "+ name + "<br>" + "User name is " + userName + "<br>" +
                "User email is " + userEmail ;
        return appDetail;
    }

    @GetMapping("/add")
    public static String doAdd(@RequestParam String a, @RequestParam String b){
        int x =Integer.parseInt(a);
        int y =Integer.parseInt(b);
        int c = x+y;
        return "The addition of an number is " + c;
    }
}
