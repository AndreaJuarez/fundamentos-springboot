package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWithDependencyImplement implements  MyBeanWithDependency {

    private MyOperation myOperation;    //Inyectamos la dependencia MyOperation
    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        System.out.println(myOperation.suma(1));
        System.out.println("Hello from the implement of a bean with dependency");
    }
}
