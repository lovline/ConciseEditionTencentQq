package com.qq.server.model;
/**
 * ����QQ������
 * �������ŵȴ�ĳ��QQ�ͻ�������������
 * @author Administrator
 *
 */
import javax.swing.*;

import com.qq.common.Message;
import com.qq.common.User;

import java.net.*;
import java.io.*;
import java.awt.*;
public class MyQqServer {

	
	public static void main(String[] args) {
		MyQqServer mqs=new MyQqServer();

	}
	public MyQqServer(){
		try {
			System.out.println("���Ƿ������������������������");
			ServerSocket ss=new ServerSocket(8888);
			while(true){
				Socket s=ss.accept();  //�����ȴ��ͻ�������
				//���ܿͻ��˷�������Ϣ
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				User u =(User) ois.readObject();
				System.out.println("fuwuqi"+u.getUserId()+u.getPasswd());
				Message m = new Message();
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				if(u.getPasswd().equals("123456")){
					//����һ���ɹ���½����Ϣ��
					m.setMesType("1");
					oos.writeObject(m);
					
					//����͵���һ���̣߳��ø��߳���ÿͻ��˱���ͨѶ��
					SerConClientThread scct = new SerConClientThread(s);
					//������ÿͻ���ͨѶ���߳�
					scct.start();
					
				}else{
					m.setMesType("2");
					oos.writeObject(m);
					//�ر�����
					s.close();
				}
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
