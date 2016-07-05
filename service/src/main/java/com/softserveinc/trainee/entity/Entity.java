package com.softserveinc.trainee.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@javax.persistence.Entity
@Table(name = "entities")
public class Entity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "schema_name", nullable = false)
    private String SchemaName;

    @Column(name = "table_name", nullable = false)
    private String TableName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "entity_id")
    private List<Field> fieldList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchemaName() {
        return SchemaName;
    }

    public void setSchemaName(String schemaName) {
        SchemaName = schemaName;
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String tableName) {
        TableName = tableName;
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append(getId())
                                        .append(getSchemaName())
                                        .append(getTableName())
                                        .append(getFieldList())
                                        .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Entity other = (Entity)obj;
        return new EqualsBuilder().append(getId(), other.getId())
                    .append(getSchemaName(), other.getSchemaName())
                    .append(getTableName(), other.getTableName())
                    .append(getFieldList(), other.getFieldList())
                    .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId())
                                    .append(getSchemaName())
                                    .append(getTableName())
                                    .append(getFieldList())
                                    .toHashCode();
    }
}

