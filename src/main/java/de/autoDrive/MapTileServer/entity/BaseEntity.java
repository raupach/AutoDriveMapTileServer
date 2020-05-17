package de.autoDrive.MapTileServer.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(id)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof BaseEntity == false)
        {
            return false;
        }
        if (this == obj)
        {
            return true;
        }
        BaseEntity otherObject = (BaseEntity) obj;

        return new EqualsBuilder()
                .append(id, otherObject.id)
                .isEquals();
    }

}
