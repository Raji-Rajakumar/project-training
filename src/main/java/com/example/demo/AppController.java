package com.example.demo;

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

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
}
