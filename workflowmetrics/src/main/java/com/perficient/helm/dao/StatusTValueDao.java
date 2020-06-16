package com.perficient.helm.dao;

import org.springframework.data.repository.CrudRepository;

import com.perficient.helm.entity.StatusTValue;
import com.perficient.helm.entity.StatusTValueId;

public interface StatusTValueDao extends CrudRepository<StatusTValue, StatusTValueId>{


}
