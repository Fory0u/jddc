package com.neusoft.base.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.vo.User;

public class ConversationFilter implements Filter {

	private static final String[] ignoreUrl = new String[] {
			"/bgUser.do?isLogin", "/hospital", "/pnindex.jsp", "/news",
			"/comRe", "/pnlogin.jsp", "/comUser.do?isLogin",
			"/comUser.do?isExistByUserAcct", "/comUser.do?addComUser",
			"/comUser.do?isLogin", "/comUser.do?indexQd" };

	public void init(FilterConfig arg0) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		res.addHeader("x-frame-options", "SAMEORIGIN");
		if (isIntercept(req)) {
			// ajax请求
			if (req.getHeader("x-requested-with") != null
					&& req.getHeader("x-requested-with").equalsIgnoreCase(
							"XMLHttpRequest")) {
				res.sendError(403);
				return;
			} else {
				res.sendRedirect(req.getContextPath());
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	private boolean isIntercept(HttpServletRequest req) {
		String requestUrl = req.getRequestURL().toString();
		String queryString = req.getQueryString();
		if (queryString != null && queryString.length() > 0) {
			requestUrl += "?" + queryString;
		}
		String contextPath = req.getContextPath();
		requestUrl = requestUrl.substring(requestUrl.indexOf(contextPath)
				+ contextPath.length());

		if (requestUrl.indexOf(".do") >= 0 || requestUrl.indexOf(".jsp") >= 0) {
			if (requestUrl.indexOf(ignoreUrl[0]) >= 0
					|| requestUrl.indexOf(ignoreUrl[1]) >= 0
					|| requestUrl.indexOf(ignoreUrl[2]) >= 0
					|| requestUrl.indexOf(ignoreUrl[3]) >= 0
					|| requestUrl.indexOf(ignoreUrl[4]) >= 0
					|| requestUrl.indexOf(ignoreUrl[5]) >= 0
					|| requestUrl.indexOf(ignoreUrl[6]) >= 0
					|| requestUrl.indexOf(ignoreUrl[7]) >= 0
					|| requestUrl.indexOf(ignoreUrl[8]) >= 0
					|| requestUrl.indexOf(ignoreUrl[9]) >= 0
					|| requestUrl.indexOf(ignoreUrl[10]) >= 0) {
				return false;
			} else {
				HttpSession session = req.getSession(true);
				User loginCustomer = (User) session.getAttribute("loginUser");
				if (null == loginCustomer) {
					return true;
				}
			}
		} else {
			return false;
		}
		return false;
	}

	public void destroy() {
	}

}
