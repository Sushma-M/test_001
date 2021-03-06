/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testhsql.sales.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.testhsql.sales.*;


/**
 * ServiceImpl object for domain model class Sale.
 * @see com.testhsql.sales.Sale
 */
@Service("sales.SaleService")
public class SaleServiceImpl implements SaleService {


    private static final Logger LOGGER = LoggerFactory.getLogger(SaleServiceImpl.class);

    @Autowired
    @Qualifier("sales.SaleDao")
    private WMGenericDao<Sale, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Sale, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "salesTransactionManager")
     public Page<Sale> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "salesTransactionManager")
    @Override
    public Sale create(Sale sale) {
        LOGGER.debug("Creating a new sale with information: {}" , sale);
        return this.wmGenericDao.create(sale);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "salesTransactionManager")
    @Override
    public Sale delete(Integer saleId) throws EntityNotFoundException {
        LOGGER.debug("Deleting sale with id: {}" , saleId);
        Sale deleted = this.wmGenericDao.findById(saleId);
        if (deleted == null) {
            LOGGER.debug("No sale found with id: {}" , saleId);
            throw new EntityNotFoundException(String.valueOf(saleId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "salesTransactionManager")
    @Override
    public Page<Sale> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all sales");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "salesTransactionManager")
    @Override
    public Page<Sale> findAll(Pageable pageable) {
        LOGGER.debug("Finding all sales");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "salesTransactionManager")
    @Override
    public Sale findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding sale by id: {}" , id);
        Sale sale=this.wmGenericDao.findById(id);
        if(sale==null){
            LOGGER.debug("No sale found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return sale;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "salesTransactionManager")
    @Override
    public Sale update(Sale updated) throws EntityNotFoundException {
        LOGGER.debug("Updating sale with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getId();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "salesTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


