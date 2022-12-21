package com.example.institutemanagementsystem.stafserviceimpl;

import java.util.List;

import com.example.institutemanagementsystem.staffentity.StaffEntity;
import com.example.institutemanagementsystem.staffmodel.StaffModel;

public interface StaffService {

	StaffModel create(StaffModel staffModel);

	public List<StaffEntity> getAllStaff();

	StaffModel getById(Long id);

	StaffModel update(StaffModel staffModel, Long id);

	void delete(Long id);

}
