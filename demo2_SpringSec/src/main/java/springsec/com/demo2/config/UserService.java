package springsec.com.demo2.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springsec.com.demo2.Repository.UserInfoRepository;
import springsec.com.demo2.entity.UserInfo;
@Service
public record UserService(UserInfoRepository repository, PasswordEncoder passwordEncoder) {
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		repository.save(userInfo);
		return "Thêm user thanh công!";

		}

}
