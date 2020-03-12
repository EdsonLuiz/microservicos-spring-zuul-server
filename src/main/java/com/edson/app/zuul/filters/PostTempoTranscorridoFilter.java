package com.edson.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTempoTranscorridoFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(PostTempoTranscorridoFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		log.info("Filtro post");
		
		long tempoDeInicio = (Long)request.getAttribute("tempoInicio");
		long tempoDeTermino = System.currentTimeMillis();
		Long tempoTotal = tempoDeTermino - tempoDeInicio;

		log.info(String.format("Tempo trancorrido em segundo %s", tempoTotal.doubleValue()/1000.00));
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
