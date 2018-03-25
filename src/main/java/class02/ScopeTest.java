package class02;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
	
	private ApplicationContext ioc;
	
	//AbstractApplicationContext是ApplicationContext接口的实现类
	//private AbstractApplicationContext ioc;
	@Before
	public void before() {
		ioc = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
	}
	
	@Test
	public void test0() {
		//ioc.close();
	}

	@Test
	public void test1() {
		System.out.println("test1()");
		
		Fruit fruit=ioc.getBean("apple",Apple.class);
		fruit.eaten();
	}
	@Test
	public void test2() {
		System.out.println("test2()");
		
		Apple apple = ioc.getBean("apple",Apple.class);
		System.out.println(apple);
	}
	
	/**
	 * 测试内部bean
	 * 涉及Student、Depart类
	 */
	@Test 
	public void test3() {
		System.out.println("test3()");
		Student student = ioc.getBean("student",Student.class);
		System.out.println(student);
		
	}
	
	
	/**
	 * 验证当spring容器启动时，内部bean(Depart的bean)是否会被加载
	 * 验证结论：会被加载
	 */
	@Test
	public void test4() {
		System.out.println("test4()");
		
	}
	
	@Test
	public void test5() {
		System.out.println("test5()");
	}
	
	@Test
	public void test6() {
		
		List<String> list = ioc.getBean("nameList",List.class);
		System.out.println(list);
	}
	
}
