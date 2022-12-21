package com.example.institutemanagementsystem.staffcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.institutemanagementsystem.staffentity.StaffEntity;
import com.example.institutemanagementsystem.staffmodel.StaffModel;
import com.example.institutemanagementsystem.stafserviceimpl.StaffService;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {
	@Autowired

	private StaffService staffService;

	@PostMapping()
	public ResponseEntity<StaffModel> create(@RequestBody StaffModel staffModel) {
		return new ResponseEntity<>(staffService.create(staffModel), HttpStatus.OK);

	}

	@GetMapping()
	public ResponseEntity<List<StaffEntity>> getAllStaff() {
		return new ResponseEntity<List<StaffEntity>>(staffService.getAllStaff(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<StaffModel> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<StaffModel>(staffService.getById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<StaffModel> update(@PathVariable("id") Long id, @RequestBody StaffModel staffModel) {
		return new ResponseEntity<StaffModel>(staffService.update(staffModel, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		staffService.delete(id);
		return new ResponseEntity<String>(("Staff id deleted Successfully"), HttpStatus.OK);
	}

}
