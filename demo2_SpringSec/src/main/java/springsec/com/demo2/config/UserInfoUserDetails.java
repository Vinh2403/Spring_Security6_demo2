package springsec.com.demo2.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springsec.com.demo2.entity.UserInfo;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoUserDetails implements UserDetails{
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private List<GrantedAuthority> authorities;

	
	@Override
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

	public UserInfoUserDetails(UserInfo userInfo) {
		name = userInfo.getName();
		password = userInfo.getPassword();
		authorities = Arrays.stream(userInfo.getRoles().split(","))
		.map(SimpleGrantedAuthority::new)
		.collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
