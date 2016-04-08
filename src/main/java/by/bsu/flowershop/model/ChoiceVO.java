package by.bsu.flowershop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ChoiceVO implements Serializable
{
  private static final long serialVersionUID = -947971023161417557L;

  private Long phoneNumber;

  private List<PlacementVO> placementVOList;

  public ChoiceVO()
  {
    List<PlacementVO> placementVOList = new ArrayList<PlacementVO>();
    this.setPlacementVOList( placementVOList );
  }
}
