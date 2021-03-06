package Model;

import java.util.Date;
import java.util.List;

public class Student {
    //学生
    private Integer id;
    private String studentName;
    private String studentGraduateYear;
    private String studentMajor;
    private String studentEmail;
    private Integer dormId;
    private Date createTime;
    private Integer buildingId;
    private String buildingName;
    private String dormNo;


    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentGraduateyYear='" + studentGraduateYear + '\'' +
                ", studentMajor='" + studentMajor + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", dormId=" + dormId +
                ", createTime=" + createTime +
                ", buildingId=" + buildingId +
                ", buildingName='" + buildingName + '\'' +
                ", dormNo='" + dormNo + '\'' +
                '}';
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getDormNo() {
        return dormNo;
    }

    public void setDormNo(String dormNo) {
        this.dormNo = dormNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGraduateYear() {
        return studentGraduateYear;
    }

    public void setStudentGraduateYear(String studentGraduateYear) {
        this.studentGraduateYear = studentGraduateYear;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Integer getDormId() {
        return dormId;
    }

    public void setDormId(Integer dormId) {
        this.dormId = dormId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
