/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testhsql.sales.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.testhsql.sales.*;

/**
 * Service object for domain model class ActionItem.
 * @see com.testhsql.sales.ActionItem
 */

public interface ActionItemService {
   /**
	 * Creates a new actionitem.
	 * 
	 * @param created
	 *            The information of the created actionitem.
	 * @return The created actionitem.
	 */
	public ActionItem create(ActionItem created);

	/**
	 * Deletes a actionitem.
	 * 
	 * @param actionitemId
	 *            The id of the deleted actionitem.
	 * @return The deleted actionitem.
	 * @throws EntityNotFoundException
	 *             if no actionitem is found with the given id.
	 */
	public ActionItem delete(Integer actionitemId) throws EntityNotFoundException;

	/**
	 * Finds all actionitems.
	 * 
	 * @return A list of actionitems.
	 */
	public Page<ActionItem> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<ActionItem> findAll(Pageable pageable);
	
	/**
	 * Finds actionitem by id.
	 * 
	 * @param id
	 *            The id of the wanted actionitem.
	 * @return The found actionitem. If no actionitem is found, this method returns
	 *         null.
	 */
	public ActionItem findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a actionitem.
	 * 
	 * @param updated
	 *            The information of the updated actionitem.
	 * @return The updated actionitem.
	 * @throws EntityNotFoundException
	 *             if no actionitem is found with given id.
	 */
	public ActionItem update(ActionItem updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the actionitems in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the actionitem.
	 */

	public long countAll();


    public Page<ActionItem> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

