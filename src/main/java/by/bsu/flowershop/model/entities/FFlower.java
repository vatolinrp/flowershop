package by.bsu.flowershop.model.entities;

public class FFlower
{
    private String id;
    private String name;
    private Long cost;
    private String info;
    private String imgUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FFlower fFlower = (FFlower) o;

        if (!id.equals(fFlower.id)) return false;
        if (!name.equals(fFlower.name)) return false;
        if (!cost.equals(fFlower.cost)) return false;
        if (!info.equals(fFlower.info)) return false;
        return imgUrl.equals(fFlower.imgUrl);

    }

    @Override
    public int hashCode()
    {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + cost.hashCode();
        result = 31 * result + info.hashCode();
        result = 31 * result + imgUrl.hashCode();
        return result;
    }
}
