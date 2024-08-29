package bank.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
	String jdbcURL;	//DB에 연결하기 위한 URL을 담는 String 변수
	String jdbcDriver;	//JDBC Driver를 담기 위한 String 변수
	Connection con;	//DB 연결 객체를 담는 변수
	PreparedStatement pstmt; //SQL 쿼리를 실행하기 위해 사용되는 PreparedStatement 객체를 저장하는 변수
	ResultSet rs;	// SQL 쿼리의 결과를 저장하기 위한 변수
	String sql;	//실행할 SQL문을 저장할 변수
	public AccountDAO() {	//jdbcURL과 jdbcDriver를 초기화하기 위한 생성자.
		jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe"; //DB를 사용하기 위한 주소
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";	//OracleDriver를 사용하기 위해서 jdbc 파일을 받은 것.
	}
	
	public Connection getConnection() {	//Connection 타입을 반환하는 getConnection() 메서드
		Connection conn = null;	//Connection 객체 타입 변수 conn을 선언 후 null로 초기화함.
		try {
			Class.forName(jdbcDriver);	//Class.forName() 메서드는 지정된 클래스 이름을 메모리에 로드함.
			//DriverManager.getConnection() 메서드는 지정된 URL, 사용자이름, 비밀번호를 통해 DB에 연결을 시도함.
			conn = DriverManager.getConnection(jdbcURL, "miso", "1234");
		} catch (Exception e) {	//예외처리 구문. try 블록에서 예외가 생기면 catch 구문이 실행됨.
			e.printStackTrace();	// 발생한 예외를 콘솔에 출력하는 코드
		}
		return conn;	//DB 연결 정보 객체를 반환함.
	}
	
	public void accountInsert(AccountDTO dto) {
		con = getConnection();	// DB 접속 정보
		sql = "insert into account(accountNo, owner, balance)"
				+ "values(?, ?, ?)";
		try {
			//con 객체의 prepareStatement() 메서드를 사용해서 SQL 쿼리를 컴파일하고 바로 사용할 수 있도록 준비.
			pstmt = con.prepareStatement(sql);
			//SQL 쿼리의 첫 번째 '?' 자리에 값을 바인딩함.
			pstmt.setInt(1, dto.getAccountNo());
			//SQL 쿼리의 두 번째 '?' 자리에 값을 바인딩함.
			pstmt.setString(2, dto.getOwner());
			//SQL 쿼리의 세 번째 '?' 자리에 값을 바인딩함.
			pstmt.setInt(3, dto.getBalance());
			//executeUpdate() 메서드는 SQL 쿼리를 실행시키고, SQL 쿼리에 영향을 받은 행의 수를 반환함.
			int i = pstmt.executeUpdate();	//Insert, Update, Delete에서 사용!
			System.out.println(i + "개가 삽입되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public List<AccountDTO> accountAll() {
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		con = getConnection();
		sql = "select accountNo, owner, balance from account";
		try {
			pstmt = con.prepareStatement(sql);
			//executeQuery() 메서드는 Select할 때 사용함. Query를 실행해서 나온 Recode Set을 가져옴.
			rs = pstmt.executeQuery();	//DB의 Recode Set을 Java의 Result Set에 저장.
			while(rs.next()) {
				AccountDTO dto = new AccountDTO();
				dto.setAccountNo(rs.getInt("accountNo"));
				dto.setOwner(rs.getString("owner"));
				dto.setBalance(rs.getInt(3));
				list.add(dto);
			}
		} catch(Exception e) {
			e.getStackTrace();
		}
		return list;
	}
	
	public AccountDTO accountOne(int accountNo) {
		AccountDTO dto = null;
		con = getConnection();
		sql = "select accountNo, owner, balance from account "
				+ "where accountNo = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new AccountDTO();
				dto.setAccountNo(rs.getInt("accountNo"));
				dto.setOwner(rs.getString("owner"));
				dto.setBalance(rs.getInt("balance"));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public void depositUpdate(AccountDTO dto) {
		con = getConnection();
		sql = "update account "
			  +"set balance = balance + ?"
			  +"where accountNo = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBalance());
			pstmt.setInt(2, dto.getAccountNo());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void withDrawUpdate(AccountDTO dto) {
		con = getConnection();
		sql = "update account set balance = balance - ? where accountNo = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getBalance());
			pstmt.setInt(2, dto.getAccountNo());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행이 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void close() {	//DB 사용 후 접속정보를 삭제. 닫는 순서는 켠 순서의 반대로!!
		if(rs != null) try {rs.close();} catch(Exception e) {}
		if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
		if(con != null) try {con.close();} catch(Exception e) {}
	}
}
