package com.example.websocket.dao;

import com.example.websocket.model.Message;
import com.sun.corba.se.spi.ior.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: zhangyanlong
 * @Date: 2019/7/1 21:26
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {

    /**
     * 查询点对点聊天记录
     * nativeQuery : 使用本地sql的方式查询
     * @param fromId
     * @param toId
     * @param page
     * @param rows
     * @return
     */
    @Query(value="from message where from_id=?1 and to_id=?2")
    List<Message> findListByFromAndTo(int fromId, int toId, Integer page, Integer rows);

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    Message findMessageById(String id);

    /**
     * 更新消息状态
     *
     * @param id
     * @param status
     * @return
     */
    @Query(value="update message set status=?2 where id=?1")
    void updateMessageState(int id, Integer status);

    /**
     * 新增消息数据
     * <p>
     * }
     *
     * @param message
     * @return
     */
//    Message saveMessage(Message message);

    /**
     * 根据消息id删除数据
     *
     * @param id
     * @return
     */
//    DeleteResult deleteMessage(String id);
}
