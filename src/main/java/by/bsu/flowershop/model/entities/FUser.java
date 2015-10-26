package by.bsu.flowershop.model.entities;

public class FUser
{

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Long role;

    public FUser()
    {
        super();
    }

    public FUser(Long id, String name, String surname, String username, String password, Long role)
    {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Long getRole()
    {
        return role;
    }

    public void setRole(Long role)
    {
        this.role = role;
    }

    @Override
    public String toString()
    {
        return "FUser{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", surname='" + surname + '\''
                + ", username='" + username + '\'' + ", password='" + password + '\'' + ", role=" + role + '}';
    }
}
