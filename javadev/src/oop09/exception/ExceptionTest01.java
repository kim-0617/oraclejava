package oop09.exception;

public class ExceptionTest01 {
	public static void main(String[] args) {
		String str = null;

		try {
			System.out.println(str.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("무조건 실행");
		}
		System.out.println("종료");
	}
}
