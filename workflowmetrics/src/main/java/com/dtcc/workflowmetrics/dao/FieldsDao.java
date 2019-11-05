package com.dtcc.workflowmetrics.dao;

import com.dtcc.workflowmetrics.pojo.Fields;

public interface FieldsDao {

	public void addFieldDetails(Fields fields);

	public void getFieldById(Integer issueId);

}
