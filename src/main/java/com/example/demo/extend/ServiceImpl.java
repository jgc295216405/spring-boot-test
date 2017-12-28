package com.example.demo.extend;

/**
 * Created by hzjiaoguangcai on 2017/8/21.
 */
public class ServiceImpl extends Service2Impl implements Service1,Service2 {
//    @Override
//    public void a() {
//        System.out.println("aaa");
//    }

    public static void main(String[] args) {
        Service1 service1=new ServiceImpl();
        service1.a();
    }
}
