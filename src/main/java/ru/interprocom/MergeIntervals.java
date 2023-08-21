package ru.interprocom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        //Arrays.sort(intervals, Comparator.comparingInt(row -> row[0]));
        Arrays.sort(intervals, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.compare(((int[]) o1)[0], ((int[]) o2)[0]);
            }
        });
        List<int[]> list = new ArrayList<>();
        int[] elem = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (elem[1] >= intervals[i][0]) {
                elem[1] = Math.max(intervals[i][1], elem[1]);
            } else {
                list.add(elem);
                elem = intervals[i];
            }
        }
        list.add(elem);
        int[][] ret = new int[list.size()][2];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
