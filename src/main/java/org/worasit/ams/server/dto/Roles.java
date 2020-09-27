package org.worasit.ams.server.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * roles
 * @author 
 */
@Data
public class Roles implements Serializable {
    private Integer roleId;

    private String code;

    private String name;

    private String description;

    private Date updatedAt;

    private Date createdAt;

    private static final long serialVersionUID = 1L;
}