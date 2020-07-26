package Question2;

import java.util.Comparator;

//class used for sorting according to name else roll no
class NameCompare implements Comparator<student>
{

    @Override
    public int compare(student o1, student o2) {

        int res = o1.getName().compareTo(o2.getName());
        // if name is same, compare by roll no
        if(res==0){
            if (o1.getRoll_no() < o2.getRoll_no()) return -1;
            if (o1.getRoll_no() > o2.getRoll_no()) return 1;
        } else {
            return res;
        }

        return res;
    }
}
