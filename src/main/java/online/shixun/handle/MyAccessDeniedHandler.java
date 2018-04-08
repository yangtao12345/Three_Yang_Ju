package online.shixun.handle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class MyAccessDeniedHandler implements AccessDeniedHandler{
	private String accessDeniedHandlerUrl;
	public String getAccessDeniedHandlerUrl() {
		return accessDeniedHandlerUrl;
	}
	public void setAccessDeniedHandlerUrl(String accessDeniedHandlerUrl) {
		this.accessDeniedHandlerUrl = accessDeniedHandlerUrl;
	}
	public MyAccessDeniedHandler(){
		
	}
	public MyAccessDeniedHandler(String accessDeniedHandler){}
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
			throws IOException, ServletException {
		response.sendRedirect(accessDeniedHandlerUrl);
		
	}

}
