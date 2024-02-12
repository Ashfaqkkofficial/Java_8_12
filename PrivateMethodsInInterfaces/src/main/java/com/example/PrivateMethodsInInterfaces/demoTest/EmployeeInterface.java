package com.example.PrivateMethodsInInterfaces.demoTest;

public interface EmployeeInterface
{
    void test();

    default String loadTest()
    {
        System.out.println("In inteface loadTest() class");
        return "SUCESS";
    }
}
