package main.condinations_if.relationship;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RelationshipComputer<T> {

    public Relationship computeRelationship(List<T> firstList, List<T> secondList) {
        if (isEqual(firstList, secondList)) {
            return Relationship.EQUAL;
        }
        if (isSUBLIST(firstList, secondList)) {
            return Relationship.SUBLIST;
        }
        if (isSUPERLIST(firstList, secondList)) {
            return Relationship.SUPERLIST;
        }
        return Relationship.UNEQUAL;
    }

    private int getSizeOfList(List<T> list) {
        return list.size();
    }

    private boolean isEqual(List<T> firstList, List<T> secondList) {
        return Arrays.deepEquals(firstList.toArray(),secondList.toArray());
    }

    private boolean isSUBLIST(List<T> firstList, List<T> secondList) {
        return getSizeOfList(firstList) < getSizeOfList(secondList) && (Collections.indexOfSubList(secondList, firstList) != -1 || getSizeOfList(firstList) == 0);
    }

    private boolean isSUPERLIST(List<T> firstList, List<T> secondList) {
        return getSizeOfList(firstList) > getSizeOfList(secondList) && (Collections.indexOfSubList(firstList, secondList) != -1 || getSizeOfList(secondList) == 0);
    }
}
