package org.osgichina.demo.localdictquery.impl;

import java.util.concurrent.ConcurrentHashMap;

import org.osgichina.demo.dictquery.query.QueryService;

public class LocalDictQueryServiceImpl implements QueryService {
private static final ConcurrentHashMap<String, String> dict=new ConcurrentHashMap<>();
static{
	dict.put("test", "测试");
	dict.put("China", "中国");
	dict.put("Beijing", "北京");
}
	@Override
	/*从本地的字典中查询，查到就返回，查不到就返回"N/A"
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
