package com.content.payloads;

public class ResetPasswordDto {
private String currentPassword;

private String newPassword;

public ResetPasswordDto() {
	super();
}

public String getCurrentPassword() {
	return currentPassword;
}

public void setCurrentPassword(String currentPassword) {
	this.currentPassword = currentPassword;
}

public String getNewPassword() {
	return newPassword;
}

public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
}

}
