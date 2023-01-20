package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	private static BoardDao boardDao = null;
	private DataSource ds = null;

	private BoardDao() {
		try {
			// Class.forName("oracle.jdbc.OracleDriver");
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/OracleCP");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BoardDao getInstance() {
		if (boardDao == null) {
			boardDao = new BoardDao();
		}

		return boardDao;
	}

	private Connection getConnection() throws SQLException {
		// return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1",
		// "oraclejava",
		// "oraclejava");

		return ds.getConnection(); // 미리 준비된 커넥션 풀에서 하나 튕겨준다.
	}

	private void dbClose(Connection cn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (cn != null) {
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void dbClose(Connection cn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (cn != null) {
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean insertBoard(BoardDto boardDto) {
		Connection cn = null;
		PreparedStatement ps = null;

		String sql =
				"INSERT INTO tbl_board(no, title, content, id) VALUES(seq_board.nextval, ?, ?, ?)";
		boolean result = false;

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);

			ps.setString(1, boardDto.getTitle());
			ps.setString(2, boardDto.getContent());
			ps.setString(3, boardDto.getMemberDto().getId());

			ps.executeUpdate();
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps);
		}

		return result;
	}

	public List<BoardDto> getBoardList() {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<BoardDto> list = new ArrayList<BoardDto>();

		String sql =
				"SELECT b.no, b.title, b.id, b.regdate, b.readcount, m.name FROM tbl_board b join tbl_member m ON b.id=m.id ORDER BY no DESC";

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));

				BoardDto boardDto = new BoardDto();

				boardDto.setNo(rs.getLong("no"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setRegdate(rs.getString("regdate"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setReadcount(rs.getInt("readcount"));
				boardDto.setMemberDto(memberDto);

				list.add(boardDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps, rs);
		}

		return list;
	}

	public BoardDto getBoardView(Long no) {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		BoardDto boardDto = null;

		String sql =
				"SELECT b.no, b.title, b.content, b.id, b.regdate, b.readcount, m.name FROM tbl_board b join tbl_member m ON b.id=m.id WHERE b.no=?";

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);

			ps.setLong(1, no);

			rs = ps.executeQuery();

			if (rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));

				boardDto = new BoardDto();
				boardDto.setNo(rs.getLong("no"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setRegdate(rs.getString("regdate"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setReadcount(rs.getInt("readcount"));
				boardDto.setMemberDto(memberDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps, rs);
		}

		return boardDto;
	}

	public boolean updateReadCount(Long no) {
		Connection cn = null;
		PreparedStatement ps = null;

		String sql = "UPDATE tbl_board SET readcount=readcount + 1 WHERE no=?";

		boolean result = false;

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setLong(1, no);

			if (ps.executeUpdate() > 0) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps);
		}

		return result;
	}

	public boolean updateBoard(BoardDto boardDto) {
		Connection cn = null;
		PreparedStatement ps = null;

		String sql = "UPDATE tbl_board SET title=?, content=? WHERE no=? AND id=?";

		boolean result = false;

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);

			ps.setString(1, boardDto.getTitle());
			ps.setString(2, boardDto.getContent());
			ps.setLong(3, boardDto.getNo());
			ps.setString(4, boardDto.getMemberDto().getId());

			if (ps.executeUpdate() > 0) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps);
		}

		return result;
	}

	public boolean deleteBoard(BoardDto boardDto) {
		Connection cn = null;
		PreparedStatement ps = null;

		String sql = "DELETE FROM tbl_board WHERE no=? AND id=?";

		boolean result = false;

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);

			ps.setLong(1, boardDto.getNo());
			ps.setString(2, boardDto.getMemberDto().getId());

			if (ps.executeUpdate() > 0) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps);
		}

		return result;
	}
}
