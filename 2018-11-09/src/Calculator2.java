import javax.swing.JOptionPane;

//Calculator2 ==> CalUser2(main())
//--출력이 아닌 연산의 결과는  main에 리턴함.!
//--------------------------------------
//1. 1부터 10까지 더하는 처리를 하는 메소드 정의
//   => 메소드 호출시 시작값과 마지막값 입력

public class Calculator2 {

	public void he(String lang) { // 반환값이 없다 = void
		System.out.print("안녕하세요.");
		System.out.println("저는 " + lang + " 프로그래머 입니다.");
	}

	//////////////////////////////////////////////////////////////////////

	public int math(int a, int b) {
		return a * b;
	}


	public void sum(int a) {
		int[] num = new int[a];
		int sum = 0;

		for (int i = 0; i < num.length; i++) {// (1)번 for문 시작
			num[i] = Integer.parseInt(JOptionPane.showInputDialog("숫자를 입력하세요."));
			sum += num[i];
		} // (1)번 for문 종료
		System.out.println(sum);
	}

	//////////////////////////////////////////////////////////////////////

	public void sum2(int a, int b) {
		int sum = 0;
		if (a >= b) {
			for (int i = 0; i < a - b + 1; i++) {
				sum += b + i;
			}
		} else if (a < b) {
			for (int i = 0; i < b - a + 1; i++) {
				sum += a + i;
			}
		}

		System.out.println(sum);

	}

}
