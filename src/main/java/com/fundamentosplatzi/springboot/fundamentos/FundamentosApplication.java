package com.fundamentosplatzi.springboot.fundamentos;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import org.apache.catalina.User;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency; //Inyectamos la dependencia (la Interfaz)
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	public  FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo){	//Metodo constructor
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	//Metodo run, ejecutara en la aplicacion lo que querramos
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println("Usuario: " + myBeanWithProperties.function());
		System.out.println("Email: " + userPojo.getEmail() + "\nContraseña: " + userPojo.getPassword());

		//Ejemplificando el uso de Logs dentro de un try catch
		try {
			int valuer = 10/0;
			LOGGER.debug("Mi valor: " + valuer);
		} catch (Exception e){
			LOGGER.error("Esto es un error dal dividir entre 0 " + e.getMessage());
		};

	}
}
