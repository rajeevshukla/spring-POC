package com.facebook.model.user;

import org.springframework.security.core.GrantedAuthority;

public class RoleDetails implements GrantedAuthority {

	private static final long serialVersionUID = -1851071084137455033L;
	
	private String roleName;
	private String roleDetails;

	@Override
	public String getAuthority() {

		return null;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDetails() {
		return roleDetails;
	}

	public void setRoleDetails(String roleDetails) {
		this.roleDetails = roleDetails;
	}

	@Override
	public String toString() {
		return "RoleDetails [roleName=" + roleName + ", roleDetails=" + roleDetails + "]";
	}

}
