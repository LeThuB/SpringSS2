package SS5.Reponsitory;

import SS5.Model.Order;
import org.springframework.boot.data.autoconfigure.web.DataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderReponsitory extends JpaRepository<Order,Long> {

 List<Order> findByStatus(String status);

 List<Order> findByCustomerNameContaining(String name);

 @Query("from Order o where o.totalPrice > (select avg(o2.totalPrice) from Order o2 where month(o2.createdAt) = month(now()))")
 List<Order> findOrderHighPrice();

// @Query("select new com.example.session05.model.dto.OrderSummary(o.orderCode,o.customerName,o.totalPrice) from Order o")
// Page<OrderSummary> findAllAndPagination(DataWebProperties.Pageable pageable);
//
// @Query("SELECT new com.example.session05.model.dto.OrderSummary(o.orderCode, o.customerName, o.totalPrice) " +
//         "FROM Order o " +
//         "WHERE (:status IS NULL OR o.status = :status) " +
//         "AND (:minPrice IS NULL OR o.totalPrice >= :minPrice)")
// Page<OrderSummary> filterOrders(@Param("status") String status,
//                                 @Param("minPrice") Double minPrice,
//                                 Pageable pageable);
}
//
