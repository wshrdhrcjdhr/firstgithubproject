package �Ի�����;

import java.util.Scanner;

public class Shujjuzhuti {
	public static void main(String[] args) {
		//�������⣬һ�鶩����Ϣ
		String[] names = new String[4];//������
		String[] dishmegs=new String[4];//���в�Ʒ��Ϣ 
		int[] times = new int[4];//�Ͳ�ʱ��
		String[] addresses = new String[4];//�Ͳ͵�ַ
		int[] states = new int[4];//����״̬ 0�������� 1�������
		double[] summoney = new double[4];
		
		//��ʼ������������Ϣ
		names[0] = "����";
		dishmegs[0] = "������˿ 1��";
		times[0] = 12;
		addresses[0] = "���·209��";
		states[0] = 1;
		summoney[0] = 24.0;
		
		
		names[1] = "����";
		dishmegs[1] = "���մ��� 2��";
		times[1] = 12;
		addresses[1] = "���·209��";
		states[1] = 0;
		summoney[1] = 76.0;
		
		//�������壺һ���Ʒ��Ϣ
		String[] dishnames = {"���մ���","������˿","ʱ���߲�"};
		double[] prices = {38.0,18.0,10.0};
		int[] praisenums = new int[3];
		
		Scanner input=new Scanner(System.in);
		//ѭ����do-while��
		int num=-1;//��¼�û����������
		do{
			//ѭ������
			//��ʾ���˵�
			System.out.println("********************************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("********************************");
			//��ʾ�û����빦�ܱ�ţ���ִ����Ӧ����
			System.out.print("��ѡ��");
			int choose = input.nextInt();
			boolean isadd=false;//true ��¼֪��һ��Ϊ�յ�λ�ã����Բ��� false��û���ҵ�
			
			switch(choose){
			case 1:
				//1.��Ҫ����
				System.out.println("****��Ҫ����****");
				//1,����Ҫ�����λ��
				for(int i=0;i<names.length;i++){
					//����ҵ�Ϊ�յ�λ�ü�¼���� 
					if(names[i]==null){
						isadd=true;//��¼���ҵ�һ��Ϊ�յ�λ��
						//ִ�в������
						//a.��ʾ���пɹ�ѡ��Ĳ�Ʒ��Ϣ
						System.out.println("���\t��Ʒ��\t����\t������");
						for(int j=0;j<dishnames.length;j++){
							String price = prices[j]+"Ԫ";
							String praise = praisenums[j]+"��";
							System.out.println((j+1)+"\t"+dishnames[j]+"\t"+praise);
						}
						//������ѡ����Լ�����
						System.out.print("��ѡ��������Ʒ�źţ�");
						int choosedish = input.nextInt();
						System.out.print("��ѡ����ѡ����");
						int number = input.nextInt();
						String dishmeg = dishnames[choosedish-1]+" "+number+"��";
						//b.���붩��������
						System.out.print("�����붩��������");
						String name = input.next();
						
						//c.�����Ͳ�ʱ��
						System.out.print("�������Ͳ�ʱ�䣨10~20�����Ͳͣ�");
						int time = input.nextInt();
						//�������ˣ��ظ�����
						while(time<10||time>20){
							System.out.print("�Բ������������д�������10~20֮�������");
							time = input.nextInt();
						}
						
						//d.�����Ͳ͵�ַ
						System.out.print("�������Ͳ͵�ַ");
						String address=input.next();
						
						//e.����ͷ�
						double sumprice = prices[choosedish-1]*number;
						//���ͷѴﵽ 50Ԫʱ����6Ԫ�Ͳͷ�
						double delicharge = sumprice>=50?0.0:6.0;
						//��ʾ������Ϣ
						System.out.println("���ͳɹ���");
						System.out.println("��������"+dishmeg);
						System.out.println("������"+name);
						System.out.println("�Ͳ�ʱ��"+time+"��");
						System.out.println("�Ͳ͵�ַ��"+address);
						System.out.println("�ͷ�"+sumprice+",�Ͳͷѣ�"+delicharge+"Ԫ");
						System.out.println("�����ܽ��"+(sumprice+delicharge)+"Ԫ");
						
						//�������� 
						names[i]=name;
						dishmegs[i]=dishmeg;
						times[i]=time;
						addresses[i]=address;
						summoney[i]=sumprice+delicharge;
						break;
					}
				}
				//���û���ҵ�Ϊ�յ�λ�ã�����ʾ��Ϣ
				if(!isadd){
					System.out.println("�Բ������Ĳʹ�����");
				}
				break;
			case 2:
				//2.�鿴�ʹ�
				System.out.println("****�鿴�ʹ�****");
				System.out.println("���\t������\t������Ʒ��Ϣ\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t״̬");
				//��������
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time = times[i]+"��";
						String sumprice = summoney[i]+"Ԫ";
						String state = states[i]==0?"��Ԥ��":"�����";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishmegs[i]+
								"\t"+time+"\t"+addresses[i]+"\t"+sumprice+"\t"+state);
					}
				}
				break;
			case 3:
				//3.ǩ�ն���
				System.out.println("****ǩ�ն���****");
				//Ҫ�������һ��ǩ�յĶ������
				System.out.println("������Ҫǩ�յĶ������");
				int signorderid = input.nextInt();
				boolean isfind = false;//��¼�Ƿ��ҵ����������� true�����ҵ� false��û���ҵ�
				//��������������ѭ��������
				for(int i=0;i<names.length;i++){
					//1.�ҵ���״̬������ɣ��Ѿ�ǩ����ϣ�����ʾ�����ٴ�ǩ��
					//2.�ҵ���״̬����Ԥ����û�����ǩ�գ�������ǩ��
					if(names[i]!=null && states[i]==1 && signorderid==i+1){
						System.out.println("�Բ�����ѡ��Ķ��������ǩ�գ������ٴ�ǩ��");
						isfind=true;
						break;
					}else if(names[i]!=null && states[i]==0 && signorderid==i+1){
						states[i]=1;//״ֵ̬��Ϊ�����״̬
						System.out.println("����ǩ�ճɹ�");
						isfind=true;
						break;
					}
				}
				if(!isfind){
					System.out.println("�Բ��𣬴˶���������");
				}
				//�����жϣ����û���ҵ��� ����������ȥ��ʾû���ҵ�
				
				
				//3.û�ҵ� ����ʾ��Ϣû���ҵ�
				break;
			case 4:
				//4.ɾ������
				//1 ����Ҫɾ���Ķ�����ţ���һ��ʼ��
				System.out.println("****ɾ������****");
				System.out.println("������Ҫɾ���Ķ�����ţ�");
				int delid = input.nextInt();
				int delindex = -1;//ɾ���������±�
				boolean isdelfind=false;//�����Ƿ��ҵ��˶��� true���ҵ��� false��û�ҵ�
				//2 ѭ���ҵ���������
				for(int i=0;i<names.length;i++){
					//�ҵ��˶�������ǩ�գ�ִ��ɾ������(�ȼ�¼Ҫɾ���Ķ������)
					//�ҵ��˶�����δǩ�գ���ʾ��Ϣ
					if(names[i]!=null && states[i]==1 && delid==i+1){
						delindex=i;
						isdelfind = true;
						break;
						
					}else if(names[i]!=null && states[i]==0 && delid==i+1){
						System.out.println("��ѡ��Ķ���δǩ�գ�����ɾ�� ");
						isdelfind = true;
						break;
					}
				}
				
				//δ�ҵ��˶�������ʾ��Ϣ
				if(!isdelfind){
					System.out.println("�Բ��𣬴˶��������ڣ�");
				}
				//ִ��ɾ������
				if(delindex!=-1){
					//ɾ������ ��ѭ����λ��
					//��Ҫɾ����Ԫ�غ���һλ��ʼ�����������һ��Ԫ��һ����ǰ�ƶ�һλ
					for(int i=delindex+1;i<=names.length-1;i++){
						names[i-1]=names[i];
						dishmegs[i-1]=dishmegs[i];
						times[i-1]=times[i];
						addresses[i-1]=addresses[i];
						states[i-1]=states[i];
					}
					//�����Ϊ���
					names[names.length-1]=null;
					dishmegs[names.length-1]=null;
					times[names.length-1]=0;
					addresses[names.length-1]=null;
					states[names.length-1]=0;
					
					System.out.println("����ɾ���ɹ�");
				}
				break;
			case 5:
				/*//5.��Ҫ����
				System.out.println("****��Ҫ����****");
				//��ʾ���޵Ĳ�Ʒ�б�
				System.out.println("���\t��Ʒ��\t����\t������");
				for(int j=0;j<dishnames.length;j++){
					String price = prices[j]+"Ԫ";
					String praise = praisenums[j]+"��";
					System.out.println((j+1)+"\t"+dishnames[j]+"\t"+praise);
				}
				System.out.println("����Ҫ���޵Ĳ�Ʒ���");
				int dishid = input.nextInt();
				
				//����Ҫ���޵Ĳ�Ʒ���
				//����ŵĲ�Ʒ��������1
				praisenums[dishid-1]++;
				//��ʾ
				System.out.println("���޳ɹ�");
				System.out.println(dishnames[dishid-1]+" "+praisenums[dishid-1]+"��");
				break;
				*/
			case 6:
				//6.�˳�ϵͳ
				
			default:
				break;
			}
			//���û��������1-5֮������֣��˳�ѭ�������򽫻���ʾ����0����
			if(choose<1||choose>5){
				break;
			}else{
			//��ʾ����0����
			System.out.print("����0���أ�");
			num = input.nextInt();
			}
		}while(num==0);
		System.out.println("ллʹ�ã���ӭ�´ι��٣�");
		
		
	}
}
