import java.util.HashMap;
import java.util.Set;
public class HashMapTest{

    public static void main (String[] args){
        HashMap<String, String> mySong = new HashMap<String,String>();
        mySong.put(" Hope Song","title1");
        mySong.put("Life Song","title2");
        mySong.put(" Good Song","title3");
        mySong.put(" Work Song","title4");
        

       String song = mySong.get("Life Song");

        Set<String> myKey = mySong.keySet();

        for(String key:myKey){
            String value = mySong.get(key);
            System.out.println(key +" "+ value);
            
        }
    }
}