package book.proxy;

import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class BeforeAdviceTest {

	private Waiter target;
	private BeforeAdvice advice;
	private ProxyFactory pf;
	
	@Before
	public void init() {
		target = new NaiveWaiter();
		advice = new GreetingBeforeAdvice();
		
		//1.spring�ṩ�Ĵ�����
		pf = new ProxyFactory();
		
		//2.���ô���Ŀ��
		pf.setTarget(target);
		//3.Ϊ����Ŀ�������ǿ
		pf.addAdvice(advice);
	}
	
	@Test
	public void beforeAdvice() {
		Waiter proxy = (Waiter) pf.getProxy();
		proxy.greetTo("John");
		proxy.serveTo("Tom");
		
	}
}
