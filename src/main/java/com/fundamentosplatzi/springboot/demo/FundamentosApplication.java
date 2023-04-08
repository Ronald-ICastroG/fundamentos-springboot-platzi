package com.fundamentosplatzi.springboot.demo;

import com.fundamentosplatzi.springboot.demo.bean.MyBean;
import com.fundamentosplatzi.springboot.demo.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.demo.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.demo.component.ComponentDependency;
import com.fundamentosplatzi.springboot.demo.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private	final Log LOGGER= LogFactory.getLog(FundamentosApplication.class);

	private MyBean myBean;
	private ComponentDependency componentDependency;

	private MyBeanWithDependency myBeanWithDependency;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	@Autowired //ya en versiones recientes no es obligatorio
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean,MyBeanWithDependency myBeanWithDependency,MyBeanWithProperties myBeanWithProperties,UserPojo userPojo){
		this.componentDependency=componentDependency;
		this.myBean=myBean;
		this.myBeanWithDependency=myBeanWithDependency;
		this.myBeanWithProperties=myBeanWithProperties;
		this.userPojo=userPojo;

	}


	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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
