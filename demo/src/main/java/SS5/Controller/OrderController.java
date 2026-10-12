package SS5.Controller;

import SS5.Model.Order;
import SS5.Service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {

    private OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService= orderService;
    }
@GetMapping("/searchStatus")
public ResponseEntity<List<Order>> findByStatus(@RequestParam("status")String status){
        return new  ResponseEntity<>(orderService.getOrderByStatus(status), HttpStatus.OK);
}

@GetMapping("/searchByCustomer")

    public ResponseEntity<List<Order>> findByCustomer(@RequestParam("customerName")String customerName){
        return new ResponseEntity<>(orderService.findByCustomerName(customerName),HttpStatus.OK);
}

    @GetMapping("/sort")
    public ResponseEntity<List<Order>> sort(@RequestParam("sortBy") String sortBy , @RequestParam("dir") String dir) {
        return new ResponseEntity<>(orderService.getAllOrdersSorted(sortBy, dir), HttpStatus.OK);
    }

    @GetMapping("/paging")
    public ResponseEntity<Page<Order>> findByPage(@RequestParam("page") int page , @RequestParam("size") int size){
        return new ResponseEntity<>(orderService.getOrdersPaged(page,size),HttpStatus.OK);
    }

    @GetMapping("/findOrderHighPrice")
    public ResponseEntity<List<Order>> findOrderHighPrice(){
        return new ResponseEntity<>(orderService.findOrderHighPrice(), HttpStatus.OK);
    }

    @GetMapping("/findAllAndSearch")
    public ResponseEntity<PaginationResponse<OrderSummary>> findAllAndSearch(@RequestParam("page") int page, @RequestParam("size") int size){
        Pageable pageable = PageRequest.of(page,size);
        return new ResponseEntity<>(orderService.findAllAndPagination(pageable),HttpStatus.OK);
    }


}
