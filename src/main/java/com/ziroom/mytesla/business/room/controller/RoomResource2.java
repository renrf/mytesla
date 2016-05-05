package com.ziroom.mytesla.business.room.controller;

import com.ziroom.platform.tesla.config.ApplicationConfiguration;
import com.ziroom.platform.tesla.config.TeslaConfigurationFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * This bean is request scope, so spring will create an instance in every request processing
 * and also set the `your.name` every time. if this entry changed, then all request afterward
 * will use the new value(Dynamic config)
 */
@Component
@Path("/")
@Scope("request")
public class RoomResource2 {
    @Value("${your.name}")
    private String yourName;

    @GET
    @Produces({"text/plain"})
    @Path("t2.html")
    public String testTesla() {
        ApplicationConfiguration configuration = TeslaConfigurationFactory.getInstance();
        return "hello " + configuration.getString("your.name", "j") + " and " + this.yourName;
    }


}

