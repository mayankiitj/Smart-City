package com.mmt.flyfish.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mmt.flyfish.entity.Company;

@Repository
public interface ICompanyDao extends CrudRepository<Company, Integer> {
	Company findByCompanyId(int id);
}
