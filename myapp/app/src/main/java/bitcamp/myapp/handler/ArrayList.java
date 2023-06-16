package bitcamp.myapp.handler;

public class ArrayList {
  private static final int DEFAULT_SIZE = 3;
  private Object[] list = new Object[DEFAULT_SIZE];
  private int length;

  public void add(Object obj) {
    if (this.length == list.length) {
      increase();
    }
    this.list[this.length++] = obj;
  }

  public void increase() {
    // 기존 배열 보다 50% 큰 배열을 새로 만든다.
    Object[] arr = new Object[list.length + (list.length >> 1)];

    // 기존 배열의 값을 새 배열로 복사한다.
    for (int i = 0; i < list.length; i++) {
      arr[i] = list[i];
    }
    // boards 레퍼런스가 새 배열을 가리티도록 한다.
    list = arr;

    // System.out.println("배열을 늘렸음!");
  }

  public Object[] list() {
    // 리턴할 값을 담을 배열을 생성
    Object[] arr = new Object[this.length];

    // 원본 배열에서 입력된 인스턴스 주소를 꺼내
    // 새 배열에 담는다.
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }

  public Object get(Object obj) {
    for (int i = 0; i < this.length; i++) {
      Object item = this.list[i];
      if (item.equals(obj)) { // JVM은 item이 가리키는 객체에서 부터 상위클래스까지 equals()메서드가 있는지 찾아올라간다.
        return item;
      }
    }
    return null;
  }


  public boolean delete(Object obj) {
    int deletedIndex = indexOf(obj);
    if (deletedIndex == -1) {
      return false;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.list[i] = this.list[i + 1];
    }
    this.list[--this.length] = null;

    return true;
  }


  private int indexOf(Object obj) {
    for (int i = 0; i < this.length; i++) {
      Object item = this.list[i];
      if (item.equals(obj)) {
        return i;
      }
    }
    return -1;
  }
}
