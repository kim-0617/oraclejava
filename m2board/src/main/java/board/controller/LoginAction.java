package board.controller;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import board.model.MemberDao;
import board.model.MemberDto;
import cookie.Cooker;

public class LoginAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		int setid = 0;
		if (request.getParameter("setid") != null) {
			setid = Integer.parseInt(request.getParameter("setid"));
		}

		System.out.println("setid : " + setid);

		MemberDto memberDto = new MemberDto();
		memberDto.setId(id);
		memberDto.setPassword(password);

		System.out.println(memberDto);

		MemberDao memberDao = MemberDao.getInstance();
		MemberDto userInfo = memberDao.getUser(memberDto);

		if (userInfo != null) {
			try {
				Cookie cookie = Cooker.createCookie("id", id, setid == 1 ? 60 * 60 * 24 * 30 : 0);
				response.addCookie(cookie);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userInfo);

			return new ModelAndView("redirect:BoardList.do");
		} else {
			ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "아이디 혹은 패스워드가 틀립니다.");
			mav.addObject("url", "Login.do");
			return mav;
		}

	}

}
