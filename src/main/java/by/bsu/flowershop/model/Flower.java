package by.bsu.flowershop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Flower implements Serializable
{
  private static final long serialVersionUID = -947971023961487557L;

  private String id;

  private String name;

  private Long cost;

  private String info;

  private String imgUrl;

  private String flowerCode;
}
