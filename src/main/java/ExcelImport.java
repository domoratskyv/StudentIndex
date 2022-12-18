import model.Student;
import model.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.sun.activation.registries.LogSupport.log;

public class ExcelImport{
    private static final Logger log = LogManager.getLogger(ExcelImport.class);

    public static List<Student> ReadInfoStudent() throws IOException{
        try{
            List<Student> students = new ArrayList<>();
            File fileName = new File("C:\\Temp\\universityInfo.xlsx");
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            Sheet sheet = null;

            sheet = workBook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();

                Student student = new Student();

                students.add(student);
                student.setUniversityId(currentRow.getCell(0).getStringCellValue());
                student.setFullName(currentRow.getCell(1).getStringCellValue());
                student.setCurrentCourseNumber((int)currentRow.getCell(2).getNumericCellValue());
                student.setAvgExamScore((float)currentRow.getCell(3).getNumericCellValue());
            }
            return students;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<University> ReadInfoUniversity() throws IOException{
        try{
            List<University> universities = new ArrayList<>();
            File fileName = new File("C:\\Temp\\universityInfo.xlsx");
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            Sheet sheet = null;

            sheet = workBook.getSheetAt(1);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();

                University university = new University();

                universities.add(university);
                university.setId(currentRow.getCell(0).getStringCellValue());
                university.setFullName(currentRow.getCell(1).getStringCellValue());
                university.setShortName(currentRow.getCell(2).getStringCellValue());
                university.setYearOfFoundation((int)currentRow.getCell(3).getNumericCellValue());
            }
            return universities;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void ReadInfo(String type) throws IOException {
        try {
            File fileName = new File("C:\\Temp\\universityInfo.xlsx");
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            Sheet sheet = null;
            Integer i;

            if (type.equals("student")) {
                sheet = workBook.getSheetAt(0);
            } else if (type.equals("university")) {
                sheet = workBook.getSheetAt(1);
            } else {
                System.out.println("Проблемы с открытием файла " + fileName);
                log("Проблемы с открытием файла " + fileName);
            }

            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {

                Row curRow = iterator.next();
                curRow = iterator.next();
                Iterator<Cell> cellIterator = curRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell curCell = cellIterator.next();

                    if (curCell.getCellType() == CellType.STRING) {
                        System.out.print(curCell.getStringCellValue() + "--");
                    } else if (curCell.getCellType() == CellType.NUMERIC) {
                        System.out.print(curCell.getNumericCellValue() + "--");
                    }

                }
                System.out.println("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
