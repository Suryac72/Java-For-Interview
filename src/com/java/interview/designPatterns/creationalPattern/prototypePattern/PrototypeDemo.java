package com.java.interview.designPatterns.creationalPattern.prototypePattern;

import com.java.interview.designPatterns.creationalPattern.prototypePattern.implementation.DocumentRegistry;
import com.java.interview.designPatterns.creationalPattern.prototypePattern.implementation.EmployeeLetter;

public class PrototypeDemo {

    public static void main(String[] args) {

        EmployeeLetter empLetter1 = (EmployeeLetter) DocumentRegistry.getDocument("offer");
        empLetter1.setBody("Dear Surya, Welcome to the company!");

        EmployeeLetter empLetter2 = (EmployeeLetter) DocumentRegistry.getDocument("offer");
        empLetter2.setBody("Dear Prakash, Welcome aboard!");

        System.out.println("Employee 1 Letter: " + empLetter1);
        System.out.println("Employee 2 Letter: " + empLetter2);
    }
}
