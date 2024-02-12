package com.example.PrivateMethodsInInterfaces.demoTest;

public class EmployeeTest implements EmployeeInterface
{

    @Override
    public void test() {
        System.out.println("In test method of EmployeeTest");
    }

    @Override
    public String loadTest()
    {
        System.out.println("In loadTest() method of EmployeeTest");
        return  "FAILED";
    }
}
