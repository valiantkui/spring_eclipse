package class04.spring.aop.xml;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("acountServcie")
public class AcountServiceIml implements AcountService {


	/**
	 * ��ָ���˻��д�Ǯ��
	 * @return ���ظ��˻��ĵ�ǰ���
	 */
	public BigDecimal cunQian(Acount acount, BigDecimal money) {
		
		//System.out.println(acount.getBalance());
		acount.setBalance(acount.getBalance().add(money));
		
		return acount.getBalance();
	}

	/**
	 * ��ָ���˻���ȡǮ
	 * @return ���ظ��˻��ĵ�ǰ���
	 */
	public BigDecimal quQian(Acount acount, BigDecimal money) {
		
		acount.setBalance(acount.getBalance().subtract(money));
		
		
		return acount.getBalance();
	}
	
	

}
