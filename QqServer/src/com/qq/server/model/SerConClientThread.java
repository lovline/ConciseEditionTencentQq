package com.qq.server.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.qq.common.Message;

/**
 * �����Ƿ�������ĳ���ͻ����̵�ͨѶ�߳�
 * @author Administrator
 */
public class SerConClientThread extends Thread {

	Socket s;
	
	public SerConClientThread(Socket s){
		//�ѷ�������ÿͻ��˵����Ӹ���S
		this.s = s;
	}
	
	public void run(){
		while(true){
			//������߳̾Ϳ��Խ��ܿͻ��˵���Ϣ
			
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message m = (Message) ois.readObject();
				System.out.println(m.getSender()+m.getGetter()+m.getContent());
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
			}
		}
	}
	
}
