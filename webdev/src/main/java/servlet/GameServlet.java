package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GameServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int you = Integer.parseInt(request.getParameter("you"));
		int computer = (int) (Math.random() * 3) + 1;

		String result = "";

		if (you == computer) {
			result = "비겼습니다.";
		} else if (((you - computer + 3) % 3) == 1) {
			result = "이겼습니다";
		} else if (((you - computer + 3) % 3) == 2) {
			result = "졌습니다";
		}

		request.setAttribute("you", choice(you)); // (오브젝트 이름, 실제 오브젝트 이름)
		request.setAttribute("computer", choice(computer));
		request.setAttribute("result", result);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/game/game_action.jsp");
		dispatcher.forward(request, response);
	}

	public String choice(int key) {
		switch (key) {
			case 1:
				return "가위";
			case 2:
				return "바위";
			case 3:
				return "보";
			default:
				return "에러";
		}
	}
}
