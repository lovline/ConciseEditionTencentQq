package com.qq.client.tools;
/**
 * ����һ������ͻ��˺ͷ���������ͨѶ���߳���
 * @author Administrator
 */
import java.net.*;
import java.util.HashMap;
import java.io.*;

public class ManageClientConServerThread {

		 private static HashMap hm = new HashMap<String, ClientConServerThread>();
		 //�ɴ����õ�ClientConServerThread���뵽hm��ȥ
		 public static void addClientConServerThread(String qqid,ClientConServerThread ccst){
			 hm.put(qqid, ccst);
		 }
		 //����ͨ��qqIdȡ�ø��߳�
		 public  static ClientConServerThread getClientConServerThread(String qqId){
			return  (ClientConServerThread) hm.get(qqId);
		 }
		 
}
