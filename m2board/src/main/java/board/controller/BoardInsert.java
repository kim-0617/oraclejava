package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import board.model.MemberDto;

public class BoardInsert extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto userInfo = (MemberDto) session.getAttribute("userInfo");

		if (userInfo == null) {
			ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "먼저 로그인 하셔야 합니다.");
			mav.addObject("url", "Login.do");
			return mav;
		}

		return new ModelAndView("/WEB-INF/board/insert.jsp");
	}

}
