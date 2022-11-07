package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DuumyRestApiDataPojo {

    private String employeename;
    private Integer employeesalary;
    private Integer employeeage;
    private String profileimagee;

    public DuumyRestApiDataPojo(String employeename, Integer employeesalary, Integer employeeage, String profileimagee) {
        this.employeename = employeename;
        this.employeesalary = employeesalary;
        this.employeeage = employeeage;
        this.profileimagee = profileimagee;
    }

    public DuumyRestApiDataPojo() {
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public Integer getEmployeesalary() {
        return employeesalary;
    }

    public void setEmployeesalary(Integer employeesalary) {
        this.employeesalary = employeesalary;
    }

    public Integer getEmployeeage() {
        return employeeage;
    }

    public void setEmployeeage(Integer employeeage) {
        this.employeeage = employeeage;
    }

    public String getProfileimagee() {
        return profileimagee;
    }

    public void setProfileimagee(String profileimagee) {
        this.profileimagee = profileimagee;
    }

    @Override
    public String toString() {
        return "DuumyRestApiDataPojo{" +
                "employeename='" + employeename + '\'' +
                ", employeesalary=" + employeesalary +
                ", employeeage=" + employeeage +
                ", profileimagee='" + profileimagee + '\'' +
                '}';
    }
}
