package org.worasit.ams.server.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * users
 *
 * @author
 */
@Data
public class User implements Serializable {
  private Integer userId;

  private Integer roleId;

  private String userCode;

  private String firstName;

  private String lastName;

  private String displayName;

  private String phoneNumber;

  private String email;

  private String address;

  private Boolean isActive;

  private Date updatedAt;

  private Date createdAt;

  private static final long serialVersionUID = 1L;
}
