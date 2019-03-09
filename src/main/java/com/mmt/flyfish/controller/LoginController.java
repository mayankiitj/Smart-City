package com.mmt.flyfish.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.flyfish.entity.User;
import com.mmt.flyfish.repository.IUserDao;

@RestController
@RequestMapping(value = "/user")
public class LoginController {

	@Autowired
	IUserDao userDao;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public @ResponseBody boolean authenticate(@RequestBody @NotNull User credential) {
		try {
			if (StringUtils.isEmpty(credential.getId()) || StringUtils.isEmpty(credential.getPassword())) {
				return false;
			}
			User user = userDao.findById(credential.getId());
			if (credential.getPassword().equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody String signup(@RequestBody @NotNull User credential) {
		try {
			if (StringUtils.isEmpty(credential.getName()) || StringUtils.isEmpty(credential.getPassword())) {
				return "name or password is incorrect";
			}
			List<User> user = userDao.findByName(credential.getName());
			if (!CollectionUtils.isEmpty(user)) {
				return "user is already registered";
			}
			userDao.save(credential);

			return "user successfully registered";

		} catch (Exception e) {
			return "some error occured";
		}
	}
}
