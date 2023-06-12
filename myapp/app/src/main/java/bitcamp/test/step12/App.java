package bitcamp.test.step12;

// 1) 낱개의 변수 사용
// 2) 낱개의 변수 재사용
// 3) 배열 사용
// 4) 클래스를 이용하여 데이터 타입 정의(중첩 클래스 중 로컬 클래스)
// 5) 출력 기능을 별도의 메서드로 분리(중첩 클래스)
// 6) 합계 및 평균을 계산하는 기능을 메소드로 분리
// 7) GRASP 패턴 중 Information Expert(정보 전문가) - 정보를 갖고 있는 클래스가 그 정보를 다룬다.
//    -> 여기서는 Score라는 클래스가 정보를 가지고 있고 이 정보를 다루는 메서드 compute()가 Score클래스에 위치해야한다.
// 8) 인스턴스 메서드 도입
// 9) 객체 생성이 번거롭고 복잡한 경우 메서드로 분리하는 것이 낫다.(디자인패턴; 팩토리 메서드)
// 10) GRASP 패턴 중 Information Expert 
//     -> createScore()를 score 클래스로 이동
// 11) 생성자 도입 : 인스턴스 변수를 보다 쉽게 초기화 시키기
// 12) 클래스를 유지보수 하기 쉽게 별도 소스 파일로 분리

public class App {
  
  public static void main(String[] args){
  
    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;

    scores[length++] = new Score("홍길동", 100, 100, 100);
    scores[length++] = new Score("임꺽정", 90, 90, 90);
    scores[length++] = new Score("유관순", 80, 80, 80);

    for(int i = 0; i < length; i++) {
      printScore(scores[i]);
    }
  } 

  

  static void printScore(Score s) {
    System.out.printf("%s: 합계=%d, 평균=%.1f\n", 
                        s.name, s.sum, s.aver);    
  }

}