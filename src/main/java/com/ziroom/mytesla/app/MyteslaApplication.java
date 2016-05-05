package com.ziroom.mytesla.app;
import io.swagger.jaxrs.config.BeanConfig;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.ziroom.mytesla.common.rest.XmlBeanMessageBodyWriter;
import com.ziroom.platform.tesla.server.BaseTeslaApplication;

public class MyteslaApplication extends BaseTeslaApplication {
    public MyteslaApplication() {
    	super();
    	
        packages("com.ziroom.mytesla.resources","com.ziroom.mytesla.business");
        
        register(XmlBeanMessageBodyWriter.class);
		register(MultiPartFeature.class);

		register(io.swagger.jaxrs.listing.ApiListingResource.class);
		register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/mytesla");
		beanConfig.setTitle("tesla test");
		beanConfig.setResourcePackage("com.ziroom.mytesla.resources.client");
		beanConfig.setScan(true);
    }
}