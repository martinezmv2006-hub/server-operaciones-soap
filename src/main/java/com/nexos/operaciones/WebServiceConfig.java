package com.nexos.operaciones;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
@ComponentScan("com.nexos") 
public class WebServiceConfig extends WsConfigurerAdapter {
    // bean definitions
	
	@Bean
	public XsdSchema operacionesSchema() {
	    return new SimpleXsdSchema(
	    		new ClassPathResource("operecionesBasicas.xsd")
	    );
	}
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
	    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
	    servlet.setApplicationContext(applicationContext);
	    servlet.setTransformWsdlLocations(true);
	    return new ServletRegistrationBean(servlet, "/ws/*");
	}
	
	@Bean(name = "operaciones")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema operacionesSchema) {
	    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
	    wsdl11Definition.setPortTypeName("OperacionesPort");
	    wsdl11Definition.setLocationUri("/ws");
	    //wsdl11Definition.setTargetNamespace("http://nexos.com/gs-operaciones-web-service");
	    wsdl11Definition.setTargetNamespace("http://nexos.com/gs_operaciones_web_service");
	    wsdl11Definition.setSchema(operacionesSchema);
	    return wsdl11Definition;
	}
	 
	
}
