package utils;

import comparator.*;

public class CompUtil {
    public enum StudentComparatorType {
        UNIVERSITY_ID,
        FULL_NAME,
        COURSE
    }

    public enum UniversityComparatorType {
        ID,
        FULL_NAME,
        SHORT_NAME,
        YEAR
    }

    private CompUtil() {
    }

    public static StudentComparator getStudentComparator(StudentComparatorType studentComparatorType) {

        switch (studentComparatorType) {

            case UNIVERSITY_ID:
                return new StudentCompByUnivercityId();
            case FULL_NAME:
                return new StudentCompByFullName();
            case COURSE:
                return new StudentCompByCourseNumber();
            default:
                return new StudentCompByFullName();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType universityComparatorType) {

        switch (universityComparatorType) {

            case ID:
                return new UniversityCompById();
            case FULL_NAME:
                return new UniversityCompByFullName();
            case SHORT_NAME:
                return new UniversityCompByShortName();
            case YEAR:
                return new UniversityCompByYear();
            default:
                return new UniversityCompByFullName();
        }
    }
}