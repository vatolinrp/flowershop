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
public class User implements Serializable
{
  private static final long serialVersionUID = -947979023161487557L;

  private Long id;

  private String name;

  private String surname;

  private String username;

  private String password;

  private Long role;
}
