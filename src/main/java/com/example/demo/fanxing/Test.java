package com.example.demo.fanxing;

/**
 * @Desc
 * @Author lyl
 * @Date 2019/5/10 14:57
 **/
public class Test<T extends Student> {

    private T stu;

    public void test(){
        System.out.println(stu.print());
    }

    public T getStu() {
        return stu;
    }

    public void setStu(T stu) {
        this.stu = stu;
    }

    public static void main(String[] args) {
        Test<Student> t=new Test<>();
        Student stu=new Student();
        t.setStu(stu);
        t.test();
    }
}
