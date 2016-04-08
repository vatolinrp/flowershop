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
public class TopRated implements Serializable
{
  private static final long serialVersionUID = -947931023171487557L;

  private String trId;

  private String placement;

  private String celebrationType;

  private Integer cost;
}
