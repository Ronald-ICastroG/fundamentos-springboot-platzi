package com.fundamentosplatzi.springboot.demo;

import com.fundamentosplatzi.springboot.demo.bean.MyBean;
import com.fundamentosplatzi.springboot.demo.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.demo.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.demo.component.ComponentDependency;
import com.fundamentosplatzi.springboot.demo.entity.User;
import com.fundamentosplatzi.springboot.demo.pojo.UserPojo;
import com.fundamentosplatzi.springboot.demo.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	private	final Log LOGGER= LogFactory.getLog(FundamentosApplication.class);

	private MyBean myBean;
	private ComponentDependency componentDependency;

	private MyBeanWithDependency myBeanWithDependency;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	private UserRepository userRepository;


	@Autowired //ya en versiones recientes no es obligatorio
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean,MyBeanWithDependency myBeanWithDependency,MyBeanWithProperties myBeanWithProperties,UserPojo userPojo,UserRepository userRepository){
		this.componentDependency=componentDependency;
		this.myBean=myBean;
		this.myBeanWithDependency=myBeanWithDependency;
		this.myBeanWithProperties=myBeanWithProperties;
		this.userPojo=userPojo;
		this.userRepository=userRepository;


	}


	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
	//ejemplosAnteriores();
		saveUsersInDataBase();


	}
	private void saveUsersInDataBase(){
		User user1=new User("John","john@domain.com", LocalDate.of(2023,4,7));
		User user2=new User("Julie","julie2@domain.com", LocalDate.of(2023,5,18));
		User user3=new User("pedro","pedri2@domain.com", LocalDate.of(2021,9,25));
		User user4=new User("cosme","cosme@domain.com", LocalDate.of(2019,11,21));
		User user5=new User("ricardo","ricardo2@domain.com", LocalDate.of(2013,8,30));
		User user6=new User("damian","damian@domain.com", LocalDate.of(2015,7,18));
		User user7=new User("oscar","oscar@domain.com", LocalDate.of(2020,5,2));
		User user8=new User("manuel","manuel@domain.com", LocalDate.of(2019,3,11));
		User user9=new User("lina","lina@domain.com", LocalDate.of(2019,4,14));
		User user10=new User("camilo","camilo@domain.com", LocalDate.of(2003,4,7));
		User user11=new User("samuel","samuel2@domain.com", LocalDate.of(2013,2,17));
		User user12=new User("fatima","fatima@domain.com", LocalDate.of(2014,3,25));
		User user13=new User("beatriz","beata@domain.com", LocalDate.of(2017,8,21));
		List<User> list= Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10,user11,user12,user13);
		list.stream().forEach(userRepository::save);
	}



	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());

		try {
			//error
			int value=10/0;
			LOGGER.debug("mi valor "+value);
		} catch(Exception e) {
			LOGGER.error("Esto es un error al dividir por cero "+e.getMessage());

		}

	}
}
