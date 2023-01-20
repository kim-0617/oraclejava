package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import board.model.BoardDao;
import board.model.BoardDto;
import board.model.MemberDto;

public class BoardDeleteAction extends AbstractController {

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

		Long no = Long.parseLong(request.getParameter("no"));
		String id = userInfo.getId();

		MemberDto memberDto = new MemberDto();
		memberDto.setId(id);

		BoardDto boardDto = new BoardDto();
		boardDto.setNo(no);
		boardDto.setMemberDto(memberDto);

		System.out.println(boardDto);

		BoardDao boardDao = BoardDao.getInstance();
		boolean result = boardDao.deleteBoard(boardDto);

		ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
		if (result) {
			mav.addObject("msg", no + "번 글 삭제 성공");
			mav.addObject("url", "BoardList.do");
		} else {
			mav.addObject("msg", "글 삭제 실패");
			mav.addObject("url", "javascript:history.back()");
		}
		return mav;
	}

}
