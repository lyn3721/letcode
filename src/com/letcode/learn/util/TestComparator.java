package com.letcode.learn.util;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lyn
 * @since 2022/11/11 00:59
 * 比较器
 */
public class TestComparator {
    static class Student {
      private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Student(int age) {
          this.age = age;
      }
    }
    public void sort() {
        Student [] arr = new Student[] {new Student(1), new Student(2), new Student(3)};
        Arrays.sort(arr, Comparator.comparingInt(Student::getAge));
        Arrays.sort(arr, (o1, o2) -> o1.getAge() - o2.getAge());
        Arrays.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
    }

    public static void main(String[] args) {

    }

//    public static class SortComparator implements Comparator<Integer> {
//
//        /**
//         *         负数 第一个排前面
//         *         正数 第二个排前面
//         *         0 无所谓
//         */
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return o1 - o2;
//        }
//
//    }
}
