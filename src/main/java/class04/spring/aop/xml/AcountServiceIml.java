package class04.spring.aop.xml;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("acountServcie")
public class AcountServiceIml implements AcountService {


	/**
	 * 向指定账户中存钱，
	 * @return 返回该账户的当前金额
	 */
	public BigDecimal cunQian(Acount acount, BigDecimal money) {
		
		//System.out.println(acount.getBalance());
		acount.setBalance(acount.getBalance().add(money));
		
		return acount.getBalance();
	}

	/**
	 * 从指定账户中取钱
	 * @return 返回该账户的当前余额
	 */
	public BigDecimal quQian(Acount acount, BigDecimal money) {
		
		acount.setBalance(acount.getBalance().subtract(money));
		
		
		return acount.getBalance();
	}
	
	

}
