
public class SamsungTV implements TV{

	//applicationContext.xml�������Ͽ� �ۼ� init-method="initMethod"
	public void initMethod(){
		System.out.println("�ＺƼ�� ��ü ����");
	}
	
//	public SamsungTV() {
//		System.out.println("�ＺƼ�� ��ü ����");
//	}
	public void powerOn(){
		System.out.println("s-TV��");
	}
	
	public void powerOff(){
		System.out.println("s-TV��");
	}
	
	public void volumeUp(){
		System.out.println("s-TV�Ҹ� �ø�");
	}
	
	public void volumeDown(){
		System.out.println("s-TV�Ҹ� ����");
	}
	
	//applicationContext.xml�������Ͽ� �ۼ� destroy-method="destoryMethod"
	public void destoryMethod(){
		System.out.println("��ü ���� ���� ó���� ����");
	}
}
