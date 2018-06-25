package com;

public class NestedClassExamples {
}

class Solution {

    static int data = 30;

    static class NestedInnerClass {
        public void method1() {
            System.out.println("Inner class method...." + data);
        }

        static public void method2() {
            System.out.println("Static method call..." + data);
        }
    }

    class InnerClass {
        public void method1() {
            System.out.println("InnerClass method...");
        }
        /*static public void methodStatic() {
            System.out.println(" static InnerClass method...");
        }*/
    }
}

class Main {

    public static void main(String[] args) {
        Solution.NestedInnerClass nestedInnerClass = new Solution.NestedInnerClass();
        nestedInnerClass.method1();
        Solution.NestedInnerClass.method2();

        Solution solution = new Solution();
        Solution.InnerClass innerClass = solution.new InnerClass();
        innerClass.method1();

    }

}

