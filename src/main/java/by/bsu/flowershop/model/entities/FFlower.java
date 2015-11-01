package by.bsu.flowershop.model.entities;

public class FFlower
{
    private String id;
    private String name;
    private Long cost;
    private String info;
    private String imgUrl;
    private String flowerCode;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
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

    public Long getCost()
    {
        return cost;
    }

    public void setCost(Long cost)
    {
        this.cost = cost;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getFlowerCode()
    {
        return flowerCode;
    }

    public void setFlowerCode(String flowerCode)
    {
        this.flowerCode = flowerCode;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        FFlower fFlower = (FFlower) o;

        if (!id.equals(fFlower.id))
            return false;
        if (!name.equals(fFlower.name))
            return false;
        if (!cost.equals(fFlower.cost))
            return false;
        if (info != null ? !info.equals(fFlower.info) : fFlower.info != null)
            return false;
        if (!imgUrl.equals(fFlower.imgUrl))
            return false;
        return flowerCode.equals(fFlower.flowerCode);

    }

    @Override
    public int hashCode()
    {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + cost.hashCode();
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + imgUrl.hashCode();
        result = 31 * result + flowerCode.hashCode();
        return result;
    }
}
