package comparator;

import model.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityCompByFullName implements UniversityComparator {
    @Override
    public int compare(University un1, University un2){
        return StringUtils.compare(un1.getFullName(), un2.getFullName());
    }
}
