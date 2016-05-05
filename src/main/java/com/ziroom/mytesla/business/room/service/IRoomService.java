package com.ziroom.mytesla.business.room.service;

import com.ziroom.mytesla.business.room.model.Room;


/**
 * 业务接口
 * @author: liuxm
 * @email:  liuxm7@ziroom.com
 * @date:2015年11月16日 上午10:15:21
 * @since 1.0.0
 */
public interface IRoomService {
	public Room query(Integer roomId);
}
