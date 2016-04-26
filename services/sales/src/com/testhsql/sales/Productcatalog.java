/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testhsql.sales;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * Productcatalog generated by hbm2java
 */
@Entity
@Table(name="`productcatalog`"
)

public class Productcatalog  implements java.io.Serializable {

    
    private Integer productId;
    
    private String planCode;
    
    private String unitedHealthCarePlan;

    public Productcatalog() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`product_id`", precision=10)
    public Integer getProductId() {
        return this.productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    

    @Column(name="`planCode`", length=30)
    public String getPlanCode() {
        return this.planCode;
    }
    
    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    

    @Column(name="`unitedHealthCarePlan`", length=30)
    public String getUnitedHealthCarePlan() {
        return this.unitedHealthCarePlan;
    }
    
    public void setUnitedHealthCarePlan(String unitedHealthCarePlan) {
        this.unitedHealthCarePlan = unitedHealthCarePlan;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Productcatalog) )
		    return false;

		 Productcatalog that = (Productcatalog) o;

		 return ( (this.getProductId()==that.getProductId()) || ( this.getProductId()!=null && that.getProductId()!=null && this.getProductId().equals(that.getProductId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getProductId() == null ? 0 : this.getProductId().hashCode() );

         return result;
    }


}
