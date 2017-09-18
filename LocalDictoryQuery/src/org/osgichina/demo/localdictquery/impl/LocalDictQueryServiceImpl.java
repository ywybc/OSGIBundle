package org.osgichina.demo.localdictquery.impl;

import java.util.concurrent.ConcurrentHashMap;

import org.osgichina.demo.dictquery.query.QueryService;

public class LocalDictQueryServiceImpl implements QueryService {
private static final ConcurrentHashMap<String, String> dict=new ConcurrentHashMap<>();
static{
	dict.put("test", "����");
	dict.put("China", "�й�");
	dict.put("Beijing", "����");
}
	@Override
	/*�ӱ��ص��ֵ��в�ѯ���鵽�ͷ��أ��鲻���ͷ���"N/A"
	 */
	public String queryWord(String word) {
		// TODO Auto-generated method stub
		System.out.println("LocalDictQueryServiceImpl.queryWord called!");
		String result=dict.get(word);
		if (result==null) {
			result="N/A";
		}
		return result;
	}

}
