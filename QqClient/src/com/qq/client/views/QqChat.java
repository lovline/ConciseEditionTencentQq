package com.qq.client.views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.*;

import com.qq.client.model.QqClientConServer;
import com.qq.common.Message;

/**
 * �������������Ľ���
 * @author Administrator
 *
 */
public class QqChat extends JFrame implements ActionListener{

	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	String owerId;
	String friendId;
	
	public static void main(String[] args) {
		//QqChat qqc=new QqChat("");

	}
	public QqChat(String owerId,String friend){
		
		this.owerId = owerId;
		this.friendId = friend;
		
		jta=new JTextArea();
		jtf=new JTextField(18);
		jb=new JButton("����");
		jb.addActionListener(this);
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta);
		this.add(jp,"South");
		
		this.setSize(350,270);
		this.setLocation(500,150);
		this.setTitle(owerId+"�������ں�"+ friend +"��������");
		this.setIconImage(new ImageIcon("images/qq.gif").getImage());
		this.setResizable(false);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb){
			//����û�����˷��Ͱ�ť��
			Message m = new Message();
			m.setSender(this.owerId);
			m.setGetter(this.friendId);
			m.setContent(jtf.getText());
			m.setSendTime(new Date().toString()); 
			//���͸�������
			try {
				ObjectOutputStream oos = new ObjectOutputStream(QqClientConServer.s.getOutputStream());
				oos.writeObject(m);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
		}
		
	}

}
