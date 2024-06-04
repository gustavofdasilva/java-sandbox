package com.gustavofdasilva.sandbox;

public class FirstClass {
    private String myVar; 

    public FirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello() {
        return "Hello! " + myVar + ".";
    }
}
