package com.nujabness.katawemanity.services.filter;

import com.nujabness.katawemanity.services.authentification.provider.JwtTokenProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpAuthorizationFilter extends GenericFilterBean {

	private JwtTokenProvider jwtTokenProvider;

	public HttpAuthorizationFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// get token form request
		String token = jwtTokenProvider.resolveToken((HttpServletRequest) servletRequest);
		if (token != null) {
			try {
				if (jwtTokenProvider.validateToken(token)) {
					Authentication auth = jwtTokenProvider.getAuthentication(token);
					SecurityContextHolder.getContext().setAuthentication(auth);
				}
			} catch (Exception exp) {
				((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}

		}
		filterChain.doFilter(servletRequest, servletResponse);
	}
}
