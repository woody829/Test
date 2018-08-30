import java.util.Arrays;
import java.util.List;
public class TestList{
    public static void main(String[] args) {
        String[] array= {"one","two","three"};
        List<String> list=Arrays.asList(array);
        System.out.println(list.size());
        System.out.println(list);


//		ArrayList t = new ArrayList(list);

//		list.add("four");
        list.set(1, "a");
        System.out.println(list);

        for(String ss : array) {
            System.out.println(ss);
        }
//		List<String> list1;



        String[] k = {"3","4","5"};
        String[] kk = k;
        kk[0]="999";
        for(String c : k) {
            System.out.println(c);
        }

    }
}