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
		
		//1.spring提供的代理工厂
		pf = new ProxyFactory();
		
		//2.设置代理目标
		pf.setTarget(target);
		//3.为代理目标添加增强
		pf.addAdvice(advice);
	}
	
	@Test
	public void beforeAdvice() {
		Waiter proxy = (Waiter) pf.getProxy();
		proxy.greetTo("John");
		proxy.serveTo("Tom");
		
	}
}
