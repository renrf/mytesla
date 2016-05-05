package com.ziroom.mytesla.business.room.dao;

import org.springframework.stereotype.Repository;

import com.ziroom.mytesla.business.room.model.Room;

/**
 * 数据接口
 * @author: liuxm
 * @email:  liuxm7@ziroom.com
 * @date:   2016-02-19 16:26:28
 * @since 1.0.0
 */
@Repository
public interface IRoomDao {
	
	/**
	 * 根据roomCode查询对个对象
	 * <p><b>注意：</b><br>
	 * </p>
	 * <p>
	 * <b>变更记录：</b><br>
	 * </p>
	 * @param roomCodes
	 * @return
	 * @author: shihy 
	 * @date:2016年2月22日 上午11:39:59
	 * @since 1.0.0
	 */
	public Room findRoom(Integer id) ;

}