package by.bsu.flowershop.model.entities;

import java.io.Serializable;
import java.util.Date;

public class FOrder implements Serializable
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

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + (check ? 1231 : 1237);
        result = prime * result + ((cost == null) ? 0 : cost.hashCode());
        result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
        result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
        result = prime * result + ((customerPhone == null) ? 0 : customerPhone.hashCode());
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((placement == null) ? 0 : placement.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FOrder other = (FOrder) obj;
        if (address == null)
        {
            if (other.address != null)
                return false;
        }
        else if (!address.equals(other.address))
            return false;
        if (check != other.check)
            return false;
        if (cost == null)
        {
            if (other.cost != null)
                return false;
        }
        else if (!cost.equals(other.cost))
            return false;
        if (creationDate == null)
        {
            if (other.creationDate != null)
                return false;
        }
        else if (!creationDate.equals(other.creationDate))
            return false;
        if (customerName == null)
        {
            if (other.customerName != null)
                return false;
        }
        else if (!customerName.equals(other.customerName))
            return false;
        if (customerPhone == null)
        {
            if (other.customerPhone != null)
                return false;
        }
        else if (!customerPhone.equals(other.customerPhone))
            return false;
        if (orderId == null)
        {
            if (other.orderId != null)
                return false;
        }
        else if (!orderId.equals(other.orderId))
            return false;
        if (placement == null)
        {
            if (other.placement != null)
                return false;
        }
        else if (!placement.equals(other.placement))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "OrderTO [customerName=" + customerName + ", orderId=" + orderId + ", customerPhone=" + customerPhone
                + ", creationDate=" + creationDate + ", check=" + check + ", cost=" + cost + ", placement=" + placement
                + ", address=" + address + "]";
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getOrderId()
    {
        return orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public Long getCustomerPhone()
    {
        return customerPhone;
    }

    public void setCustomerPhone(Long customerPhone)
    {
        this.customerPhone = customerPhone;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public Integer getCost()
    {
        return cost;
    }

    public void setCost(Integer cost)
    {
        this.cost = cost;
    }

    public String getPlacement()
    {
        return placement;
    }

    public void setPlacement(String placement)
    {
        this.placement = placement;
    }

    public boolean isCheck()
    {
        return check;
    }

    public void setCheck(boolean check)
    {
        this.check = check;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPositions()
    {
        return positions;
    }

    public void setPositions(String positions)
    {
        this.positions = positions;
    }
}
