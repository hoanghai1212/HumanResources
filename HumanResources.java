import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HumanResources {
    private static final String[] STAFF_TABLE_HEADER = { "Mã nhân viên", "Tên nhân viên", "Tuổi", "HS Lương",
            "Ngày vào làm",
            "Ngày nghỉ phép",
            "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương" };
    private static final int[] STAFF_TABLE_COL_LENGTH = { 20, 20, 15, 20, 20, 20, 25, 30, 15 };

    private static String headerBuilder(String[] headers, int[] colLengths) {
        // Create a StringBuilder object to store the output
        StringBuilder sb = new StringBuilder();

        // Loop through the header names and column lengths
        for (int i = 0; i < headers.length; i++) {
            // Append the formatted header name and column length to the StringBuilder
            // object
            sb.append(String.format("%-" + colLengths[i] + "s", headers[i]));

            // If the current index is not the last index, append a separator
            if (i != headers.length - 1)
                sb.append(" | ");
        }

        // return the output
        return sb.toString();
    }

    private static ArrayList<Department> initializeDepartments() {
        ArrayList<Department> departments = new ArrayList<Department>();

        Department department1 = new Department("HC", "Hành chính nhân sự", 0);
        Department department2 = new Department("IT", "Công nghệ thông tin", 0);
        Department department3 = new Department("MKT", "Marketing", 0);

        departments.add(department1);
        departments.add(department2);
        departments.add(department3);

        return departments;
    }

    private static void showAllDepartments(ArrayList<Department> departments) {
        // Create arrays to store the names of the header columns and the lengths of
        // each column
        String[] headers = { "Mã bộ phận", "Tên bộ phận", "Số lượng nhân viên hiện tại" };
        int[] colLengths = { 10, 30, 30 };

        // Print the header
        System.out.println(headerBuilder(headers, colLengths));

        // Print the department table
        for (Department department : departments) {
            System.out.println(department.toString());
        }
    }

    private static void showAllStaffs(ArrayList<Staff> staffs) {
        // Print the header
        System.out.println(headerBuilder(STAFF_TABLE_HEADER, STAFF_TABLE_COL_LENGTH));

        // Print the staff table
        for (Staff staff : staffs) {
            staff.displayInformation();
        }
    }

    private static void showStaffsByDepartmentName(String departmentName, ArrayList<Staff> staffs) {
        // Print the header
        System.out.println(headerBuilder(STAFF_TABLE_HEADER, STAFF_TABLE_COL_LENGTH));

        // Print the staff table
        for (Staff staff : staffs) {
            if (staff.getDepartment().equals(departmentName)) {
                staff.displayInformation();
            }
        }
    }

    // add new staff and return the department name
    private static String addNewStaff(Scanner scanner, ArrayList<Staff> staffs) {
        System.out.println("1. Thêm nhân viên thông thường");
        System.out.println("2. Thêm nhân viên là cấp quản lý (có thêm chức vụ)");
        System.out.print("Bạn chọn: ");
        String input = scanner.nextLine();

        switch (input) {
            case "1": {
                System.out.print("Nhập mã nhân viên: ");
                String id = scanner.nextLine();

                System.out.print("Nhập tên nhân viên: ");
                String name = scanner.nextLine();

                System.out.print("Nhập tuổi nhân viên: ");
                int age = Integer.parseInt(scanner.nextLine());

                System.out.print("Nhập hệ số lương của nhân viên: ");
                double salaryCoefficient = Double.parseDouble(scanner.nextLine());

                System.out.print("Nhập ngày vào làm của nhân viên: ");
                String startDate = scanner.nextLine();

                System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
                int leaveDays = Integer.parseInt(scanner.nextLine());

                System.out.println("1. HC - Hành chính nhân sự");
                System.out.println("2. IT - Công nghệ thông tin");
                System.out.println("3. MKT - Marketing");
                System.out.print("Bạn chọn bộ phận: ");
                String department = "";
                String selectedDepartment;
                do {
                    selectedDepartment = scanner.nextLine();
                    switch (selectedDepartment) {
                        case "1":
                            department = "Hành chính nhân sự";
                            break;

                        case "2":
                            department = "Công nghệ thông tin";
                            break;

                        case "3":
                            department = "Marketing";
                            break;
                    }
                } while (department == "");

                System.out.print("Nhập số giờ làm thêm: ");
                int extraHours = Integer.parseInt(scanner.nextLine());

                Employee newEmployee = new Employee(id, name, age, salaryCoefficient, startDate, department, leaveDays,
                        extraHours);
                staffs.add(newEmployee);

                return department;
            }

            case "2": {
                System.out.print("Nhập mã nhân viên: ");
                String id = scanner.nextLine();

                System.out.print("Nhập tên nhân viên: ");
                String name = scanner.nextLine();

                System.out.print("Nhập tuổi nhân viên: ");
                int age = Integer.parseInt(scanner.nextLine());

                System.out.print("Nhập hệ số lương của nhân viên: ");
                double salaryCoefficient = Double.parseDouble(scanner.nextLine());

                System.out.print("Nhập ngày vào làm của nhân viên: ");
                String startDate = scanner.nextLine();

                System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
                int leaveDays = Integer.parseInt(scanner.nextLine());

                System.out.println("1. HC - Hành chính nhân sự");
                System.out.println("2. IT - Công nghệ thông tin");
                System.out.println("3. MKT - Marketing");
                System.out.print("Bạn chọn bộ phận: ");
                String department = "";
                String selectedDepartment;
                do {
                    selectedDepartment = scanner.nextLine();
                    switch (selectedDepartment) {
                        case "1":
                            department = "Hành chính nhân sự";
                            break;

                        case "2":
                            department = "Công nghệ thông tin";
                            break;

                        case "3":
                            department = "Marketing";
                            break;
                    }
                } while (department == "");

                System.out.println("Chức danh: ");
                System.out.println("1. Business Leader");
                System.out.println("2. Project Leader");
                System.out.println("3. Technical Leader");
                System.out.print("Nhập chức danh: ");
                String position = "";
                String selectedPosition = scanner.nextLine();
                do {
                    switch (selectedPosition) {
                        case "1":
                            position = "Business Leader";
                            break;

                        case "2":
                            position = "Project Leader";
                            break;

                        case "3":
                            position = "Technical Leader";
                            break;
                    }
                } while (position == "");

                Manager newManager = new Manager(id, name, age, salaryCoefficient, startDate, department, leaveDays,
                        position);
                staffs.add(newManager);

                return department;
            }
        }

        return "";
    }

    // search staff by name or id
    private static void searchStaff(Scanner scanner, ArrayList<Staff> staffs) {
        System.out.print("Nhập tên hoặc mã nhân viên cần tìm: ");
        String keyword = scanner.nextLine();
        Staff foundStaff = null;

        // find staff by id or name
        for (Staff staff : staffs) {
            // the keyword could be part of name or id
            if (staff.getId().contains(keyword) || staff.getName().contains(keyword)) {
                foundStaff = staff;
                break;
            }
        }

        // display information of found staff
        if (foundStaff != null) {
            System.out.println(headerBuilder(STAFF_TABLE_HEADER, STAFF_TABLE_COL_LENGTH));
            foundStaff.displayInformation();
        } else {
            System.out.println("Không tìm thấy nhân viên nào có mã hoặc tên là " + keyword);
        }
    }

    // display salary table of all staffs
    private static void displaySalaryTable(ArrayList<Staff> staffs) {
        // Print the header
        System.out.println(headerBuilder(STAFF_TABLE_HEADER, STAFF_TABLE_COL_LENGTH));

        // Print the data
        for (Staff staff : staffs) {
            staff.displayInformation();
        }
    }

    // display salary table of all staffs in ascending order
    private static void displaySalaryTableAscending(ArrayList<Staff> staffs) {
        // Create arrays to store the names of the header columns and the lengths of
        // each column
        String[] headers = { "Mã nhân viên", "Tên nhân viên", "Tuổi", "HS Lương", "Ngày vào làm", "Ngày nghỉ phép",
                "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương" };
        int[] colLengths = { 20, 20, 15, 20, 20, 20, 25, 30, 15 };

        // Print the header
        System.out.println(headerBuilder(headers, colLengths));

        // Clone the staffs array
        ArrayList<Staff> staffsClone = new ArrayList<>(staffs);

        // Sort the staffs array in ascending order
        Collections.sort(staffsClone, new Comparator<Staff>() {
            @Override
            public int compare(Staff staff1, Staff staff2) {
                return Double.compare(staff1.getSalary(), staff2.getSalary());
            }
        });

        // Print the data
        for (Staff staff : staffsClone) {
            staff.displayInformation();
        }
    }

    private static void displayMenu() {
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty.");
        System.out.println("2. Hiển thị các bộ phận trong công ty.");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận.");
        System.out.println("4. Thêm nhân viên mới vào công ty.");
        System.out.println("5. Tìm kiếm nhân viên công ty theo tên hoặc mã nhân viên.");
        System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty.");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
        System.out.println("0. Thoát chương trình.");
        System.out.print("Lựa chọn của bạn: ");
    }

    private static void mockEmployee(ArrayList<Staff> staffs) {
        staffs.add(new Employee("E001", "Nguyễn Văn A", 25, 1.5, "01/01/2019", "Hành chính nhân sự", 0, 0));
        staffs.add(new Employee("E002", "Nguyễn Văn B", 26, 2.5, "01/01/2019", "Marketing", 0, 0));
        staffs.add(new Employee("E003", "Nguyễn Văn C", 27, 3.5, "01/01/2019", "Hành chính nhân sự", 0, 0));
        staffs.add(new Employee("E004", "Nguyễn Văn D", 28, 1.2, "01/01/2019", "Marketing", 0, 0));
        staffs.add(new Employee("E005", "Nguyễn Văn E", 29, 1.1, "01/01/2019", "Hành chính nhân sự", 0, 0));
        staffs.add(new Employee("E006", "Nguyễn Văn F", 30, 1.6, "01/01/2019", "Hành chính nhân sự", 0, 0));
        staffs.add(new Employee("E007", "Nguyễn Văn G", 31, 5.2, "01/01/2019", "Công nghệ thông tin", 0, 0));
        staffs.add(new Employee("E008", "Nguyễn Văn H", 32, 2.5, "01/01/2019", "Công nghệ thông tin", 0, 0));
        staffs.add(new Employee("E009", "Nguyễn Văn I", 33, 1.1, "01/01/2019", "Công nghệ thông tin", 0, 0));
    }

    private static void mockManager(ArrayList<Staff> staffs) {
        staffs.add(new Manager("M010", "Nguyễn Văn J", 25, 4.5, "01/01/2019", "Hành chính nhân sự", 0,
                "Business Leader"));
        staffs.add(new Manager("M011", "Nguyễn Văn K", 26, 7.5, "01/01/2019", "Hành chính nhân sự", 0,
                "Business Leader"));
        staffs.add(new Manager("M012", "Nguyễn Văn L", 27, 13.5, "01/01/2019", "Hành chính nhân sự", 0,
                "Business Leader"));
        staffs.add(new Manager("M013", "Nguyễn Văn M", 28, 8.52, "01/01/2019", "Marketing", 0, "Project Leader"));
        staffs.add(new Manager("M014", "Nguyễn Văn N", 29, 6.12, "01/01/2019", "Marketing", 0, "Project Leader"));
        staffs.add(new Manager("M015", "Nguyễn Văn O", 30, 6.77, "01/01/2019", "Marketing", 0, "Project Leader"));
        staffs.add(new Manager("M016", "Nguyễn Văn P", 31, 5.12, "01/01/2019", "Công nghệ thông tin", 0,
                "Technical Leader"));
        staffs.add(new Manager("M017", "Nguyễn Văn Q", 32, 8.11, "01/01/2019", "Công nghệ thông tin", 0,
                "Technical Leader"));
        staffs.add(new Manager("M018", "Nguyễn Văn R", 33, 2.5, "01/01/2019", "Công nghệ thông tin", 0,
                "Technical Leader"));
    }

    private static void mockDepartmentNumberOfEmployees(ArrayList<Department> departments, ArrayList<Staff> staffs) {
        for (Department department : departments) {
            int count = 0;
            for (Staff staff : staffs) {
                if (staff.getDepartment().equals(department.getName())) {
                    count++;
                }
            }
            department.setNumberOfEmployees(count);
        }
    }

    public static void main(String[] args) {
        ArrayList<Department> departments = initializeDepartments();
        ArrayList<Staff> staffs = new ArrayList<Staff>();
        Scanner scanner = new Scanner(System.in, "UTF-8");
        String input;

        // uncomment to mock data
        // mockEmployee(staffs);
        // mockManager(staffs);
        // mockDepartmentNumberOfEmployees(departments, staffs);

        do {
            displayMenu();
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    showAllStaffs(staffs);
                    break;
                case "2":
                    showAllDepartments(departments);
                    break;
                case "3":
                    for (Department department : departments) {
                        System.out.println();
                        System.out.println(department.getName());
                        System.out.println("-------------------------------------------");
                        showStaffsByDepartmentName(department.getName(), staffs);
                    }
                    break;
                case "4":
                    String departmentName = addNewStaff(scanner, staffs);

                    for (Department department : departments) {
                        if (department.getName().equals(departmentName)) {
                            department.setNumberOfEmployees(department.getNumberOfEmployees() + 1);
                        }
                    }
                    break;
                case "5":
                    searchStaff(scanner, staffs);
                    break;
                case "6":
                    displaySalaryTable(staffs);
                    break;
                case "7":
                    displaySalaryTableAscending(staffs);
                    break;
                case "0":
                    // exit
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (!input.equals("0"));

        scanner.close();
    }
}
