public class Student {
    private static final String[] PARAMETERS = {"Name", "Age", "Grade", "School"};

    private String name;
    private Integer age;
    private Integer grade;
    private String school;

    public Student(String name, Integer age, Integer grade, String school) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
    }

    public static String[] getPARAMETERS() {
        return PARAMETERS;
    }

    public Object getParameter(String parameterName) {
        switch(parameterName) {
            case "Name":
                return this.name;
            case "Age":
                return  this.age;
            case "Grade":
                return this.grade;
            case "School":
                return this.school;
        }
        return null;
    }
}
