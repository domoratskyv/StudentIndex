package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Student;
import model.University;
import java.util.List;

public class JsonUtil {

    private JsonUtil() {
    }

    //список студентов в Json
    public static String studentsToJson(List<Student> st){
        return new GsonBuilder().setPrettyPrinting().create().toJson(st);
    }

    //список университетов в Json
    public static String universitiesToJson(List<University> un){
        return new GsonBuilder().setPrettyPrinting().create().toJson(un);
    }

    //студент в Json
    public static String studentToJson(Student student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    //университет в Json
    public static String universityToJson(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    //список студентов из Json
    public static List<Student> jsonToStudents(String json) {
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {}.getType());
    }

    //список университетов из Json
    public static List<University> jsonToUniversities(String json) {
        return new Gson().fromJson(json, new TypeToken<List<University>>() {}.getType());
    }

    //студент из Json
    public static Student jsonToStudent(String json) {
        return new Gson().fromJson(json, Student.class);
    }

    //университет из Json
    public static University jsonToUniversity(String json) {
        return new Gson().fromJson(json, University.class);
    }

}