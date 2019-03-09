package com.mmt.flyfish.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mmt.flyfish.entity.User;

public interface IUserDao extends CrudRepository<User, Integer> {
	User findById(int id);

	List<User> findByName(String name);
}
