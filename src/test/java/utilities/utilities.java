package utilities;

public class utilities {
    public enum moduleNames {
        ADMIN("Admin"),
        PIM("PIM"),
        LEAVE("Leave"),
        TIME("Time"),
        RECRUITMENT("Recruitment"),
        MY_INFO("My Info"),
        PERFORMANCE("Performance"),
        DASHBOARD("Dashboard"),
        DIRECTORY("Directory"),
        MAINTENANCE("Maintenance"),
        BUZZ("Buzz");
        public final String label;

        moduleNames(String label) {
            this.label = label;
        }
    }

    public enum pimTabNames {
        CONFIGURATION("Configuration"),
        EMPLOYEE_LIST("Employee List"),
        ADD_EMPLOYEE("Add Employee"),
        REPORTS("Reports"),
        RECRUITMENT("Recruitment");
        public final String label;

        pimTabNames(String label) {
            this.label = label;
        }
    }

    public enum adminTabNames {
        USER_MANAGEMENT("User Management"),
        JOB("Job"),
        ORGANIZATION("Organization"),
        QUALIFICATIONS("Qualifications"),
        NATIONALITIES("Nationalities");
        public final String label;

        adminTabNames(String label) {
            this.label = label;
        }
    }

}
