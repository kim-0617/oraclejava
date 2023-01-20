package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Iam extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		System.out.println("name : " + name + " age : " + age);

		String iam = say(name, age);

		request.setAttribute("iam", iam);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ajax01/iam02.jsp");
		dispatcher.forward(request, response);
	}

	private String say(String name, int age) {
		String msg = null;

		if (name.equals("송태섭")) {
			msg = "그래 난 " + age + "세" + name + " No.1 가드";
		} else if (name.equals("서태웅")) {
			msg = "그래 난 " + age + "세" + name + " 북산 농구팀 에이스!";
		} else if (name.equals("강백호")) {
			msg = "멍청이 " + age + "세";
		} else {
			msg = "그래 난 " + age + "세" + name + " 가끔은 포기하는 남자지..";
		}

		return msg;
	}
}
