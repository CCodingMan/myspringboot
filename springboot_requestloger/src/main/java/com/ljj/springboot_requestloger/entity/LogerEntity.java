package com.ljj.springboot_requestloger.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Auther: ljj
 * @Date: 2019/6/16 11:19
 * @Description: 请求日志实体
 */
@Entity
@Table(name = "t_loger_infos")
public class LogerEntity implements Serializable {

    private static final long serialVersionUID = -3173448174838838792L;

    @Id
    @GeneratedValue
    @Column(name = "loger_id")
    @Getter
    @Setter
    private Long id;

    @Column(name = "loger_client_ip")
    @Getter
    @Setter
    private String clientIp;

    @Column(name = "loger_url")
    @Getter
    @Setter
    private String url;

    @Column(name = "loger_type")
    @Getter
    @Setter
    private String type;

    @Column(name = "loger_method")
    @Getter
    @Setter
    private String method;

    @Column(name = "loger_param_data")
    @Getter
    @Setter
    private String paramData;

    @Column(name = "loger_sesion_id")
    @Getter
    @Setter
    private String sessionId;

    @Column(name = "loger_time")
    @Getter
    @Setter
    private Timestamp time;

    @Column(name = "loger_return_time")
    @Getter
    @Setter
    private String returnTime;

    @Column(name = "loger_return_data")
    @Getter
    @Setter
    private String returnData;

    @Column(name = "loger_http_status_code")
    @Getter
    @Setter
    private String httpStatusCode;

    @Column(name = "loger_time_consuming")
    @Getter
    @Setter
    private Integer timeConsuming;

}
