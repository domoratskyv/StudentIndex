public class StudentIndex {
    public static void main(String[] args) {
        University dalgau = new University();
        dalgau.setId("dalgau");
        dalgau.setShortName("ДальГАУ");
        dalgau.setFullName("дальневосточный Государственный Аграрный Университет");
        dalgau.setYearOfFoundation(1975);

        Student student01 = new Student();
        student01.setUniversityId("dalgau");
        student01.setCurrentCourseNumber(1707);
        student01.setFullName("Василий Иванович Сидоров");
        student01.setAvgExamScore(5);
        student01.setMainProfile(Student.StudyProfile.ENGINIRING);

        System.out.println(dalgau);
        System.out.println(student01);
    }
}
