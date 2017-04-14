package login;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Login {
	AppMain main;
	Connection con;
	
	public Login(AppMain main) {
		this.main=main;
	}
	
	public void checkID(){
		//con=manager.getInstance();
		PreparedStatement pstmt=null;
		String sql="select * from member where id=? and pw=?";
		//con.prepareStatement(sql);
		
	} 
	
	
}
