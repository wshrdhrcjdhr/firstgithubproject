package 吃货联盟;

import java.util.Scanner;

public class Shujjuzhuti {
	public static void main(String[] args) {
		//数据主题，一组订单信息
		String[] names = new String[4];//订餐人
		String[] dishmegs=new String[4];//所有餐品信息 
		int[] times = new int[4];//送餐时间
		String[] addresses = new String[4];//送餐地址
		int[] states = new int[4];//订单状态 0：已锁定 1：已完成
		double[] summoney = new double[4];
		
		//初始化两条订单信息
		names[0] = "张青";
		dishmegs[0] = "鱼香肉丝 1份";
		times[0] = 12;
		addresses[0] = "天成路209号";
		states[0] = 1;
		summoney[0] = 24.0;
		
		
		names[1] = "张青";
		dishmegs[1] = "红烧带鱼 2份";
		times[1] = 12;
		addresses[1] = "天成路209号";
		states[1] = 0;
		summoney[1] = 76.0;
		
		//数据主体：一组餐品信息
		String[] dishnames = {"红烧带鱼","鱼香肉丝","时令蔬菜"};
		double[] prices = {38.0,18.0,10.0};
		int[] praisenums = new int[3];
		
		Scanner input=new Scanner(System.in);
		//循环（do-while）
		int num=-1;//记录用户输入的数字
		do{
			//循环操作
			//显示主菜单
			System.out.println("********************************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("********************************");
			//提示用户输入功能编号，并执行相应功能
			System.out.print("请选择：");
			int choose = input.nextInt();
			boolean isadd=false;//true 记录知道一个为空的位置，可以插入 false：没有找到
			
			switch(choose){
			case 1:
				//1.我要订餐
				System.out.println("****我要订餐****");
				//1,查找要插入的位置
				for(int i=0;i<names.length;i++){
					//如果找到为空的位置记录下来 
					if(names[i]==null){
						isadd=true;//记录已找到一个为空的位置
						//执行插入操作
						//a.显示所有可供选择的餐品信息
						System.out.println("序号\t餐品名\t单价\t点赞数");
						for(int j=0;j<dishnames.length;j++){
							String price = prices[j]+"元";
							String praise = praisenums[j]+"赞";
							System.out.println((j+1)+"\t"+dishnames[j]+"\t"+praise);
						}
						//输入所选编号以及分数
						System.out.print("请选择所订餐品信号：");
						int choosedish = input.nextInt();
						System.out.print("请选择所选分数");
						int number = input.nextInt();
						String dishmeg = dishnames[choosedish-1]+" "+number+"份";
						//b.输入订餐人姓名
						System.out.print("请输入订餐人姓名");
						String name = input.next();
						
						//c.输入送餐时间
						System.out.print("请输入送餐时间（10~20整点送餐）");
						int time = input.nextInt();
						//如果输错了，重复输入
						while(time<10||time>20){
							System.out.print("对不起，您的输入有错，请输入10~20之间的整数");
							time = input.nextInt();
						}
						
						//d.输入送餐地址
						System.out.print("请输入送餐地址");
						String address=input.next();
						
						//e.计算餐费
						double sumprice = prices[choosedish-1]*number;
						//当餐费达到 50元时，免6元送餐费
						double delicharge = sumprice>=50?0.0:6.0;
						//显示订单信息
						System.out.println("订餐成功！");
						System.out.println("您定的是"+dishmeg);
						System.out.println("订餐人"+name);
						System.out.println("送餐时间"+time+"点");
						System.out.println("送餐地址："+address);
						System.out.println("餐费"+sumprice+",送餐费："+delicharge+"元");
						System.out.println("订单总金额"+(sumprice+delicharge)+"元");
						
						//保存数据 
						names[i]=name;
						dishmegs[i]=dishmeg;
						times[i]=time;
						addresses[i]=address;
						summoney[i]=sumprice+delicharge;
						break;
					}
				}
				//如果没有找到为空的位置，则提示信息
				if(!isadd){
					System.out.println("对不起，您的餐袋已满");
				}
				break;
			case 2:
				//2.查看餐袋
				System.out.println("****查看餐袋****");
				System.out.println("序号\t订餐人\t所定餐品信息\t送餐时间\t送餐地址\t\t总金额\t状态");
				//遍历数组
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time = times[i]+"点";
						String sumprice = summoney[i]+"元";
						String state = states[i]==0?"已预订":"已完成";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishmegs[i]+
								"\t"+time+"\t"+addresses[i]+"\t"+sumprice+"\t"+state);
					}
				}
				break;
			case 3:
				//3.签收订单
				System.out.println("****签收订单****");
				//要求输入的一个签收的订单序号
				System.out.println("请输入要签收的订单序号");
				int signorderid = input.nextInt();
				boolean isfind = false;//记录是否找到了这条订单 true：已找到 false：没有找到
				//查找这条订单（循环遍历）
				for(int i=0;i<names.length;i++){
					//1.找到，状态是已完成（已经签收完毕）：提示不能再次签收
					//2.找到，状态是已预订（没有完成签收）：可以签收
					if(names[i]!=null && states[i]==1 && signorderid==i+1){
						System.out.println("对不起，您选择的订单已完成签收，不能再次签收");
						isfind=true;
						break;
					}else if(names[i]!=null && states[i]==0 && signorderid==i+1){
						states[i]=1;//状态值改为已完成状态
						System.out.println("订单签收成功");
						isfind=true;
						break;
					}
				}
				if(!isfind){
					System.out.println("对不起，此订单不存在");
				}
				//条件判断：如果没有找到这 跳订单，才去提示没有找到
				
				
				//3.没找到 ，提示信息没有找到
				break;
			case 4:
				//4.删除订餐
				//1 输入要删除的订单序号（从一开始）
				System.out.println("****删除订单****");
				System.out.println("请输入要删除的订单序号：");
				int delid = input.nextInt();
				int delindex = -1;//删除订单的下标
				boolean isdelfind=false;//定义是否找到此订单 true：找到了 false：没找到
				//2 循环找到这条订单
				for(int i=0;i<names.length;i++){
					//找到此订单，已签收；执行删除操作(先记录要删除的订单序号)
					//找到此订单，未签收；提示信息
					if(names[i]!=null && states[i]==1 && delid==i+1){
						delindex=i;
						isdelfind = true;
						break;
						
					}else if(names[i]!=null && states[i]==0 && delid==i+1){
						System.out.println("您选择的订单未签收，不能删除 ");
						isdelfind = true;
						break;
					}
				}
				
				//未找到此订单；提示信息
				if(!isdelfind){
					System.out.println("对不起，此订单不存在！");
				}
				//执行删除操作
				if(delindex!=-1){
					//删除操作 （循环移位）
					//从要删除的元素后面一位开始，到数组最后一个元素一次向前移动一位
					for(int i=delindex+1;i<=names.length-1;i++){
						names[i-1]=names[i];
						dishmegs[i-1]=dishmegs[i];
						times[i-1]=times[i];
						addresses[i-1]=addresses[i];
						states[i-1]=states[i];
					}
					//最后以为清空
					names[names.length-1]=null;
					dishmegs[names.length-1]=null;
					times[names.length-1]=0;
					addresses[names.length-1]=null;
					states[names.length-1]=0;
					
					System.out.println("订单删除成功");
				}
				break;
			case 5:
				/*//5.我要点赞
				System.out.println("****我要点赞****");
				//显示点赞的餐品列表
				System.out.println("序号\t餐品名\t单价\t点赞数");
				for(int j=0;j<dishnames.length;j++){
					String price = prices[j]+"元";
					String praise = praisenums[j]+"赞";
					System.out.println((j+1)+"\t"+dishnames[j]+"\t"+praise);
				}
				System.out.println("输入要点赞的产品序号");
				int dishid = input.nextInt();
				
				//输入要点赞的餐品序号
				//该序号的产品点赞数加1
				praisenums[dishid-1]++;
				//显示
				System.out.println("点赞成功");
				System.out.println(dishnames[dishid-1]+" "+praisenums[dishid-1]+"赞");
				break;
				*/
			case 6:
				//6.退出系统
				
			default:
				break;
			}
			//当用户数输入的1-5之外的数字，退出循环。否则将会提示输入0返回
			if(choose<1||choose>5){
				break;
			}else{
			//提示输入0返回
			System.out.print("输入0返回：");
			num = input.nextInt();
			}
		}while(num==0);
		System.out.println("谢谢使用，欢迎下次光临！");
		
		
	}
}
