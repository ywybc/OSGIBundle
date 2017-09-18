package org.osgichina.demo.dictqueryweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.osgichina.demo.dictquery.query.QueryService;
public class DictoryQueryServlet extends HttpServlet{
	
	private static final long serialVersionID=1L;
	private HttpService httpService;
	private QueryService queryService;
 public void setHttpService(HttpService httpService){
	 this.httpService=httpService;
	 try {
		httpService.registerServlet("dictoryquery", this, null, null);
		httpService.registerResources("page", "page", null);
		System.out.println("已启动字典查询响应模块，请通过/page/dictquery.html访问");
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NamespaceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 public void unsetHttpService(HttpService httpService){
	 this.httpService=httpService;
	 httpService.unregister("/demo/dictoryquery");
	 httpService.unregister("/demo/page");
	 System.out.println("已经卸载字典查询响应模块");
	 httpService=null;
 }
 public void setQueryService(QueryService queryService){
	 this.queryService=queryService;
 }
 public void unsetQueryService(QueryService queryService){
	 if (queryService!=this.queryService) {
		return;
	}
	 this.queryService=null;
 }
 
 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String queryWord=req.getParameter("query_word");
		resp.setContentType("text/html");
		ServletOutputStream oStream=resp.getOutputStream();
		if (queryService==null) {
			oStream.println("No available dictquery service");
			oStream.close();
			return;
		}
		oStream.println("Result is "+queryService.queryWord(queryWord));
		oStream.close();
		return;
	}
}
