package com.perficient.helm.dao;

import org.springframework.data.repository.CrudRepository;

import com.perficient.helm.entity.StatusCustomField;
import com.perficient.helm.entity.StatusCustomFieldId;

public interface StatusCustomFieldDao extends CrudRepository<StatusCustomField, StatusCustomFieldId>{

}
