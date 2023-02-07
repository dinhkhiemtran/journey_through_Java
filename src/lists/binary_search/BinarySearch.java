package lists.binary_search;

import java.util.List;

public class BinarySearch {

    private List<Integer> list;

    public BinarySearch(List<Integer> list) {
        this.list = list;
    }

    public int indexOf(int target)  throws ValueNotFoundException {
        int leftPointer = 0;
        int rightPointer = list.size() - 1;
        while (leftPointer <= rightPointer) {
            int middlePointer = ((rightPointer - leftPointer) / 2) + leftPointer;
            int numInMiddle = list.get(middlePointer);
            if (numInMiddle == target) {
                return middlePointer;
            } else if (target > numInMiddle) {
                leftPointer = middlePointer + 1;
            } else {
                rightPointer = middlePointer - 1;
            }
        }
        throw new ValueNotFoundException("Value not in array");
    }

    public static void main(String[] args) throws ValueNotFoundException {
        List<Integer> list = List.of(1, 3, 4, 6, 8, 9, 11);
        int target = 6;
        BinarySearch binarySearch = new BinarySearch(list);
        int result = binarySearch.indexOf(target);
        System.out.println(result);
    }

}
