public class Department {
    private String code;
    private String name;
    private int numberOfEmployees;

    public Department(String code, String name, int numberOfEmployees) {
        this.code = code;
        this.name = name;
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        String[][] data = {
                { code, name, Integer.toString(numberOfEmployees) },
        };

        int[] colLengths = { 10, 30, 30 };
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

        return sb.toString();
    }
}
