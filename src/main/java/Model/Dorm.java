package Model;

import java.util.Date;

public class Dorm {
    //宿舍实体类
    private Integer id;
    private String dormNo;
    private String dormDesc;
    private Integer buildingId;
    private Date createTime;

    @Override
    public String toString() {
        return "Dorm{" +
                "id=" + id +
                ", dormNo='" + dormNo + '\'' +
                ", dormDesc='" + dormDesc + '\'' +
                ", buildingId=" + buildingId +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDormNo() {
        return dormNo;
    }

    public void setDormNo(String dormNo) {
        this.dormNo = dormNo;
    }

    public String getDormDesc() {
        return dormDesc;
    }

    public void setDormDesc(String dormDesc) {
        this.dormDesc = dormDesc;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
