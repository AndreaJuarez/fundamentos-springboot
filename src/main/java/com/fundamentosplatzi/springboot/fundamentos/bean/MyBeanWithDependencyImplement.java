package com.fundamentosplatzi.springboot.fundamentos.bean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements  MyBeanWithDependency {

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private MyOperation myOperation;    //Inyectamos la dependencia MyOperation
    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos ingresado al método printWithDependency");
        int numero = 1;
        LOGGER.debug("El numero enviado como parametro a la dependencia es: " + numero);
        System.out.println(myOperation.suma(numero));
        System.out.println("Hello from the implement of a bean with dependency");
    }
}
