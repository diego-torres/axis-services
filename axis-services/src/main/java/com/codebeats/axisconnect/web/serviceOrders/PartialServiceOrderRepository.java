/**
 * 
 */
package com.codebeats.axisconnect.web.serviceOrders;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dtorresf
 *
 */
@Repository
public interface PartialServiceOrderRepository extends CrudRepository<PartialServiceOrder, Integer> {

}
