import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	//factory����
	public static void main(String[] args) {
	//TV stv=new LgTV();
		//BeanFactory factory=new BeanFactory();
		//������������ BeanFactory�� �̸� ����� ApplicationContext�ΰ��� ������ �����̳� ����
		//ApplicationContext�� ��� �ε� �ܿ� �پ��� ����� �����ϹǷ� �̰��� ����ϴ� ���� ����
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		//������ �����̳ʷκ��� �Ｚtv ��ü�� ��
//		TV stv=(TV) factory.getBean("tv");
		
		////applicationContext.xml�������Ͽ� �ۼ� scope="singleton"������ �ϳ��� ��µ�
		//applicationContext.xml�������Ͽ� �ۼ� scope="prototype"������ ��� ��µ�
		TV stv1=(TV) factory.getBean("tv");
		TV stv2=(TV) factory.getBean("tv");
		TV stv3=(TV) factory.getBean("tv");
		TV stv4=(TV) factory.getBean("tv");
		
	/*	
		System.out.println(stv);
	stv.powerOn();
	stv.volumeUp();
	stv.volumeDown();
	stv.powerOff();
	*/
	
	//������ �����̳� ����
	factory.close();
	}

	
}
