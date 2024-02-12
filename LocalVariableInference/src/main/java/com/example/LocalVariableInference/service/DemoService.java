package com.example.LocalVariableInference.service;

import java.util.ArrayList;
import java.util.HashMap;

public class DemoService
{
    public void basicVarDeclaration() {
        var x = 10;
        System.out.println("x: " + x); // Output: x: 10
    }

    public void multipleVarDeclaration() {
        var a = 5;
        var b = 10;
        var c = 15;
        System.out.println("a: " + a + ", b: " + b + ", c: " + c); // Output: a: 5, b: 10, c: 15
    }

    public void varWithCollection() {
        var list = new ArrayList<String>();
        list.add("Java");
        list.add("Python");
        list.add("JavaScript");
        System.out.println("List: " + list); // Output: List: [Java, Python, JavaScript]

        var map = new HashMap<Integer, String>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        System.out.println("Map: " + map); // Output: Map: {1=One, 2=Two, 3=Three}
    }

    public void varWithLambdaExpression() {
        var runnable = (Runnable) () -> System.out.println("Hello, Java!");
        runnable.run(); // Output: Hello, Java!
    }

    public void varInLoop() {
        for (var i = 0; i < 5; i++) {
            System.out.println(i); // Output: 0, 1, 2, 3, 4
        }
    }

    public void varWithLocalVariableTypeInference() {
        var message = "Hello, Java!";
        System.out.println(message); // Output: Hello, Java!
    }

    public static void main(String[] args) {
        var demo = new DemoService();
        demo.basicVarDeclaration();
        demo.multipleVarDeclaration();
        demo.varWithCollection();
        demo.varWithLambdaExpression();
        demo.varInLoop();
        demo.varWithLocalVariableTypeInference();
    }
}
