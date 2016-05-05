package com.ziroom.mytesla.common.rest;

import com.ziroom.platform.tesla.server.BaseTeslaApplication;
import io.swagger.jaxrs.config.BeanConfig;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

public class RestDemoJaxRsApplication extends BaseTeslaApplication {

	/**
	 * Register JAX-RS application components.
	 */ 
	public RestDemoJaxRsApplication() {
		super();

		//must have this line
		packages("com.ziroom.platform.samplesvc.resource",
				 "com.ziroom.platform.samplesvc.resource.client",
				 "com.ziroom.platform.samplesvc.resource.server");
		
		register(XmlBeanMessageBodyWriter.class);
		register(MultiPartFeature.class);

		register(io.swagger.jaxrs.listing.ApiListingResource.class);
		register(io.swagger.jaxrs.listing.SwaggerSerializers.class);

		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/");
		beanConfig.setResourcePackage("com.ziroom.platform.samplesvc.resource.server");
		beanConfig.setScan(true);
	}

	public static void main(String[] args) {
		new RestDemoJaxRsApplication();
	}
}
