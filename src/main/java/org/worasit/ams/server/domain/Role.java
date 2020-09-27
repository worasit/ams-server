package org.worasit.ams.server.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * roles
 *
 * @author Worasit D.
 */
@Data
public class Role implements Serializable {
  private Integer roleId;

  private String code;

  private String name;

  private String description;

  private Date updatedAt;

  private Date createdAt;

  private static final long serialVersionUID = 1L;
}
