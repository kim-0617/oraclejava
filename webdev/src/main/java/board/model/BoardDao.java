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
		String sql =
				"INSERT INTO m1board(no, title, name, password, content) VALUES(m1board_seq.nextval, ?, ?, ?, ?)";

		boolean result = false; // insert가 잘 됐는지 확인

		Connection cn = null;
		PreparedStatement ps = null; // sql 쿼리문을 실행하는 객체 참조

		try {
			cn = getConnection();

			ps = cn.prepareStatement(sql);
			ps.setString(1, boardDto.getTitle());
			ps.setString(2, boardDto.getName());
			ps.setString(3, boardDto.getPassword());
			ps.setString(4, boardDto.getContent());

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

		ResultSet rs = null; // 결과 데이터를 받아오는 객체 참조
		List<BoardDto> list = new ArrayList<BoardDto>();

		String sql =
				"SELECT no, title, name, to_char(writeday, 'YYYY-MM-DD') AS writeday, readcount from m1board ORDER BY no DESC";

		try {
			cn = getConnection();

			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setNo(rs.getLong("no"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setName(rs.getString("name"));
				boardDto.setWriteday(rs.getString("writeday"));
				boardDto.setReadcount(rs.getInt("readcount"));

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
				"SELECT no, title, name, content, to_char(writeday, 'YYYY-MM-DD') AS writeday, readcount from m1board where no=?";

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setLong(1, no);
			rs = ps.executeQuery();

			if (rs.next()) {
				boardDto = new BoardDto();
				boardDto.setNo(rs.getLong("no"));
				boardDto.setTitle(rs.getString("title"));
				boardDto.setName(rs.getString("name"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setWriteday(rs.getString("writeday"));
				boardDto.setReadcount(rs.getInt("readcount"));
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

		String sql = "UPDATE m1board SET readcount=readcount+1 WHERE no=?";
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

		String sql = "UPDATE m1board SET title=?, name=?, content=? WHERE no=? AND password=?";
		boolean result = false;

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);

			ps.setString(1, boardDto.getTitle());
			ps.setString(2, boardDto.getName());
			ps.setString(3, boardDto.getContent());
			ps.setLong(4, boardDto.getNo());
			ps.setString(5, boardDto.getPassword());

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

		String sql = "DELETE m1board WHERE no=? AND password=?";
		boolean result = false;

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);

			ps.setLong(1, boardDto.getNo());
			ps.setString(2, boardDto.getPassword());

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
