// File: Staff.java
// Định nghĩa lớp Staff chứa thông tin cơ bản của nhân viên và hàm abstract displayInformation()

public abstract class Staff {
    // Các thuộc tính của lớp Staff
    private String id;              // mã nhân viên
    private String name;            // tên nhân viên
    private int age;                // tuổi nhân viên
    private double coefficientSalary;    // hệ số lương
    private String startDate;       // ngày vào làm
    private String department;      // bộ phận làm việc
    private int numberOfLeaveDays;  // số ngày nghỉ phép
    private double salary;                 // lương
    
    // Hàm khởi tạo có tham số của lớp Staff
    public Staff(String id, String name, int age, double coefficientSalary, String startDate, String department, int numberOfLeaveDays) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.coefficientSalary = coefficientSalary;
        this.startDate = startDate;
        this.department = department;
        this.numberOfLeaveDays = numberOfLeaveDays;
    }
    
    // Hàm abstract displayInformation() để hiển thị thông tin phù hợp cho từng class kế thừa
    public abstract void displayInformation();
    
    // Getter và setter cho các thuộc tính của lớp Staff
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
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public double getCoefficientSalary() {
        return coefficientSalary;
    }
    
    public void setCoefficientSalary(double coefficientSalary) {
        this.coefficientSalary = coefficientSalary;
    }
    
    public String getStartDate() {
        return startDate;
    }
    
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public int getNumberOfLeaveDays() {
        return numberOfLeaveDays;
    }
    
    public void setNumberOfLeaveDays(int numberOfLeaveDays) {
        this.numberOfLeaveDays = numberOfLeaveDays;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
