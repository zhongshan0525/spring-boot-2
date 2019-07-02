package com.example.websocket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "message")
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String msg;
    /**
     * 消息状态，1-未读，2-已读
     */
    private Integer status;

    @Column(name = "send_date")
    private Date sendDate;

    @Column(name = "read_date")
    private Date readDate;

    @Column(name = "from_id")
    private int fromId;

    @Column(name = "to_id")
    private int toId;
}