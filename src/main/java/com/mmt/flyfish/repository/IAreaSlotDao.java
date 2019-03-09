package com.mmt.flyfish.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mmt.flyfish.entity.AreaSlot;

@Repository
public interface IAreaSlotDao extends CrudRepository<AreaSlot, Integer> {

	List<AreaSlot> findByStartLatGreaterThanEqualAndEndLatLessThanEqualAndStartLongGreaterThanEqualAndEndLongLessThanEqual(
			double stlat, double endlat,double stlang,double endlang);

}
