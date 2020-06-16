package com.perficient.helm.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.perficient.helm.entity.Status;
import com.perficient.helm.entity.StatusId;

public interface StatusDao extends CrudRepository<Status, StatusId> {

	Optional<Status> findByName(String name);


}
