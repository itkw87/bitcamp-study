package bitcamp.myapp;

// 소스 코드에서 Calculator 클래스는 bitcamp.util 패키지에 소속된 클래스를 가리킨다.
// 즉, 이렇게 import를 해주면 Calculator.변수명 or Calculator.메소드명으로 변수 or 메소드를 사용해도
// 컴파일하면 bitcamp.util.Calculator.변수명 or bitcamp.util.Calculator.메소드명으로 바꿔주고 import문은 사라짐.
// 즉, 컴파일러는 import문장은 바이트 코드로 바꾸지 않고 없애버림 따라서 import를 많이해도 바이트 코드가 많아지지는 않음.
import bitcamp.util.Calculator;

public class Test {
  public static void main(String[] args){
    // 2 * 3 + 7 - 2 / 2
    // => 연산자 우선 순위를 고려하지 않고 앞에서 부터 뒤로 순차적으로 계산한다.

      // 다른 java소스파일에 있는 static변수와 static메소드를 사용할때는 '클래스명.변수명', '클래스명.메소드명'으로 사용해야함.
      // 다른 패키지에 있는 소스파일의 클래스에 접근할때는 해당 클래스가 정의된 소스파일명앞에 패키지명을 붙여줘야함.
      // 패키지 경로를 적어주기 귀찮아서 import라는 것이 등장함.
      Calculator.init(2);
      Calculator.multiple(3);
      Calculator.plus(7);
      Calculator.minus(2);
      Calculator.divide(2);
      System.out.println(Calculator.result);
    }

  
}
