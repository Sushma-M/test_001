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
 * ServiceImpl object for domain model class Productcatalog.
 * @see com.testhsql.sales.Productcatalog
 */
@Service("sales.ProductcatalogService")
public class ProductcatalogServiceImpl implements ProductcatalogService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProductcatalogServiceImpl.class);

    @Autowired
    @Qualifier("sales.ProductcatalogDao")
    private WMGenericDao<Productcatalog, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Productcatalog, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "salesTransactionManager")
     public Page<Productcatalog> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "salesTransactionManager")
    @Override
    public Productcatalog create(Productcatalog productcatalog) {
        LOGGER.debug("Creating a new productcatalog with information: {}" , productcatalog);
        return this.wmGenericDao.create(productcatalog);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "salesTransactionManager")
    @Override
    public Productcatalog delete(Integer productcatalogId) throws EntityNotFoundException {
        LOGGER.debug("Deleting productcatalog with id: {}" , productcatalogId);
        Productcatalog deleted = this.wmGenericDao.findById(productcatalogId);
        if (deleted == null) {
            LOGGER.debug("No productcatalog found with id: {}" , productcatalogId);
            throw new EntityNotFoundException(String.valueOf(productcatalogId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "salesTransactionManager")
    @Override
    public Page<Productcatalog> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all productcatalogs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "salesTransactionManager")
    @Override
    public Page<Productcatalog> findAll(Pageable pageable) {
        LOGGER.debug("Finding all productcatalogs");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "salesTransactionManager")
    @Override
    public Productcatalog findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding productcatalog by id: {}" , id);
        Productcatalog productcatalog=this.wmGenericDao.findById(id);
        if(productcatalog==null){
            LOGGER.debug("No productcatalog found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return productcatalog;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "salesTransactionManager")
    @Override
    public Productcatalog update(Productcatalog updated) throws EntityNotFoundException {
        LOGGER.debug("Updating productcatalog with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getProductId();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "salesTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


