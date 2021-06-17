import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    private static final String fileName = "C:\\Users\\arturs.maslenkovs\\OneDrive - HELMES A S\\Töölaud\\JAVA" +
            "\\MSDocumentExample.xlsx";

    public static void main(String[] args) {
        Student studentOne = new Student("Artur", 18, 40, "Rigas Klasiska Gimnazija");
        Student studentTwo = new Student("Rutra", 16, 95, "Rigas 1 Valsts Gimnazija");

        ArrayList<Student> students = new ArrayList<>();
        students.add(studentOne);
        students.add(studentTwo);

        try {
            saveToExcel(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToExcel(ArrayList<Student> students) throws IOException {
        int rowCounter = 0;
        int columnCounter = 0;

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Students");

        Row initialRow = sheet.createRow(rowCounter);
        for (String parameter : Student.getPARAMETERS()) {
            Cell cell = initialRow.createCell(columnCounter);
            cell.setCellValue(parameter);
            columnCounter++;
        }


        for (Student student : students) {
            columnCounter = 0;
            rowCounter++;
            Row studentRow = sheet.createRow(rowCounter);
            for (String parameter : Student.getPARAMETERS()) {
                Cell cell = studentRow.createCell(columnCounter);
                if (student.getParameter(parameter) instanceof String) {
                    cell.setCellValue((String) student.getParameter(parameter));
                } else {
                    cell.setCellValue((Integer) student.getParameter(parameter));
                }
                columnCounter++;
            }
            sheet.autoSizeColumn(3);
        }

        workbook.write(Files.newOutputStream(Path.of(fileName)));
        workbook.close();
    }
}
