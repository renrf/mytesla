package com.ziroom.mytesla.resources.server;

/**
 * ServerResource
 * Date: 16/3/16
 * Time: 下午6:14
 *
 * @author tiany82@ziroom.com
 */

import io.swagger.annotations.Api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ziroom.mytesla.business.room.model.Room;
import com.ziroom.mytesla.common.MyException;

@Component
@Path("/")
@Scope("request")
@Api
public class ServerResource {
    private static Logger logger = LoggerFactory.getLogger(ServerResource.class);

    @Value("${cc.name}")
    private String name;

    @Value("${fail.hello}")
    private boolean failHello;


    @Value("${sleep.time}")
    private long sleepTime;

    @Context
    UriInfo ui;
    @Context
    HttpHeaders hh;

    @Context
    Request request;


    /**
     * 基本GET调用
     * @return
     */
    @GET
    @Path("hello")
    @Produces({"text/plain"})
    public Response helloTesla() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(sleepTime);
        if(failHello) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("hello").build();
        }
        return Response.ok("hello tesla").build();
    }

    /**
     * 从uri获取参数
     * @param roomId
     * @return
     */
    @GET
    @Path("room/{roomId}")
    @Produces({"application/json"})
    public Room getRoomByPathParam(@PathParam("roomId") String roomId) {
        try {
            Room room = new Room();
            room.setRoomName(roomId);
            logger.info("查询房间信息（plain result）成功！");
            return room;
        } catch (Exception e) {
            logger.error("查询房间信息失败！", e);
            return null;
        }
    }

    /**
     * 从HTTP query parameter中获取参数
     * @param roomId
     * @return
     */
    @GET
    @Path("room")
    @Produces("application/json")
    public Room getRoomByQueryParam(@QueryParam("roomId") String roomId) {
        Room room = new Room();
        room.setName(roomId);
        room.setLon(1l);
        room.setLat(1l);
        return room;
    }

    /**
     * add with queryParam
     * @param roomId
     * @return
     */
    @POST
    @Path("add_queryParam")
    @Produces("application/json")
    public Room addRoomPostQueryParam(@QueryParam("roomId") String roomId, @QueryParam("lon") long newLon, @QueryParam("lat") long newLat){
        Room room = new Room();
        room.setName(roomId);
        room.setLon(newLon);
        room.setLat(newLat);
        return room;
    }

    /**
     * add with formParam
     * @param roomId
     * @return
     */
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Path("add_formParam")
    public Room addRoomPostForm(@FormParam("roomId") String roomId, @FormParam("lon") long newLon, @FormParam("lat") long newLat) {
        Room room = new Room();
        room.setName(roomId);
        room.setLon(newLon);
        room.setLat(newLat);
        return room;
    }

    /**
     * add with requestBody
     * @param room
     * @return
     */
    @POST
    @Path("add_requestBody")
    public boolean addRoomPostRequestBody(Room room) {
        return true;
    }

    /**
     * update with queryParam
     * @param roomId
     * @return
     */
    @PUT
    @Path("update_queryParam")
    @Produces("application/json")
    public Room updateRoomPutQueryParam(@QueryParam("roomId") String roomId, @QueryParam("lon") long newLon, @QueryParam("lat") long newLat){
        Room room = new Room();
        room.setName(roomId);
        room.setLon(newLon);
        room.setLat(newLat);
        return room;
    }

    /**
     * update with formParam
     * @param roomId
     * @return
     */
    @PUT
    @Consumes("application/x-www-form-urlencoded")
    @Path("update_formParam")
    public Room updateRoomPutForm(@FormParam("roomId") String roomId, @FormParam("lon") long newLon, @FormParam("lat") long newLat) {
        Room room = new Room();
        room.setName(roomId);
        room.setLon(newLon);
        room.setLat(newLat);
        return room;
    }

    /**
     * update with requestBody
     * @param room
     * @return
     */
    @PUT
    @Path("update_requestBody")
    public boolean updateRoomPutRequestBody(Room room) {
        return true;
    }

    /**
     * delete
     * @param queryParamId
     * @return
     */
    @DELETE
    @Path("deleteRoom")
    public boolean deleteRoom(@QueryParam("queryParamId") String queryParamId) {
        return true;
    }


    /**
     * 对参数进行校验
     * @param room
     * @param error
     * @return
     */
    @POST
    @Path("createRoom")
    @Consumes("application/json")
    @Produces("application/json")
    public Room createRoom(@Valid @NotNull Room room, @QueryParam("error") Boolean error) {
        if(error != null && error) {
            throw new MyException();
        }
        try {
        	room.setId(1);
            logger.info("# RoomResource ## createRoom # 添加房间信息成功！");
            return room;
        } catch (Exception e) {
            logger.error("# RoomResource ## createRoom # 添加房间信息失败！", e);
            throw new MyException();
        }
    }

    /**
     * 返回json格式
     * @return
     */
    @GET
    @Path("rooms")
    @Produces("application/json")
    public List<Room> getRooms() {
        logger.info("the absolute path of the request：" + ui.getAbsolutePath());
        logger.info("Content-Length value：" + hh.getLength());
        logger.info("the request method：" + request.getMethod());
        try {
            List<Room> rooms = new ArrayList<Room>();
            Room r1 = new Room();
            r1.setId(1);
            rooms.add(r1);
            Room r2 = new Room();
            r2.setId(2);
            rooms.add(r2);
            
            logger.info("# RoomResource ## getRoomJsonParam # 查询房间列表成功！");
            return rooms;
        } catch (Exception e) {
            logger.error("# RoomResource ## getRoomJsonParam # 查询房间列表失败！", e);
            return null;
        }
    }

    /**
     * 设置动态mediaType
     * @return
     */
    @POST
    @Path("room_mediaType")
    @Produces({"application/x-protostuff", "application/json"})
    public Room getRoomJsonProtostuffResponse() {
        Room room = new Room();
        room.setLat(1l);
        room.setLon(1l);
        String mediaType = "application/x-protostuff";
        room.setName(mediaType);
//        boolean jsonType = TeslaApplicationConfiguration.getInstance().getBoolean("jsonType", false);
//        if (jsonType) {
//            mediaType = MediaType.APPLICATION_JSON;
//            room.setName(mediaType);
//        }
        return room;
    }

    /**
     * 测试MyException
     * @param param
     * @return
     */
    @GET
    @Path("testException")
    @Produces({"application/json", "application/x-protostuff"})
    public Response testMyException(@QueryParam("a") String param) {
        if (param == null || "".equals(param)) {
            throw new MyException();
        }
        if("unknown".equals(param)) {
            throw new RuntimeException("dddd");
        }
        return Response.ok("xx").build();
    }

    /**
     * 从访问路径中获取多个参数
     * @param roomId
     * @param newRoomId
     * @return
     */
    @GET
    @Path("updateRoom/{roomId}/{newRoomId}")
    public Response updateRoom(@PathParam("roomId") String roomId, @PathParam("newRoomId") String newRoomId) {
        try {
        	
        	return Response.ok().entity("ok").build();
        } catch (Exception e) {
            logger.error("# RoomResource ## updateRoom # 更新房间信息失败！", e);
            return Response.serverError().entity("error").build();
        }
    }

    /**
     * 接收form表单多类型参数 && 文件上传
     * @param multiPart
     * @return
     * @throws IOException
     */
    @POST
    @Path("file")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("text/plain")
    public String uploadFile(FormDataMultiPart multiPart) throws IOException {
        OutputStream writer = null;
        InputStream reader = null;
        try{
            //解析String类型参数fileDescription
            FormDataBodyPart fileDescriptionPart = multiPart.getField("fileDescription");
            String fileDescription = fileDescriptionPart.getValue();
            //解析File类型参数file
            FormDataBodyPart filePart = multiPart.getField("file");

            File file = filePart.getValueAs(File.class);
            InputStream fileIs = filePart.getValueAs(InputStream.class);
            File newFile = new File("D:\\", "newexcel.xlsx");
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
//            reader = new BufferedReader(new FileReader(file));
            reader = new BufferedInputStream(fileIs);
            writer = new BufferedOutputStream(new FileOutputStream(newFile));
            
            String mimeType = filePart.getMediaType().toString();
            System.out.println("file description:" + fileDescription);
            System.out.println("file mimeType:" + mimeType);
            String line;
            
            byte[] readArray = new byte[1024];// 用来存储每次读取到的字节数组  
            int n;// 每次读取到的字节数组的长度  
            while ((n = reader.read(readArray)) != -1) {  
                writer.write(readArray, 0, n);// 写入到输出流  
            }  
//            while ((line = reader.readLine()) != null) {
//                writer.write(line + "\n");
//            }
            writer.flush();
            return "upload success";
        } catch (Exception e) {
            logger.error("upload error", e);
            return "upload error：" + e.getMessage();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
            multiPart.cleanup();
        }
    }

}
