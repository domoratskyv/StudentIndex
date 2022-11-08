public class Student {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;

    public enum StudyProfile{
        BUILDING("Строительство"), ENGINIRING("Инженерия"), JURISPRUDENCE("Юриспруденция"), MEDICINE("Медицина");

        private StudyProfile profile;
        private String pname;

        StudyProfile(String pnameru){
            pname = pnameru;
        }

        public String getName(){
            return pname;
        }
    }

    StudyProfile mainProfile;

    public Student(){}

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString(){
        return "Студент<" +
                "   фио:" + fullName +
                "   группа:" + universityId +
                "   курс:" + currentCourseNumber +
                "   ср. оценка:" + avgExamScore +
                "   профиль:" + mainProfile +
                ">";
    }
}
