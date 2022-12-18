import com.google.gson.GsonBuilder;
import comparator.*;
import model.Student;
import model.University;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.CompUtil;
import utils.JsonUtil;

import java.io.IOException;
import java.util.List;

public class StudentIndex {
    private static final Logger log = LogManager.getLogger(StudentIndex.class);

    public static void main(String[] args) throws IOException {
        log.info("Программа запущена!");

//        ExcelImport.ReadInfo("student");
//        ExcelImport.ReadInfo("university");

        List<University> universities = ExcelImport.ReadInfoUniversity();
//        UniversityComparator universityComparator = new UniversityCompByYear();
        UniversityComparator universityComparator = CompUtil.getUniversityComparator(CompUtil.UniversityComparatorType.YEAR);
        universities.stream()
                .sorted(universityComparator);
//                .forEach(System.out::println);

        // формируем файл с университетами
        System.out.println("Формируем Json c университетами");
        String strJson = JsonUtil.universitiesToJson(universities);
        System.out.println(strJson);

        // формируем список университетов из файла
        System.out.println("Формируем список университетов из Json");
        List<University> universitiesFromJson = JsonUtil.jsonToUniversities(strJson);

        if (universities.size() == universitiesFromJson.size()){
            System.out.println("Количество элементов в исходной и в десериализованной коллекциях равны");
        }
        else{
            System.out.println("Количество элементов в исходной и в десериализованной коллекциях НЕ равны");
        }

        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);
        });

        List<Student> students = ExcelImport.ReadInfoStudent();
//        StudentComparator studentComparator = new StudentCompByFullName();
        StudentComparator studentComparator = CompUtil.getStudentComparator(CompUtil.StudentComparatorType.FULL_NAME);
        students.stream()
                .sorted(studentComparator);
//                .forEach(System.out::println);

        // формируем общий файл со студентами
        strJson = JsonUtil.studentsToJson(students);
        System.out.println(strJson);

        log.info("Программа отработала!");
    }
}
