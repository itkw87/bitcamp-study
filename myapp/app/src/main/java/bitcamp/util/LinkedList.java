package bitcamp.util;

public class LinkedList implements List {
  Node head;
  Node tail;
  int size;

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    System.out.println(list.add(Integer.valueOf(100)));
    System.out.println(list.add(Integer.valueOf(200)));
    System.out.println(list.add(Integer.valueOf(300)));
    System.out.println(list.add(Integer.valueOf(400)));
    System.out.println(list.add(Integer.valueOf(500)));

    print(list);

    // System.out.println(list.remove(Integer.valueOf(300)));
    // System.out.println(list.remove(Integer.valueOf(500)));
    // System.out.println(list.remove(Integer.valueOf(100)));
    // System.out.println(list.remove(Integer.valueOf(200)));
    // System.out.println(list.remove(Integer.valueOf(400)));
    // System.out.println(list.remove(Integer.valueOf(600)));

    System.out.println(list.remove(2));
    System.out.println(list.remove(3));
    System.out.println(list.remove(0));
    System.out.println(list.remove(0));
    System.out.println(list.remove(0));

    list.add(Integer.valueOf(1000));
    list.add(Integer.valueOf(2000));

    print(list);

    // System.out.println(list.retieve(200));
    // System.out.println(list.retieve(300));
    // System.out.println(list.retieve(500));
    // System.out.println(list.retieve(600));
  }

  static void print(LinkedList list) {
    Object[] arr = list.toArray();
    for (Object obj : arr) {
      System.out.print(obj);
      System.out.print(", ");
    }
    System.out.println();
  }

  @Override
  public boolean add(Object value) {
    Node node = new Node();
    node.value = value;

    if (this.head == null) {
      this.head = node;
    } else if (this.tail != null) {
      this.tail.next = node;
    }

    this.tail = node;
    size++;
    return true;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[this.size];

    Node cursor = this.head;
    for (int i = 0; i < this.size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }

  @Override
  public Object get(int index) {
    if (!isValid(index)) {
      return null;
    }

    Node cursor = this.head;

    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }

  @Override
  public boolean remove(Object value) {
    Node prev = null;
    Node cursor = this.head;

    while (cursor != null) {
      if (cursor.value.equals(value)) {
        // 삭제할 노드가 시작 노드라면
        if (prev == null) {
          head = cursor.next;

          // 삭제할 노드가 시작노드면서 끝 노드라면
          if (head == null) {
            tail = null;
          }
        } else if (cursor.next == null) { // 삭제할 노드가 그냥 끝 노드라면
          tail = prev;
          tail.next = null;
        } else {
          // 중간 노드라면 다음 노드의 주소를 이전 노드에 저장한다.
          prev.next = cursor.next;
        }
        size--;

        // 가바지 객체를 초기화시켜 가비지가 인스턴스를 가리키지 않도록 한다.
        cursor.next = null;
        cursor.value = null;

        return true;
      }
      // 현재 커서가 가리키는 노드를 prev에 보관한다.
      prev = cursor;

      // 현재 커서를 다음 노드로 이동한다.
      cursor = cursor.next;
    }
    return false;
  }

  @Override
  public Object remove(int index) {
    if (!isValid(index)) {
      return null;
    }

    Node prev = null;
    Node cursor = this.head;

    // 삭제하려는 값이 있는 노드까지 이동한다.
    for (int i = 0; i < index; i++) {
      prev = cursor; // 다음 노드로 이동하기 전에 현재 커서가 가리키는 노드를 prev에 보관한다.
      cursor = cursor.next; // 커서를 다음 노드로 이동시킨다.
    }

    // 삭제할 값을 리턴할 수 있도록 보관한다.
    Object old = cursor.value;

    // 삭제할 노드가 시작 노드라면
    if (prev == null) {
      head = cursor.next;

      // 삭제할 노드가 시작노드면서 끝 노드라면
      if (head == null) {
        tail = null;
      }
    } else if (cursor.next == null) { // 삭제할 노드가 그냥 끝 노드라면
      tail = prev;
      tail.next = null;
    } else {
      // 중간 노드라면 다음 노드의 주소를 이전 노드에 저장한다.
      prev.next = cursor.next; // 현재 커서의 다음 노드를 현재 커서의 이전 노드와 연결한다.
    }
    size--;

    // 가바지 객체를 초기화시켜 가비지가 인스턴스를 가리키지 않도록 한다.
    cursor.next = null;
    cursor.value = null;
    return old;
  }

  @Override
  public int size() {
    return this.size;
  }


  private boolean isValid(int index) {
    return index >= 0 && index < this.size;
  }

  static class Node {
    Object value;
    Node next;
  }
}
