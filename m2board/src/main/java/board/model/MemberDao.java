package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	private static MemberDao memberDao = null;
	private DataSource ds = null;

	private MemberDao() {
		try {
			// Class.forName("oracle.jdbc.OracleDriver");
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/OracleCP");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MemberDao getInstance() {
		if (memberDao == null) {
			memberDao = new MemberDao();
		}

		return memberDao;
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

	public int checkID(String id) {
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int result = 0;
		String sql = "select count(*) as cnt from tbl_member where id=?";

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		} finally {
			dbClose(cn, ps, rs);
		}

		return result;
	}

	public boolean registerMember(MemberDto memberDto) {
		Connection cn = null;
		PreparedStatement ps = null;

		boolean result = false;
		String sql =
				"INSERT INTO tbl_member(id, password, name, birth, phone, zipcode, address1, address2) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);

			ps.setString(1, memberDto.getId());
			ps.setString(2, memberDto.getPassword());
			ps.setString(3, memberDto.getName());
			ps.setString(4, memberDto.getBirth());
			ps.setString(5, memberDto.getPhone());
			ps.setString(6, memberDto.getZipcode());
			ps.setString(7, memberDto.getAddress1());
			ps.setString(8, memberDto.getAddress2());

			ps.executeUpdate();
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps);
		}

		return result;
	}

	public MemberDto getUser(MemberDto memberDto) {
		MemberDto userInfo = null;

		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT id, name FROM tbl_member WHERE id=? AND password=?";

		try {
			cn = getConnection();
			ps = cn.prepareStatement(sql);

			ps.setString(1, memberDto.getId());
			ps.setString(2, memberDto.getPassword());

			rs = ps.executeQuery();

			if (rs.next()) {
				userInfo = new MemberDto();
				userInfo.setId(rs.getString("id"));
				userInfo.setName(rs.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(cn, ps, rs);
		}

		return userInfo;
	}
}
