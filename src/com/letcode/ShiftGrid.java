package com.letcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lyn
 * @since 2022/7/20 20:00
 */
public class ShiftGrid {
        public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            for (int[] ints : grid) {
                for (int anInt : ints) {
                    queue.add(anInt);
                }
            }
            for (int i = 0; i < k; i++) {
                queue.addFirst(queue.pollLast());
            }
            List<List<Integer>> objects = new ArrayList<>();
            for (int[] ints : grid) {
                ArrayList<Integer> ints1 = new ArrayList<>();
                for (int i = 0; i < ints.length; i++) {

                    ints1.add(queue.pollFirst());
                }
                objects.add(ints1);
            }
            return objects;
        }

    /**
     * [[1,2,3],[4,5,6],[7,8,9]]
     * @param args
     */
    public static void main(String[] args) {
       int[][] a = new int[][]{{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        List<List<Integer>> lists = shiftGrid(a, 4);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }

}
