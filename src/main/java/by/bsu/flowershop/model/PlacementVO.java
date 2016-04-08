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
public class PlacementVO implements Serializable
{
  private static final long serialVersionUID = -947971023171487557L;

  private String placementId;

  private String htmlPlacement;

  private Integer cost;
}
