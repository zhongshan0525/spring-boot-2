package com.example.batch.model;

/**
 * @author zhangYanLong
 */
@Data
@Entity(name = "sys_log")
public class SysLog implements Serializable {

    private static final long serialVersionUID = -8328474704034994000L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String operation;
    private Integer time;
    private String method;
    private String params;
    private String ip;
    private Date createTime;
}