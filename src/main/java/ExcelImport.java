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
import java.util.Iterator;

import static com.sun.activation.registries.LogSupport.log;

public class ExcelImport{
    private static final Logger log = LogManager.getLogger(ExcelImport.class);
    public static void ReadInfo(String p_type) throws IOException {
        try {
            File fileName = new File("C:\\Temp\\universityInfo.xlsx");
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            Sheet sheet = null;

            if (p_type.equals("student")) {
                sheet = workBook.getSheetAt(0);
            } else if (p_type.equals("university")) {
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
