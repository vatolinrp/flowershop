package by.bsu.flowershop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Order implements Serializable
{
  private static final long serialVersionUID = -947971023161487557L;

  private String customerName;

  private String orderId;

  private Long customerPhone;

  private Date creationDate;

  private boolean check;

  private Integer cost;

  private String placement;

  private String address;

  private String positions;

  private boolean isDeleted;
}
