package oop11.api;

public class ObjectTest03 {
	public static void main(String[] args) {
		String str1 = new String("실수란 신을 용서하는 인간의 행위이다.");
		String str2 = new String("실수란 신을 용서하는 인간의 행위이다.");

		if (str1 == str2) {
			System.out.println("같다.");
		} else {
			System.out.println("다르다.");
		}

		if (str1.equals(str2)) {
			System.out.println("같다.");
		} else {
			System.out.println("다르다.");
		}

		System.out.println(str1.toString());
		System.out.println(str1.hashCode());
		System.out.println(str1 = str1.replace("실수란", "성형은"));
		System.out.println(str1.hashCode());
	}
}
