package com.qq.server.view;

import javax.swing.*;

import com.qq.server.model.MyQqServer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * ���Ƿ������Ŀ��ƽ���
 * ���������� �رշ�����
 * ���Թ���ͼ�������û���¼
 * @author Administrator
 *
 */
public class MyServerFrame extends JFrame implements ActionListener{

	JPanel jp1,jp2;
	JButton jb1,jb2;
	
	public static void main(String[] args) {
		MyServerFrame msf=new MyServerFrame();

	}
	public MyServerFrame(){
		jp1=new JPanel();
		jb1=new JButton("����������");
		jb1.addActionListener(this);
		jb2=new JButton("�رշ�����");
		jp1.add(jb1);
		jp1.add(jb2);
		
		this.add(jp1);
		this.setSize(500,400);
		this.setLocation(300,200);
		this.setTitle("lovline����");
		this.setIconImage(new ImageIcon("images/qq.gif").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			new MyQqServer();
		}
		
	}

}
