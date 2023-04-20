import java.math.BigDecimal;

// Manager là một lớp kế thừa từ Staff và implements ICalculator
public class Manager extends Staff implements ICalculator {
    // thuộc tính chức danh
    private String title;

    // constructor
    public Manager(String id, String name, int age, double coefficientSalary, String startDate, String department,
            int daysOff, String title) {
        super(id, name, age, coefficientSalary, startDate, department, daysOff);
        this.title = title;
        this.setSalary(this.calculateSalary());
    }

    // phương thức tính lương
    @Override
    public double calculateSalary() {
        double salary = super.getCoefficientSalary() * 5000000; // tính lương cơ bản
        salary += getResponsibilitySalary(); // cộng thêm lương trách nhiệm
        return salary;
    }

    // phương thức hiển thị thông tin quản lý bao gồm cả chức danh
    @Override
    public void displayInformation() {
        String[][] data = {
                {
                        this.getId(),
                        this.getName(),
                        Integer.toString(this.getAge()),
                        Double.toString(this.getCoefficientSalary()),
                        this.getStartDate(),
                        Integer.toString(this.getNumberOfLeaveDays()),
                        this.getDepartment(),
                        title,
                        String.format("%.2f", this.calculateSalary())
                },
        };

        int[] colLengths = { 20, 20, 15, 20, 20, 20, 25, 30, 15 };
        StringBuilder sb = new StringBuilder();

        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                sb.append(String.format("%-" + colLengths[i] + "s", row[i]));
                /*
                 * Here is the explanation for the code above:
                 * 1. colLengths[i] is the length of the column
                 * 2. row[i] is the column value
                 * 3. % means format specifier
                 * 4. - means left align
                 * 5. colLengths[i] is the width of the column
                 * 6. s is the data type (string)
                 */
                if (i != row.length - 1)
                    sb.append(" | ");
            }
        }
        System.out.println(sb.toString());
    }

    // phương thức tính lương trách nhiệm của quản lý
    private float getResponsibilitySalary() {
        float responsibilitySalary = 0;
        switch (title) {
            case "Business Leader":
                responsibilitySalary = 8000000;
                break;
            case "Project Leader":
                responsibilitySalary = 5000000;
                break;
            case "Technical Leader":
                responsibilitySalary = 6000000;
                break;
            default:
                break;
        }
        return responsibilitySalary;
    }
}
