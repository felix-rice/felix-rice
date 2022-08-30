package com.felix.rice.component.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-30
 */
@Data
@ToString
public class User {
    private Long id;
    private String name;
    private String passwd;
    private Long createTime;
    private Long updateTime;
}
