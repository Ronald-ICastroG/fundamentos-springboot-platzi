package com.fundamentosplatzi.springboot.demo;

import com.fundamentosplatzi.springboot.demo.bean.MyBean;
import com.fundamentosplatzi.springboot.demo.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.demo.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.demo.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	private MyBean myBean;
	private ComponentDependency componentDependency;

	private MyBeanWithDependency myBeanWithDependency;

	private MyBeanWithProperties myBeanWithProperties;

	@Autowired //ya en versiones recientes no es obligatorio
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean,MyBeanWithDependency myBeanWithDependency,MyBeanWithProperties myBeanWithProperties){
		this.componentDependency=componentDependency;
		this.myBean=myBean;
		this.myBeanWithDependency=myBeanWithDependency;
		this.myBeanWithProperties=myBeanWithProperties;
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
	}
}
