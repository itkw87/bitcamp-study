package bitcamp.test;

import bitcamp.test.p1.A;

public class Test2 {
  public static void main(String[] args) {
    A obj = new A();

    // obj.v1 = 100; // 접근 불가!
    // obj.v2 = 200; // 접근 불가!
    // obj.v3 = 300; // 접근 불가!
    obj.v4 = 400;
    // obj.m(); // 접근 불가! (같은 패키지도 아니고 상속관계도 아니기 때문)

  }
}