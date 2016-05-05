package com.ziroom.mytesla.business.room.model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * Room实体
 * @author: liuxm
 * @email:  liuxm7@ziroom.com
 * @date:   2016-02-19 16:26:28
 * @since 1.0.0
 */
@XmlRootElement
public class Room {
	
	private String name;
	private Long lon;
	private Long lat;
	//主键
	private Integer id;
	//房源编号
	private String houseCode;
	//房间code
	private String roomCode;
	//房间名称
	private String roomName;
	//房间类型（0卧室、1客厅、2卫生间、3厨房）
	private Integer roomTypeCode;
	//房间朝向
	private String roomDirection;
	//房间实际面积
	private Float usageArea;
	//是否有阳台（0否、1是）
	private Integer isBalcony;
	//是否是密码锁（0否、1是）
	private Integer isPwdlock;
	//是否有独立卫生间（0否、1是）
	private Integer isIndependentToilet;
	//创建人
	private String creator;
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")   
	//创建日期
	@DateTimeFormat(pattern="yyyy-MM-dd")   
	private Date createDate;
	//逻辑删除字段（0否、1是）
	private Integer isDel;
	//最后修改人
	private String lastModifier;
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")   
	//最后修改时间 
	private Date lastModifyTime;
	//房间基本价格
	private Integer roomBasicPrice;
	//房间促销价格
	private Integer roomSalesPrice;
	//房间评价
	private String evaluate;
	// 房间首图
	private Integer firstImg;
	// 房间照片
	private List<String> pictureList;
	//上下架字段（0否、1是）
	private Integer releaseStatus;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}
	
	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public Integer getRoomTypeCode() {
		return roomTypeCode;
	}

	public void setRoomTypeCode(Integer roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}
	
	public String getRoomDirection() {
		return roomDirection;
	}

	public void setRoomDirection(String roomDirection) {
		this.roomDirection = roomDirection;
	}
	
	public Float getUsageArea() {
		return usageArea;
	}

	public void setUsageArea(Float usageArea) {
		this.usageArea = usageArea;
	}
	
	public Integer getIsBalcony() {
		return isBalcony;
	}

	public void setIsBalcony(Integer isBalcony) {
		this.isBalcony = isBalcony;
	}
	
	public Integer getIsPwdlock() {
		return isPwdlock;
	}

	public void setIsPwdlock(Integer isPwdlock) {
		this.isPwdlock = isPwdlock;
	}
	
	public Integer getIsIndependentToilet() {
		return isIndependentToilet;
	}

	public void setIsIndependentToilet(Integer isIndependentToilet) {
		this.isIndependentToilet = isIndependentToilet;
	}
	
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	
	public String getLastModifier() {
		return lastModifier;
	}

	public void setLastModifier(String lastModifier) {
		this.lastModifier = lastModifier;
	}
	
	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Integer getRoomBasicPrice() {
		return roomBasicPrice;
	}

	public void setRoomBasicPrice(Integer roomBasicPrice) {
		this.roomBasicPrice = roomBasicPrice;
	}

	public Integer getRoomSalesPrice() {
		return roomSalesPrice;
	}

	public void setRoomSalesPrice(Integer roomSalesPrice) {
		this.roomSalesPrice = roomSalesPrice;
	}

	public String getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	public List<String> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<String> pictureList) {
		this.pictureList = pictureList;
	}
	public Integer getFirstImg() {
		return firstImg;
	}

	public void setFirstImg(Integer firstImg) {
		this.firstImg = firstImg;
	}

	public Integer getReleaseStatus() {
		return releaseStatus;
	}

	public void setReleaseStatus(Integer releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLon() {
		return lon;
	}

	public void setLon(Long lon) {
		this.lon = lon;
	}

	public Long getLat() {
		return lat;
	}

	public void setLat(Long lat) {
		this.lat = lat;
	}
	
}