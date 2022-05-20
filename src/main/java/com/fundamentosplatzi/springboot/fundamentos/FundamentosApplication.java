package com.fundamentosplatzi.springboot.fundamentos;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency; //Inyectamos la dependencia (la Interfaz)
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public  FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){	//Metodo constructor
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	//Metodo run, ejecutara en la aplicacion lo que querramos
		//ejemplosAnteriores();
		saveUsersInDatabase();
	}

	private void saveUsersInDatabase(){
		User user1 = new User("Andrea", "andre@gmail.com", LocalDate.of(2000,06,14));
		User user2 = new User("Marlen", "mar@gmail.com", LocalDate.of(2000,03,12));
		User user3 = new User("Nazareth", "naza@gmail.com", LocalDate.of(2000,10,23));
		User user4 = new User("Amairani", "amai@gmail.com", LocalDate.of(2000,01,25));
		User user5 = new User("Carmen", "carmen@gmail.com", LocalDate.of(2000,05,31));
		User user6 = new User("Fernando", "fers@gmail.com", LocalDate.of(2000,06,9));
		User user7 = new User("Adolfo", "adoleba@gmail.com", LocalDate.of(2000,05,10));
		User user8 = new User("Kevin", "kevin@gmail.com", LocalDate.of(2000,10,6));
		User user9 = new User("Yuridia", "yur@gmail.com", LocalDate.of(2000,12,5));
		User user10 = new User("Julissa", "yul@gmail.com", LocalDate.of(2000,05,1));
		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);
		list.stream().forEach(userRepository::save);
	}

	public void ejemplosAnteriores(){
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
