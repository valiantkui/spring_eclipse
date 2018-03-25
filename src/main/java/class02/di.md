3.3.1. ע������
����ע�루DI������Ļ���ԭ���Ƕ���֮���������ϵ����һ��������������ֻ��ͨ�����¼��ַ�ʽ��ʵ�֣��������Ĳ��������������Ĳ���������ɹ��캯�����߹������������Ķ����������ԡ���ˣ������Ĺ������Ǵ���beanʱע����Щ������ϵ���������bean�Լ���������ʵ������ֱ���ڹ�������ָ��������ϵ�������Ʒ���λ����Service Locator��ģʽ��3����������������ϵע��ķ�����˵�����ƴӸ����Ϸ����˵�ת����Ҳ���ǿ��Ʒ�ת��Inversion of Control�� IoC�� ���ֵ������� 

Ӧ��DIԭ��󣬴��뽫�������������ҵ�bean�Լ����ٵ��Ķ���֮���������ϵ��������֪�������Ķ���ָ���ط���������ʵ���ࣩ֮��ʵ�ָ��߲�ε�����Ͻ����練�ơ�DI��Ҫ������ע�뷽ʽ����Setterע��͹�����ע��

�� 
3.3.1.1. ������ע��
���ڹ�������DIͨ�����ô������Ĺ�������ʵ�֣�ÿ������������һ�����������⣬����ͨ����stattic��������������������bean���������Ľ��ܽ���Ϊ�����������������̬�����������������Ƶġ�����չʾ��ֻ��ʹ�ù�����������ע��������ϵ�����ӡ���ע�⣬����ಢû��ʲô�ر�֮����

public class SimpleMovieLister {

    // the SimpleMovieLister has a dependency on a MovieFinder
    private MovieFinder movieFinder;

    // a constructor so that the Spring container can 'inject' a MovieFinder
    public SimpleMovieLister(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
    
    // business logic that actually 'uses' the injected MovieFinder is omitted...
}
3.3.1.1.1. ��������������
�����������������ݲ������ͽ���ƥ�䣬���bean�Ĺ������������Ͷ���ǳ���ȷ����ô��bean��ʵ������ʱ��bean�����й����������Ķ���˳�������Щ������˳�����ν���ƥ�䣬��������Ĵ���

package x.y;

public class Foo {

    public Foo(Bar bar, Baz baz) {
        // ...
    }
}
�������������ڹ�������ǳ���ȷ���������Ǽٶ� Bar�� Baz֮�䲻���ڼ̳й�ϵ���������������ü�ʹû����ȷָ���������˳�򣨺����ͣ���Ҳ�Ṥ���ĺܺá�

<beans>
    <bean name="foo" class="x.y.Foo">
        <constructor-arg>
            <bean class="x.y.Bar"/>
        </constructor-arg>
        <constructor-arg>
            <bean class="x.y.Baz"/>
        </constructor-arg>
    </bean>
</beans>
������������һ��bean����bean�Ĺ������������֪��ƥ��Ҳû������(��ǰ�������һ��)�����ǵ�ʹ�ü�����ʱ������<value>true<value>��Spring���޷�֪����ֵ�����͡����������������������޷��������ݲ������ͽ���ƥ�䣬���������������ӣ�

package examples;

public class ExampleBean {

    // No. of years to the calculate the Ultimate Answer
    private int years;

    // The Answer to Life, the Universe, and Everything
    private String ultimateAnswer;

    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }
}
3.3.1.1.1.1. ��������������ƥ��
�������ĳ�������ͨ��ʹ��'type'��������ʽָ����Щ�����͵Ĺ�����������ͣ����磺

<bean id="exampleBean" class="examples.ExampleBean">
  <constructor-arg type="int" value="7500000"/>
  <constructor-arg type="java.lang.String" value="42"/>
</bean>
3.3.1.1.1.2. �����������
���ǻ�����ͨ��index��������ʽָ�����������������������������ӣ�

<bean id="exampleBean" class="examples.ExampleBean">
  <constructor-arg index="0" value="7500000"/>
  <constructor-arg index="1" value="42"/>
</bean>
ͨ��ʹ���������Բ������Խ����������ԵĻ������⣬�����Խ���п�������ͬ���͵�2����������Ļ��������ˣ�ע��index�Ǵ�0��ʼ��

3.3.1.2. Setterע��
ͨ�������޲ι��������޲�static��������ʵ����bean֮�󣬵��ø�bean��setter����������ʵ�ֻ���setter��DI��

��������ӽ�չʾֻʹ��setterע��������ע�⣬����ಢû��ʲô�ر�֮������������ͨ��Java�ࡣ

public class SimpleMovieLister {

    // the SimpleMovieLister has a dependency on the MovieFinder
    private MovieFinder movieFinder;

    // a setter method so that the Spring container can 'inject' a MovieFinder
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // business logic that actually 'uses' the injected MovieFinder is omitted...
}
3.3.1.3. һЩ����
������һ����XML��ʽ�����Setter DI���ӡ���ص�XML�������£�

<bean id="exampleBean" class="examples.ExampleBean">

  <!-- setter injection using the nested <ref/> element -->
  <property name="beanOne"><ref bean="anotherExampleBean"/></property>

  <!-- setter injection using the neater 'ref' attribute -->
  <property name="beanTwo" ref="yetAnotherBean"/>
  <property name="integerProperty" value="1"/>
</bean>

<bean id="anotherExampleBean" class="examples.AnotherBean"/>
<bean id="yetAnotherBean" class="examples.YetAnotherBean"/>
public class ExampleBean {

    private AnotherBean beanOne;
    private YetAnotherBean beanTwo;
    private int i;

    public void setBeanOne(AnotherBean beanOne) {
        this.beanOne = beanOne;
    }

    public void setBeanTwo(YetAnotherBean beanTwo) {
        this.beanTwo = beanTwo;
    }

    public void setIntegerProperty(int i) {
        this.i = i;
    }    
}
�������������ģ�bean���е�setter������xml�ļ������õ�������һһ��Ӧ�ġ������ǹ�����ע������ӣ�

<bean id="exampleBean" class="examples.ExampleBean">

  <!-- constructor injection using the nested <ref/> element -->
  <constructor-arg>
    <ref bean="anotherExampleBean"/>
  </constructor-arg>
  
  <!-- constructor injection using the neater 'ref' attribute -->
  <constructor-arg ref="yetAnotherBean"/>
  
  <constructor-arg type="int" value="1"/>
</bean>

<bean id="anotherExampleBean" class="examples.AnotherBean"/>
<bean id="yetAnotherBean" class="examples.YetAnotherBean"/>
public class ExampleBean {

    private AnotherBean beanOne;
    private YetAnotherBean beanTwo;
    private int i;
    
    public ExampleBean(
        AnotherBean anotherBean, YetAnotherBean yetAnotherBean, int i) {
        this.beanOne = anotherBean;
        this.beanTwo = yetAnotherBean;
        this.i = i;
    }
}
������������xml bean������ָ���Ĺ�������������������Ϊ���ݸ���ExampleBean�������Ĳ�����

�������о�һ������������ķ���������static�����������ض���ʵ����

<bean id="exampleBean" class="examples.ExampleBean"
      factory-method="createInstance">
  <constructor-arg ref="anotherExampleBean"/>
  <constructor-arg ref="yetAnotherBean"/>
  <constructor-arg value="1"/> 
</bean>

<bean id="anotherExampleBean" class="examples.AnotherBean"/>
<bean id="yetAnotherBean" class="examples.YetAnotherBean"/>
public class ExampleBean {

    // a private constructor
    private ExampleBean(...) {
      ...
    }
    
    // a static factory method; the arguments to this method can be
    // considered the dependencies of the bean that is returned,
    // regardless of how those arguments are actually used.
    public static ExampleBean createInstance (
            AnotherBean anotherBean, YetAnotherBean yetAnotherBean, int i) {

        ExampleBean eb = new ExampleBean (...);
        // some other operations...
        return eb;
    }
}
��ע�⣬����static���������Ĳ�����constructor-argԪ���ṩ������ʹ�ù�����ע��ʱ��ȫһ�������ң���Ҫ���ǣ��������������ص�ʵ�������Ͳ���һ��Ҫ�����static����������������һ�¡������ڴ�����������ȷ���������Ǿ�̬��ʵ���������������ͬ������ʹ��factory-bean�������class�����⣩��������ڴ�ϸ����
