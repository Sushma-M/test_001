/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_001.testdb009.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.test_001.testdb009.*;

/**
 * Service object for domain model class Table2.
 * @see com.test_001.testdb009.Table2
 */

public interface Table2Service {
   /**
	 * Creates a new table2.
	 * 
	 * @param created
	 *            The information of the created table2.
	 * @return The created table2.
	 */
	public Table2 create(Table2 created);

	/**
	 * Deletes a table2.
	 * 
	 * @param table2Id
	 *            The id of the deleted table2.
	 * @return The deleted table2.
	 * @throws EntityNotFoundException
	 *             if no table2 is found with the given id.
	 */
	public Table2 delete(Integer table2Id) throws EntityNotFoundException;

	/**
	 * Finds all table2s.
	 * 
	 * @return A list of table2s.
	 */
	public Page<Table2> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Table2> findAll(Pageable pageable);
	
	/**
	 * Finds table2 by id.
	 * 
	 * @param id
	 *            The id of the wanted table2.
	 * @return The found table2. If no table2 is found, this method returns
	 *         null.
	 */
	public Table2 findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a table2.
	 * 
	 * @param updated
	 *            The information of the updated table2.
	 * @return The updated table2.
	 * @throws EntityNotFoundException
	 *             if no table2 is found with given id.
	 */
	public Table2 update(Table2 updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the table2s in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the table2.
	 */

	public long countAll();


    public Page<Table2> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

