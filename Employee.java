import java.math.BigDecimal;

public class Employee extends Staff implements ICalculator {
    private int overtime;

    public Employee(String id, String name, int age, double coefficientSalary, String startDate,
            String department, int numberOfLeaveDays, int overtime) {
        super(id, name, age, coefficientSalary, startDate, department, numberOfLeaveDays);
        this.overtime = overtime;
        this.setSalary(this.calculateSalary());
    }

    public double calculateSalary() {
        return this.getCoefficientSalary() * 3000000 + this.overtime * 200000;
    }

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
                        Integer.toString(this.overtime),
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
}
