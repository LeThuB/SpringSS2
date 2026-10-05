package SS2;

public class b1 {
}
//Phan 1: Tại sao chọn REST thay vì SOAP?
//Đối với ứng dụng Quản lý nhân sự, REST phù hợp hơn SOAP vì REST đơn giản, linh hoạt và dễ tích hợp.

//REST sử dụng các HTTP method có sẵn:

//GET → lấy dữ liệu

//POST → tạo dữ liệu

//PUT → cập nhật dữ liệu

//DELETE → xóa dữ liệu

//REST thường sử dụng JSON, rất phổ biến trong Web và Mobile.

// REST thường có overhead thấp hơn
//REST tận dụng trực tiếp HTTP và có cấu trúc đơn giản hơn SOAP trong nhiều trường hợp.
// Việc truyền JSON cũng thường nhẹ hơn


//Phần 2: Thiết kế RESTful API cho Employee

//Lấy danh sách tất cả sinh viên GET /employees

//Lấy thông tin một nhân viên theo ID GET /employees/{id}

//Tạo mới một nhân viên POST /employees

//Cập nhật thông tin nhân viên PUT/employees/{id}

// Xóa một nhân viên DELETE /employees/{id}