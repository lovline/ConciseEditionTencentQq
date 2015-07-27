package com.qq.client.views;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * �ҵĺ����б�
 * @author Administrator
 *
 */
public class QqFriendList extends JFrame implements ActionListener,MouseListener{

	//�����һ�ſ�Ƭ
	JPanel jp1,jp2,jp3,jp2_2;
	JButton jb1,jb2,jb3;
	JScrollPane jsp;
	//����ڶ��¿�Ƭ
	JPanel jpmsr1,jpmsr2,jpmsr3,jpmsr2_2;
	JButton jbmsr1,jbmsr2,jbmsr3;
	JScrollPane jsp2;
	
	//������JFRame���ó�cardlayout����
	CardLayout cl;
	private String ower;
	
	public static void main(String[] args) {
		//QqFriendList qfl=new QqFriendList(); �������������Եģ�������Բ���

	}
	public QqFriendList(String owerId){
		
		this.ower=owerId;
		jb1=new JButton("myfriends");
		jb2=new JButton("stranger");
		jb2.addActionListener(this);
		jb3=new JButton("blackpeople");
		
		jp2=new JPanel(new BorderLayout());
		jp2_2=new JPanel(new GridLayout(50,1,4,4));
		//��Jp2_2��ʼ��50������
		JLabel []jbls=new JLabel[50];
		for(int i=0;i<jbls.length;i++){
			jbls[i]=new JLabel(i+1+"",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
			jbls[i].addMouseListener(this);
			jp2_2.add(jbls[i]);
		}
		
		jp3=new JPanel(new GridLayout(2,1));
		
		jp3.add(jb2);
		jp3.add(jb3);
		
	
		jsp=new JScrollPane(jp2_2);
	
		jp2.add(jb1,"North");
		jp2.add(jsp,"Center");
		jp2.add(jp3,"South");
		
		
		//����ڶ��ſ�Ƭ
		jbmsr1=new JButton("myfriends");
		jbmsr1.addActionListener(this);
		jbmsr2=new JButton("stranger");
		jbmsr3=new JButton("blackpeople");
		
		jpmsr2=new JPanel(new BorderLayout());
		jpmsr2_2=new JPanel(new GridLayout(20,1,4,4));
		//��Jp2_2��ʼ��50������
		JLabel []jbls2=new JLabel[20];
		for(int i=0;i<jbls2.length;i++){
			jbls2[i]=new JLabel(i+1+"",new ImageIcon("images/mm.jpg"),JLabel.LEFT);
			jbls2[i].addMouseListener(this);
			jpmsr2_2.add(jbls2[i]);
		}
		jpmsr3=new JPanel(new GridLayout(2,1));
		
		jpmsr3.add(jbmsr1);
		jpmsr3.add(jbmsr2);
		
	
		jsp2=new JScrollPane(jpmsr2_2);
	
		jpmsr2.add(jpmsr3,"North");
		jpmsr2.add(jsp2,"Center");
		jpmsr2.add(jbmsr3,"South");
		
		cl=new CardLayout();
		this.setLayout(cl);
		this.add(jp2,"1");
		this.add(jpmsr2,"2");
		
		
		
		this.setSize(230,500);
		this.setLocation(350,100);
		this.setTitle(owerId);  //�ڴ�����ʾ�Լ��ı��
		this.setIconImage(new ImageIcon("images/qq.gif").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb2){  //�������˵ڶ��ſ�Ƭ
			cl.show(this.getContentPane(), "2");	
		}if(e.getSource()==jbmsr1){
			cl.show(this.getContentPane(), "1");	
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {

	}
	@Override
	public void mousePressed(MouseEvent e) {
		//��Ӧ�û�˫�����¼� �����õ����ѵı��
		if(e.getClickCount()==2){
			String friendNo=((JLabel)e.getSource()).getText();
			System.out.println("����Ҫ��˭�����أ�" +friendNo);
			new QqChat(this.ower,friendNo);
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(Color.green);
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(Color.black);
		
	}

}
