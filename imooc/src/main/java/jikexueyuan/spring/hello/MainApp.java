package jikexueyuan.spring.hello;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.PathManager;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(PathManager.getDirClasspath(MainApp.class)  + "/Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloworld");
		obj.getMessage();
	}
}
