package com.ziroom.mytesla.resources.client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.Boundary;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.springframework.context.annotation.Scope;

import com.ziroom.mytesla.business.room.model.Room;
import com.ziroom.mytesla.common.MyException;
import com.ziroom.platform.tesla.client.TeslaClientFactory;
import com.ziroom.platform.tesla.config.TeslaConfigurationFactory;


/**
 * ClientResource
 * Date: 16/3/16
 * Time: 下午6:14
 *
 * @author tiany82@ziroom.com
 */
@Path("/client")
@Scope("request")
public class ClientResource {
    private static Client client;
    static {
        ClientConfig config = new ClientConfig();
        config.register(MultiPartFeature.class);
        client = TeslaClientFactory.newDynamicClient("mytesla", config);

    }

    @Context
    UriInfo uriInfo;
    /**
     * 基本GET调用
     * @return
     */
    @GET
    @Path("hello")
    @Produces({"text/plain"})
    public Response helloTesla() {
        WebTarget target = client.target("t2");
        String result = target.request().get(String.class);
        return Response.ok(result).build();
    }

    /**
     * 从uri获取参数
     * @param roomId
     * @return
     */
    @GET
    @Path("room/{roomId}")
    @Produces({"application/json"})
    public Response getRoomByPathParam(@PathParam("roomId") String roomId) {
        WebTarget target = client.target("room").path(roomId);

        Room result = target.request().get(Room.class);
        return Response.ok(result).build();
    }

    /**
     * 从HTTP query parameter中获取参数
     * @param roomId
     * @return
     */
    @GET
    @Path("room")
    @Produces("application/json")
    public Response getRoomByQueryParam(@QueryParam("roomId") String roomId) {
        WebTarget target = client.target("room").queryParam("roomId", roomId);
        String result = target.request().get(String.class);
        return Response.ok(result).build();
    }

    /**
     * post 传参
     * @param roomId
     * @return
     */
    @POST
    @Path("add_queryParam")
    @Produces("text/plain")
    public String addRoomPostQueryParam(@QueryParam("roomId") String roomId,
                                        @QueryParam("lon") long newLon,
                                        @QueryParam("lat") long newLat){
        WebTarget target = client.target("add_queryParam")
                .queryParam("roomId", roomId).queryParam("lon", newLon).queryParam("lat", newLat);
        Response response = target.request().post(Entity.json("null"));
        return response.readEntity(String.class);
    }

    /**
     * post 传form表单
     * @param roomId
     * @return
     */
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    @Path("add_formParam")
    public Room addRoomPostFormParam(@FormParam("roomId") String roomId,
                                     @FormParam("lon") String newLon,
                                     @FormParam("lat") String newLat) {
        WebTarget target = client.target("add_formParam");
        Form form = new Form();
        form.param("roomId", roomId);
        form.param("lon", newLon);
        form.param("lat", newLat);
        Response response = target.request().post(Entity.form(form));
        return response.readEntity(Room.class);
    }

    /**
     * post 传requestBody
     * @param room
     * @return
     */
    @POST
    @Consumes("application/json")
    @Path("add_requestBody")
    public boolean addRoomPostRequestBody(Room room) {
        WebTarget target = client.target("add_requestBody");
        Response response = target.request().post(Entity.entity(room, MediaType.APPLICATION_JSON_TYPE));
        return response.readEntity(boolean.class);
    }

    /**
     * put 传参
     * @param roomId
     * @return
     */
    @PUT
    @Path("update_queryParam")
    @Produces("text/plain")
    public String updateRoomPutQueryParam(@QueryParam("roomId") String roomId,
                                       @QueryParam("lon") long newLon,
                                       @QueryParam("lat") long newLat){
        WebTarget target = client.target("update_queryParam")
                .queryParam("roomId", roomId).queryParam("lon", newLon).queryParam("lat", newLat);
        Response response = target.request().put(Entity.json("测试"));
        return response.readEntity(String.class);
    }

    /**
     * put 传form表单
     * @param roomId
     * @return
     */
    @PUT
    @Consumes("application/x-www-form-urlencoded")
    @Path("update_formParam")
    public Room updateRoomPutFormParam(@FormParam("roomId") String roomId,
                                    @FormParam("lon") String newLon,
                                    @FormParam("lat") String newLat) {
        WebTarget target = client.target("update_formParam");
        Form form = new Form();
        form.param("roomId", roomId);
        form.param("lon", newLon);
        form.param("lat", newLat);
        Response response = target.request().put(Entity.form(form));
        return response.readEntity(Room.class);
    }

    /**
     * put 传requestBody
     * @param roomId
     * @return
     */
    @PUT
    @Path("update_requestBody")
    public boolean updateRoomPutRequestBody(String roomId) {
        WebTarget target = client.target("update_requestBody");
        Response response = target.request().put(Entity.entity(roomId, MediaType.APPLICATION_JSON_TYPE));
        return response.readEntity(boolean.class);
    }

    /**
     * 删除
     * @param roomId
     * @return
     */
    @DELETE
    @Path("deleteRoom")
    public boolean deleteRoom(@QueryParam("roomId") String roomId) {
        WebTarget target = client.target("deleteRoom").queryParam("roomId", roomId);
        Response response = target.request().delete();
        return response.readEntity(boolean.class);
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
        WebTarget target = client.target("createRoom").queryParam("error", error);
        Response response = target.request().post(Entity.entity(room, MediaType.APPLICATION_JSON_TYPE));
        if(response.getStatus() == 200) {
            return response.readEntity(Room.class);
        }
        else {
            throw new MyException();
        }
    }

    /**
     * 设置动态mediaType
     * @return
     */
    @POST
    @Path("room_mediaType")
    public Room getRoomJsonProtostuffResponse() {
        boolean jsonType = TeslaConfigurationFactory.getInstance().getBoolean("jsonType", false);
        String mediaType = "application/x-protostuff";
        if (jsonType) {
            mediaType = MediaType.APPLICATION_JSON;
        }
        WebTarget target = client.target("room_mediaType");
        Response response = target.request(mediaType).post(null);
        return response.readEntity(Room.class);
    }

    /**
     * 返回json格式
     * @return
     */
    @GET
    @Path("rooms")
    @Produces("application/json")
    public List<Room> getRooms() {
        WebTarget target = client.target("rooms");
        List<Room> result = target.request().get(new ArrayList<Room>().getClass());
        return result;
    }

    /**
     * 测试MyException
     * @param param
     * @return
     */
    @GET
    @Path("testException")
    public Response testMyException(@QueryParam("a") String param) {
        WebTarget target = client.target("testException").queryParam("a", param);
        Response response = target.request().get();
        if (response.getStatus() == 200) {
            Response.ok(response.readEntity(String.class));
        }
        throw new MyException();
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
        WebTarget target = client.target("updateRoom/" + roomId + "/" + newRoomId);
        String result = target.request().get(String.class);
        return Response.ok(result).build();
    }

    /**
     * 接收form表单多类型参数
     * @return
     * @throws IOException
     */
    @POST
    @Path("file")
    public Response uploadFile() throws IOException {
        FileDataBodyPart bodyPart=new FileDataBodyPart("file",new File("/Users/denya/Documents","myfile.txt"));

        FormDataMultiPart formDataMultiPart=new FormDataMultiPart();
        formDataMultiPart.field("fileDescription", "testUploadFile").bodyPart(bodyPart);

        WebTarget target = client.target("file");

        MediaType type = Boundary.addBoundary(formDataMultiPart.getMediaType());

        final Response response = target.request().post(Entity.entity(formDataMultiPart, type));
        return Response.ok(response.readEntity(String.class)).build();
    }
}
