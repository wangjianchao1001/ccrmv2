package com.ccrm.listener;

import java.text.SimpleDateFormat;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ccrm.util.AppConfig;


/**
 * 系统监控类 
 * @author 
 * 实现加载配置文件 
 */
public class InitListener implements ServletContextListener {
	private static final Logger log = LoggerFactory
			.getLogger(InitListener.class);
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void contextDestroyed(ServletContextEvent arg0) { 
		log.info("【管理系统  关闭】");
	}
	public void contextInitialized(ServletContextEvent arg0) {		
		log.info("【管理系统   启动】");
		AppConfig.loadSetupProperties(arg0.getServletContext().getRealPath("/")	+ "/WEB-INF/appconfig.xml");		
	}
}
