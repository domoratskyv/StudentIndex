import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class StudentIndex {
    private static final Logger log = LogManager.getLogger(StudentIndex.class);

    public static void main(String[] args) throws IOException {
        log.info("Программа запущена!");

        ExcelImport.ReadInfo("student");

        log.info("Программа отработала!");
    }
}
