package polymorphism;

public class SamsungTV implements TV{
	
	//private SonySpeaker speaker;
	private Speaker speaker;
private int price;
	//applicationContext.xml�������Ͽ� �ۼ� init-method="initMethod"

	
	public SamsungTV() {
		System.out.println("�ＺƼ�� 1 ��ü ����");
	}
	
	//SonySpeaker speaker�� �Ű������� �־ ��� �׷��� ������ ����SonySpeaker�� ����
	public SamsungTV(SonySpeaker speaker,int price) {
		System.out.println("�ＺƼ�� 2 ��ü ����");
		this.speaker=speaker;
		this.price=price;
	}
	
	public SamsungTV(Speaker speaker,int price) {
		System.out.println("�ＺƼ�� 3 ��ü ����");
		this.speaker=speaker;
		this.price=price;
	}
	
	
	public void powerOn(){
		System.out.println("s-TV��" + " ������ "+price+"��");
	}
	
	
	public void volumeUp(){
		//speaker=new SonySpeaker();
		speaker.volumeUp();
		
	}
	
	public void volumeDown(){
		//speaker=new SonySpeaker();
		speaker.volumeDown();
	
	}
	
	public void powerOff(){
		System.out.println("s-TV��");
	}
	
	//applicationContext.xml�������Ͽ� �ۼ� destroy-method="destoryMethod"
	public void destoryMethod(){
		System.out.println("��ü ���� ���� ó���� ����");
	}
}
