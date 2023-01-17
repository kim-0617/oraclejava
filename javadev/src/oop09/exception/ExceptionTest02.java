package oop09.exception;

public class ExceptionTest02 {
	public static void main(String[] args) {
		thorwException();

		System.out.println("종료");
	}

	private static void thorwException() {
		System.out.println("thorwException 메서드 수행 시작");

		try {
			throw new Exception("사용자의 강제 예외 발생");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("thorwException 메서드 수행 완료");
	}
}
