package kisland.kislandmain.DO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "charge_category", schema = "kidsland", catalog = "")
public class ChargeCategoryDO {
    private int id;
    private String categoryName;
    private String kzlCategoryValue;
    private String northCategoryValue;
    private String middleCategoryValue;
    private String southCategoryValue;
    private String ylbCategoryValue;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "category_name")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "KZL_category_value")
    public String getKzlCategoryValue() {
        return kzlCategoryValue;
    }

    public void setKzlCategoryValue(String kzlCategoryValue) {
        this.kzlCategoryValue = kzlCategoryValue;
    }

    @Basic
    @Column(name = "north_category_value")
    public String getNorthCategoryValue() {
        return northCategoryValue;
    }

    public void setNorthCategoryValue(String northCategoryValue) {
        this.northCategoryValue = northCategoryValue;
    }

    @Basic
    @Column(name = "middle_category_value")
    public String getMiddleCategoryValue() {
        return middleCategoryValue;
    }

    public void setMiddleCategoryValue(String middleCategoryValue) {
        this.middleCategoryValue = middleCategoryValue;
    }

    @Basic
    @Column(name = "south_category_value")
    public String getSouthCategoryValue() {
        return southCategoryValue;
    }

    public void setSouthCategoryValue(String southCategoryValue) {
        this.southCategoryValue = southCategoryValue;
    }

    @Basic
    @Column(name = "YLB_category_value")
    public String getYlbCategoryValue() {
        return ylbCategoryValue;
    }

    public void setYlbCategoryValue(String ylbCategoryValue) {
        this.ylbCategoryValue = ylbCategoryValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChargeCategoryDO that = (ChargeCategoryDO) o;
        return id == that.id &&
                Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(kzlCategoryValue, that.kzlCategoryValue) &&
                Objects.equals(northCategoryValue, that.northCategoryValue) &&
                Objects.equals(middleCategoryValue, that.middleCategoryValue) &&
                Objects.equals(southCategoryValue, that.southCategoryValue) &&
                Objects.equals(ylbCategoryValue, that.ylbCategoryValue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, categoryName, kzlCategoryValue, northCategoryValue, middleCategoryValue, southCategoryValue, ylbCategoryValue);
    }
}
