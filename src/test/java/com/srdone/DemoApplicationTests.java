package com.srdone;

import com.srdone.domain.LoginEntity;
import com.srdone.service.LoginRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

	private LoginRepository loginRepo;

	@Autowired
	public void setLoginRepo(LoginRepository loginRepo) {
		this.loginRepo = loginRepo;
	}

	@Test
	public void testAdminLoginExists() {
//		Page<LoginEntity> login = loginRepo.findByRoster("LASZLO", new PageRequest(0, 10, Sort.Direction.ASC, "userId"));
		LoginEntity adminLogin = loginRepo.findByUserId("LASZLO");
		assertEquals(adminLogin.getPassword(), "srD0ne");
	}

}
