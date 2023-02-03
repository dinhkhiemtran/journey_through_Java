import java.util.List;

public class Test {

    private List<Integer> list;

    Test(){
        list = List.of(1,2,3,4,5,6);
    }


    public int getMax(){
        return  list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow();
    }

    public static void main(String[] args) {
        Test test = new Test();
        int max = test.getMax();
        System.out.println(max);
    }
}
