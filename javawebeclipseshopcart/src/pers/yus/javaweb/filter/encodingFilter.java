package pers.yus.javaweb.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;

@WebFilter(value = "/*",
dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST},
initParams = {
		@WebInitParam(name = "encoding",value = "utf-8")
}
)
public class encodingFilter implements Filter
{
	private String encoding;
	FilterConfig fc;
	public encodingFilter()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		// TODO Auto-generated method stub
		this.encoding = fc.getInitParameter("encoding");
		System.out.println("encoding初始化参数的值为：" + this.encoding);
		HttpServletResponse response2 = (HttpServletResponse)response;
		response2.setContentType("text/html;charset="+this.encoding);
		request.setCharacterEncoding(this.encoding);
		chain.doFilter(request, response);
		
	}
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException{
		this.fc = fConfig;
	}

}
