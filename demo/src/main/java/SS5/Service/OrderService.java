package SS5.Service;

import SS5.Model.Order;
import SS5.Reponsitory.OrderReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderReponsitory orderReponsitory;

    public List<Order> getOrderByStatus(String status) {
        return orderReponsitory.findByStatus(status);
    }

    public List<Order> findByCustomerName(String customerName) {
        return orderReponsitory.findByCustomerNameContaining(customerName);
    }


    public List<Order> getAllOrdersSorted(String field, String direction) {
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(field).ascending() : Sort.by(field).descending();
        return orderReponsitory.findAll(sort);

    }
    public Page<Order> getOrdersPaged(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return orderReponsitory.findAll(pageable);
    }
    public List<Order> findOrderHighPrice(){
        return orderReponsitory.findOrderHighPrice();
    };

//    public PaginationResponse<OrderSummary> findAllAndPagination(Pageable pageable){
//        Page<OrderSummary> page = orderReponsitory.findAllAndPagination(pageable);
//        PaginationResponse paginationResponse = new PaginationResponse(page);
//
//        return paginationResponse;
//    }
//
//    public PaginationResponse filterOrders(String status, Double minPrice, Pageable pageable) {
//        // Gọi repository xử lý lọc, phân trang và projection
//        Page<OrderSummary> page = orderRepository.filterOrders(status, minPrice, pageable);


    }

