package com.qq.client.model;
/**
 * ���ǿͻ����ӷ������ĺ�̨
 * @author Administrator
 *
 */
import java.util.*;
import java.net.*;
import java.io.*;

import com.qq.common.Message;
import com.qq.common.User;

public class QqClientConServer implements java.io.Serializable{

	public static Socket  s;
	
	//���͵�һ������
	public boolean SendLoginInfoToServer(Object o){
		boolean flag = false;
		try {
			//System.out.println("******");
			s=new Socket("127.0.0.1",8888);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message ms =(Message)ois.readObject();
			if(ms.getMesType().equals("1")){
				flag = true;
			}else{
				flag = false;	
			}
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
		}
		return flag;
	}
	
}
