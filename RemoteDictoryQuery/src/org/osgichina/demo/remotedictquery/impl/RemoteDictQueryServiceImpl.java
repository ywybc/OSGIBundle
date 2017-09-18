package org.osgichina.demo.remotedictquery.impl;

import java.util.concurrent.ConcurrentHashMap;

import org.osgichina.demo.dictquery.query.QueryService;

public class RemoteDictQueryServiceImpl implements QueryService{
  private static final ConcurrentHashMap<String, String> dict=new ConcurrentHashMap<>();
  static{
	  dict.put("sky", "���");
	  dict.put("computer", "�����");
  }
  /*
   * ��Զ�̵��ֵ��ϲ�ѯ
   */
	@Override
	public String queryWord(String word) {
		// TODO Auto-generated method stub
		System.out.println("RemoteDictoryQueryServiceImpl.queryword called!");
		String result=dict.get(word);
		if (result==null) {
			result="N/A";
		}
		return result;
	}

}
