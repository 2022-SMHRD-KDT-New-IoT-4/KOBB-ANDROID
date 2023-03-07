package com.kobb.model;

// 회원 
public class UserDTO {

    // 회원 아이디 
    private String user_id;

    // 회원 패스워드 
    private String user_pw;

    // 회원 가입일자 
    private String user_joindate;
    
    // 회원 매장명
    private String user_shop_name;
    
    // 회원 휴대폰 번호
    private String user_phone;
    
    

	public UserDTO() {
		super();
	
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_joindate() {
		return user_joindate;
	}

	public void setUser_joindate(String user_joindate) {
		this.user_joindate = user_joindate;
	}

	public String getUser_shop_name() {
		return user_shop_name;
	}

	public void setUser_shop_name(String user_shop_name) {
		this.user_shop_name = user_shop_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}


    

	

    

}