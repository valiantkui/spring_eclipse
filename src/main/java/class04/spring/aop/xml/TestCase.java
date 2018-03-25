package class04.spring.aop.xml;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	private ApplicationContext ioc;
	
	@Before
	public void initIOC() {
		ioc = new ClassPathXmlApplicationContext("config/class04/ApplicationContext.xml");
		
	}
	
	@Test
	public void test1() {
		
		System.out.println("test1()");
		Acount acount = ioc.getBean("ac",Acount.class);
		System.out.println(acount.getBalance());
	}
	
	@Test
	public void test2() {
		
		System.out.println("test2()");
		AcountService acountService = ioc.getBean("acountServcie",AcountService.class);
		
		Acount acount = ioc.getBean("ac",Acount.class);
		BigDecimal balance1 = acountService.cunQian(acount, new BigDecimal("50"));
		
		BigDecimal balance2 = acountService.quQian(acount, new BigDecimal("30"));
		System.out.println("存钱后的余额为："+balance1+", 取钱后的余额为："+ balance2);
	}
	
	@Test
	public void test3() {
		
		
	}
	
	
}
