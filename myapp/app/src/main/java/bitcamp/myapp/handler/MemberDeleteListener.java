package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class MemberDeleteListener extends AbstractMemberListener {
  public MemberDeleteListener(List list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    // if (!this.list.delete(100)) { 인자값 100 int값은 주소값이 아니라 Object타입의 매개변수로 받을 수가 없음 따라서
    // Integer타입의 인스턴스로 자동형변환(autoboxing)해서 인자값으로 넘김
    if (!this.list.remove(new Member(prompt.inputInt("번호? ")))) { // ture가 아니라면이 아니라 삭제를 못했을때
                                                                  // 라고 생각해야함 안 그러면 헷갈림
      System.out.println("해당 번호의 회원이 없습니다!");
    }
  }
}
