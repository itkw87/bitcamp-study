package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardHandler {
  static final int MAX_SIZE = 100;
  static Board[] boards = new Board[MAX_SIZE];
  static int length = 0;


  public static void inputBoard() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return; // 함수의 return값(반환타입이 void)이 없을 경우는 return만 사용가능
    }

    Board board = new Board();
    board.setTitle(Prompt.inputString("제목: "));
    board.setContent(Prompt.inputString("내용: "));
    board.setWriter(Prompt.inputString("작성자: "));
    board.setPassword(Prompt.inputString("암호: "));


    // 위에서 만든 Board 인스턴스의 주소를 잃어버리지 않게 레퍼런스 배열의 인덱스에 담는다.
    boards[length++] = board;
  }

  public static void printBoards() {
    System.out.println("-------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 작성일");
    System.out.println("-------------------------------");

    for (int i = 0; i < length; i++) {
      Board board = boards[i];

      // 5$는 기존의 5번째를 의미
      System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td\n", board.getNo(), board.getTitle(),
          board.getWriter(), board.getViewCount(), board.getCreatedDate());
    }
  }

  public static void viewBoard() {
    String boardNo = Prompt.inputString("번호? ");
    // 입력 받은 번호를 가지고 배열에서 해당 회원을 찾아야 한다.
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      // java.lang패키지에 있는 클래스(ex.Integer클래스 등)를 사용시에는 import를 작성하지 않아도 예외적으로 혀용됨.
      if (board.getNo() == Integer.parseInt(boardNo)) {
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.printf("작성자: %s\n", board.getWriter());
        board.setViewCount(board.getViewCount() + 1);
        return;
      }
    }
    System.out.println("해당 번호의 게시글이 없습니다!");
  }


  public static void updateBoard() {
    int boardNo = Prompt.inputInt("번호? ");
    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      if (board.getNo() == boardNo) {
        if (Prompt.inputString("암호? ").equals(board.getPassword())) {
          System.out.printf("제목(%s)? ", board.getTitle());
          board.setTitle(Prompt.inputString(""));
          System.out.printf("내용(%s)? ", board.getContent());
          board.setContent(Prompt.inputString(""));
          System.out.printf("작성자(%s)? ", board.getWriter());
          board.setWriter(Prompt.inputString(""));
          return;
        } else {
          System.out.println("해당 게시글의 암호와 입력하신 암호가 일치하지 않습니다!");
          return;
        }
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }



  public static void deleteBoard() {
    int boardNo = Prompt.inputInt("번호? ");
    int deletedIndex = indexOf(boardNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    if (!Prompt.inputString("암호? ").equals(boards[deletedIndex].getPassword())) {
      System.out.println("해당 게시글의 암호와 입력하신 암호가 일치하지 않습니다!");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      boards[i] = boards[i + 1];
    }

    boards[--length] = null;
  }

  private static int indexOf(int memberNo) {
    for (int i = 0; i < length; i++) {
      Board m = boards[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }
}
