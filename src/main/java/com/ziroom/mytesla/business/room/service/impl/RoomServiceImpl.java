package com.ziroom.mytesla.business.room.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ziroom.mytesla.business.room.dao.IRoomDao;
import com.ziroom.mytesla.business.room.model.Room;
import com.ziroom.mytesla.business.room.service.IRoomService;

/**
 * 业务实现
 * 
 * @author: liuxm
 * @email: liuxm7@ziroom.com
 * @date:2015年11月16日 上午11:54:24
 * @since 1.0.0
 */
@Service
public class RoomServiceImpl implements IRoomService {
	@Resource
	private IRoomDao roomDao;
	
	public Room query(Integer roomId){
		return roomDao.findRoom(roomId);
	}
}
