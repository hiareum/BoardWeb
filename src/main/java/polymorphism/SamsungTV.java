package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "stv")
public class SamsungTV implements TV{
	

		//@Autowired  //�����̳ʰ� SonySpeaker��ü�� speaker������ �ڵ� �Ҵ�, @Autowired �� ����ؾ� TV���� Speaker�� ��� �� �� ����
		@Autowired 
		@Qualifier(value = "appl")  //Speaker�� ��ӹ��� Ŭ������ 2��(sony,appl)�� �����Ƿ� �� �� appl�� ����Ѵٴ� �ǹ̷� �ۼ�
		private Speaker speaker;
		private int price;  
	
	
	/*
	@Resource(name="sony")//�����̳ʰ� ��Ƽ ����Ŀ ��ü�� ����Ŀ������ �ڵ����� �Ҵ�,@Autowired�� ������ Ÿ���� �������� ��ü�� �˻��Ͽ� ������ ó�������� ,  ��ſ� @Resource�� ��ü�� �̸��� �̿��Ͽ� ������ ����ó��
	private Speaker speaker;
	private int price;
	*/

	
	//applicationContext.xml�������Ͽ� �ۼ� init-method="initMethod"
	public SamsungTV() {
		System.out.println("�ＺƼ�� 1 ��ü ����");
	}
	
	/*
	 //�Ʒ� ����� �����ڸ� �̿��� ������ ó��(setter�޼��尡 �������� �ʴ� Ŭ������ ���ؼ��� ������ ������ ���)
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
	
	*/
	
	//�Ʒ� ����� setter������
	
	public void powerOn(){
		System.out.println("s-TV��" + " ������ "+price+"��");
	}
	
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("setPrice() ȣ��");
		this.price = price;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker() ȣ��");
		this.speaker = speaker;
	}

	public void volumeUp(){
		//speaker=new SonySpeaker();
		speaker.volumeUp();
		//System.out.println("�Ҹ��ø�");
	}
	
	public void volumeDown(){
	//	speaker=new SonySpeaker();
		speaker.volumeDown();
		//System.out.println("�Ҹ�����");
	}
	
	public void powerOff(){
		System.out.println("s-TV��");
	}
	
	//applicationContext.xml�������Ͽ� �ۼ� destroy-method="destoryMethod"
	public void destoryMethod(){
		System.out.println("��ü ���� ���� ó���� ����");
	}
}
