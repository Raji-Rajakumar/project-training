/*
 * AppController
 *
 * date 21-02-2022
 *
 * Copyrights Ideas2IT
 */

package com.example.demo;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Receives the request and responses based on the request.
 *
 * @author  Raji Rajakumar
 * @version 1.0
 */
@RestController
public class AppController {

    @Value("${spring.application.name}")
    String name;
    @Value("${spring.userName}")
    String userName;
    @Value("${spring.userEmail}")
    String userEmail;

    /**
     * Shows "hello world", when request for /hello endpoint.
     *
     * @return hello world the string.
     */
    @GetMapping("/hello")
    public String showHelloWorld() {

        return "Hello world";
    }

    /**
     * Shows list of team members name, when request for /listOfTeamMembers endpoint.
     *
     * @return list of team members name the list.
     */
    @GetMapping("/listOfTeamMembers")
    public List<String> showTeamMembersName() {
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

    /**
     * Shows app detail, when request for /appDetail endpoint.
     *
     * @return detail of app the string.
     */
    @GetMapping("/appDetail")
    public String showAppDetail() {
        String appDetail = "The name of the application is "+ name + "<br>" + "User name is " + userName + "<br>" +
                "User email is " + userEmail ;
        return appDetail;
    }

    /**
     * Shows addition of two numbers, when request for /add endpoint.
     *
     * @param a the number
     * @param b the number
     * @return addition of two numbers the string.
     */
    @GetMapping("/add")
    public static String doAdd(@RequestParam String a, @RequestParam String b) {
        int x =Integer.parseInt(a);
        int y =Integer.parseInt(b);
        int c = x+y;
        return "The addition of an number is " + c;
    }

    /**
     * Implements method overloading with no parameter.
     *
     * @return the string.
     */
    @GetMapping("/name")
    public String displayName() {
        return "No name is passed";
    }

    /**
     * Implements method overloading with single parameter.
     *
     * @param name the string.
     * @return the string.
     */
    @GetMapping("/singleName")
    public String displayName(@RequestParam String name) {
        return "The passed name is: "+name;
    }

    /**
     * Implements method overloading with two parameter.
     *
     * @param name1 the string.
     * @param name2 the string.
     * @return the string.
     */
    @GetMapping("/doubleName")
    public String displayName(@RequestParam String name1, @RequestParam String name2) {
        return "The passed names are: "+name1 + " and "+name2;
    }

    /**
     * Implements switch case concept.
     *
     * @param day the option.
     * @return the string.
     */
    @GetMapping("/day")
    public String displayDay(@RequestParam String day) {
        String today = null;

        switch(day) {
            case "sunday":
                today = "sunday";
                break;
            case "monday":
                today = "monday";
                break;
            case "tuesday":
                today = "tuesday";
                break;
            case "wednesday":
                today = "wednesday";
                break;
            case "thursday":
                today = "thursday";
                break;
            case "friday":
                today = "friday";
                break;
            case "saturday":
                today = "saturday";
                break;
            default:
                today = "none";
        }
            return "The passed day is "+today;
    }

    /**
     * Implements recursion concept.
     *
     * @param input the string.
     * @return the string.
     */
    @GetMapping("/reverse")
    public String displayReverseOfString(@RequestParam String input) {
        String reverseOfString = null;

        if ((input == null)||(input.length() <= 1)) {
            reverseOfString = input;
        } else {
            reverseOfString = displayReverseOfString(input.substring(1)) + input.charAt(0);
        }

        return reverseOfString;
    }

    /**
     * Implements regex concept.
     *
     * @param number the string.
     * @return the string.
     */
    @GetMapping("/isValidNumber")
    public String validateNumber(@RequestParam String number) {
        boolean isValidNumber = number.matches("[0-9]+$");
        String output;
        if(isValidNumber) {
            output = "It is an valid number";
        } else {
            output = "It is not an valid number";
        }
        return output;
    }


}
