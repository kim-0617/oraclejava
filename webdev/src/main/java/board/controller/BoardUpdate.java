package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import board.model.BoardDao;
import board.model.BoardDto;

public class BoardUpdate extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) {
		Long no = Long.parseLong(request.getParameter("no"));
		BoardDao boardDao = BoardDao.getInstance();
		BoardDto boardDto = boardDao.getBoardView(no);

		return new ModelAndView("/WEB-INF/board/update.jsp", "boardDto", boardDto);
	}

}
