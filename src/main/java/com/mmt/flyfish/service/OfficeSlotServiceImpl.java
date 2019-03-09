package com.mmt.flyfish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.mmt.flyfish.entity.AreaSlot;
import com.mmt.flyfish.entity.Company;
import com.mmt.flyfish.entity.Slot;
import com.mmt.flyfish.repository.IAreaSlotDao;
import com.mmt.flyfish.repository.ICompanyDao;
import com.mmt.flyfish.request.SlotCreateRequest;

@Service
public class OfficeSlotServiceImpl {

	@Autowired
	private ICompanyDao companyDao;

	@Autowired
	private IAreaSlotDao areaDao;

	public String createSlot(SlotCreateRequest slot) {

		if (slot.getCompanyId() <= 0) {
			return "company id is not valid";
		}

		Company company = companyDao.findByCompanyId(slot.getCompanyId());

		List<AreaSlot> area = areaDao
				.findByStartLatGreaterThanEqualAndEndLatLessThanEqualAndStartLongGreaterThanEqualAndEndLongLessThanEqual(
						company.getLat(), company.getLat(), company.getLng(), company.getLng());

		if (!CollectionUtils.isEmpty(area)) {
			AreaSlot areaSlot = area.get(0);
			Slot officeTime = null;
			for (Slot officeSlot : areaSlot.getAvailableSlots()) {
				if (officeSlot.getTime().equals(slot.getTime()))
					officeTime = officeSlot;
			}

			if (officeTime ==null || officeTime.getAvailableSlots() < slot.getEmployeeCount()) {
				return "not enough slots available, max allowed" + areaSlot.getAvailableSlots();
			} else {
				officeTime.setAvailableSlots(officeTime.getAvailableSlots() - slot.getEmployeeCount());
				areaDao.save(areaSlot);

				company.setUnassignedEmployee(company.getUnassignedEmployee() - slot.getEmployeeCount());
				companyDao.save(company);
				return null;
			}
		} else {
			return "no area found for company, please add are manually";
		}
	}

}
