package List;

public class WordUtils {

    public static String findLongest(generalList<String> l){
        int maxid=0;
        int i;

        for(i=1;i<l.getSize();i++)
            maxid=l.getOne(i).length()>l.getOne(maxid).length()?i:maxid;

        return l.getOne(maxid);
    }

}
