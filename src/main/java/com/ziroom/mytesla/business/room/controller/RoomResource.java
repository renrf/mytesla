package com.ziroom.mytesla.business.room.controller;



import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ziroom.mytesla.business.room.model.Room;
import com.ziroom.mytesla.business.room.service.IRoomService;

/**
 * This bean is default(singleton) scope
 */
@Component
@Path("/tsl")
@Scope("request")
public class RoomResource {
	@Resource
	private IRoomService roomService;
	
    @GET
    @Produces({"text/plain"})
    @Path("/room")
    public String testTesla(Integer roomId) {
        System.out.print("222222222222222222222222222222");
        roomId=2;
    	Room room = roomService.query(roomId);
    	return "我是房间";
    }
}