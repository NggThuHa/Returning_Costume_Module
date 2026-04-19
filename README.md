# Module 3: Trả đồ và thanh toán
-----
# 1. Pha yêu cầu
## 1.1. Bảng thuật ngữ

## 1.2. Mô hình nghiệp vụ
### 1.2.1. Mục đích và phạm vi của hệ thống
- Đây là ứng dụng máy tính để bàn cho phép quản lý việc trả trang phục và thanh toán trong nội bộ cửa hàng cho thuê trang phục biểu diễn.
- Phạm vi: 
    -  Ứng dụng: máy tính để bàn (có thể chạy trên nhiều máy của các nhân viên khác nhau nhưng đồng bộ cơ sở dữ liệu). 
    - Phạm vi sử dụng: bên trong cửa hàng 
    - Người dùng: chỉ cho các nhân viên của cửa hàng, bao gồm: 
        - Quản lý cửa hàng 
        - Nhân viên thu ngân 
- Chức năng:  Cho khách hàng trả trang phục và thanh toán.
### 1.2.2. Ai được sử dụng hệ thống và sử dụng để làm gì? 
Chỉ nhân viên thu ngân được sử dụng hệ thống này và có thể sử dụng chức năng trả trang phục và thanh toán.
### 1.2.3. Các chức năng của hệ thống hoạt động như thế nào?  
- Khi khách hàng đến trả trang phục, nhân viên thu ngân đăng nhập và hệ thống và chọn menu "Trả đồ và thanh toán".
- Nhân viên hỏi tên đầy đủ của khách hàng. Khách hàng cung cấp tên của mình.
- Nhân viên nhập tên khách hàng vào ô tìm kiếm và click “Tìm kiếm”.  
- Hệ thống hiển thị danh sách các khách hàng có tên vừa nhập, và kèm với các thông tin khác của khách hàng, bao gồm:  
    - Mã khách hàng
    - Tên khách hàng
    - Số điện thoại
    - Email
    - Địa chỉ
- Nhân viên chọn đúng khách hàng cần xử lý trả trang phục. 
- Nếu không tìm thấy khách hàng, nhân viên kiểm tra lại thông tin tìm kiếm. Nếu vẫn không tìm thấy, thông báo cho quản lý/admin.  
- Nếu có nhiều khách hàng có cùng tên xuất hiện, nhân viên hỏi thêm thông tin như số điện thoại, email, địa chỉ khách hàng. Dựa vào các thông tin đó để tìm kiếm khách hàng cần tìm. 
- Sau khi chọn đúng khách hàng, hệ thống hiện lên danh sách các trang phục mà khách hàng đó đã trả và chưa trả, mỗi trang phục trên một dòng với các thông tin bảo gồm:  
    - Danh sách trang phục chưa trả:
        - Mã trang phục
        - Tên trang phục
        - Ngày mượn
        - Giá mượn
        - Giá gốc (cọc)
        - Số lượng mượn
        - Sô lượng trả (mặc định để trống)
    - Danh sách trang phục đã trả:
        - Mã trang phục
        - Tên trang phục
        - Ngày mượn
        - Ngày trả
        - Số lượng trả
        - Tổng tiền thuê
        - Tổng tiền phạt
- Nhân viên điền số lượng trả vào ô số lượng trả của các trang phục mà khách hàng đem trả (có thể không trả hết 1 lần), sau đó click nút "Tiếp" để sang màn hình cập nhật tình trạng trang phục.
- Nếu nhân viên chưa điền số lượng trả vào ô số lượng trả của các trang phục mà khách hàng đem trả, hệ thống sẽ hiển thị thông báo "Vui lòng điền số lượng trả".
- Hệ thống hiện lại giao diện gồm danh sách các trang phục được trả và danh sách lỗi trang phục:  
    - Danh sách trang phục được trả:
        - Mã trang phục
        - Tên trang phục
        - Ngày mượn
        - Số lượng trả
        - Tiền mượn = số lượng trả * tiền mượn 1 trang phục
        - Ghi chú
    - Danh sách lỗi trang phục khi mượn:
        - Mã trang phục
        - Tên trang phục
        - Tên lỗi
        - Ngày phát hiện lỗi (ngày thuê)
        - Số lượng trang phục bị lỗi
        - Ghi chú
    - Danh sách lỗi trang phục khi trả:
        - Mã trang phục
        - Tên trang phục
        - Tên lỗi
        - Số lượng trang phục lỗi
        - Tổng phí phạt = số lượng trang phục lỗi * tiền phạt 1 trang phục
        - Ghi chú
- Với mỗi trang phục:
    - Nhân viên kiểm tra tình trạng thực tế.
    - Nếu có lỗi khi trả (hư hỏng, thiếu hoặc mất phụ kiện, ...), nhân viên thêm trang phục kèm lỗi vào danh sách lỗi trang phục khi trả cùng số lượng trang phục bị lỗi.
    - Nếu không có lỗi, nhân viên không thêm trang phục vào danh sách lỗi trang phục khi trả.
    - Nếu lỗi chưa có trong hệ thống, nhân viên chọn "Thêm lỗi" và điền các thông tin gồm:
        - Tên lỗi
        - Mô tả lỗi
        - Tiền phạt
        - Ghi chú
    - Nếu lỗi đã có trong hệ thống, nhân viên chọn lỗi từ danh sách lỗi đã có trong hệ thống.
- Sau khi cập nhật trạng thái trang phục được trả, nhân viên kéo xuống và click nút “Hoàn thành”. 
- Hệ thống hiển thị phiếu trả đồ kèm các đồ cọc có thể trả trong đợt này bao gồm:  
    - Mã hóa đơn
    - Ngày lập hóa đơn (ngày trả)
    - Tên nhân viên thu ngân
    - Thông tin khách hàng
    - Danh sách trang phục được trả:
        - Mã trang phục
        - Tên trang phục
        - Ngày mượn
        - Số lượng trả
        - Số tiền mượn
        - Ghi chú
    - Danh sách lỗi trang phục khi trả:
        - Mã trang phục
        - Tên trang phục
        - Tên lỗi
        - Số lượng trang phục lỗi
        - Tổng phí phạt = số lượng trang phục lỗi * tiền phạt 1 trang phục
        - Ghi chú
    - Tổng số tiền mượn
    - Tổng số tiền phạt
    - Tổng số tiền phải trả = Tổng số tiền mượn + Tổng số tiền phạt
    - Danh sách đồ cọc có thể trả:
        - Mã đồ cọc
        - Tên đồ cọc
        - Số lượng
        - Giá trị cọc
        - Ghi chú
- Quy tắc xử lý cọc:
    - Cọc chỉ được trả khi khách hàng trả hết các trang phục đã thuê trong một đợt thuê (phiếu mượn).
    - Hệ thống tự động cập nhật tình trạng thuê, nếu phiếu trả đã được trả hết, hệ thống tự động đánh dấu phiếu mượn là đã trả hết và hiển thị danh sách đồ cọc có thể trả.
- Khách hàng kiểm tra các thông tin trong phiếu, sau đó nhân viên kéo xuồng và click "Xác nhận"
- Hệ thống hiển thị thông báo "Giao dịch thành công", in phiếu trả đồ và cập nhật vào cơ sở dữ liệu.
- Nhân viên có thể chọn "Hủy" để hủy giao dịch.
### 1.2.3. Các đối tượng cần xử lý:
- Khách hàng:
    - Mã khách hàng
    - Tên khách hàng
    - Số điện thoại
    - Email
    - Địa chỉ
    - Ghi chú (nếu có)
- Nhân viên:
    - Mã nhân viên
    - Tên nhân viên
    - Số điện thoại
    - Chức vụ
- Cửa hàng:
    - Mã cửa hàng
    - Tên cửa hàng
    - Liên lạc
    - Địa chỉ
- Trang phục:
    - Mã trang phục
    - Tên trang phục
    - Màu sắc
    - Kích cỡ
    - Mô tả
    - Giá gốc
    - Sô lượng tồn kho
    - Khu vực
- Lỗi:
    - Mã lỗi
    - Tên lỗi
    - Mô tả lỗi
    - Tiền phạt
- Đồ cọc:
    - Mã đồ cọc
    - Tên đồ cọc
    - Giá trị cọc
- Phiếu mượn:
    - Mã phiếu mượn
    - Ngày mượn
    - Thông tin khách hàng
    - Thông tin nhân viên
    - Danh sách trang phục mượn
    - Danh sách lỗi trang phục khi mượn
    - Danh sách đồ cọc
    - Tổng số tiền cọc
- Phiếu trả đồ:
    - Mã phiếu trả đồ
    - Ngày trả
    - Thông tin khách hàng
    - Thông tin nhân viên
    - Danh sách trang phục trả
    - Danh sách lỗi trang phục khi trả
    - Tổng số tiền mượn
    - Tổng số tiền phạt
    - Tổng số tiền phải trả
### 1.2.5. Quan hệ giữa các đối tượng 
- Một cửa hàng có thể có nhiều trang phục. 
- Một trang phục có thể được thuê bởi nhiều khách hàng (ở nhiều thời điểm khác nhau)  
- Một khách hàng có thể thuê một hoặc nhiều trang phục. 
- Một khách hàng có thể sở hữu nhiều phiếu mượn. 
- Một khách hàng có thể có nhiều hóa đơn trả đồ. 
- Một phiếu mượn chỉ có thể thuộc về một khách hàng. 
- Một phiếu trả đồ chỉ có thể thuộc về một khách hàng. 
- Một nhân viên thu ngân có thể lập nhiều phiếu mượn. 
- Một nhân viên thu ngân có thể xử lý nhiều hóa đơn trả đồ. 
- Một phiếu trả đồ chỉ được xử lý bởi một nhân viên thu ngân. 
- Một phiếu mượn chỉ được lập bởi một nhân viên thu ngân. 
- Một phiếu mượn có thể bao gồm nhiều trang phục. 
- Một phiếu trả đồ có thể bao gồm nhiều trang phục được trả. 
- Một trang phục có thể xuất hiện trong nhiều phiếu mượn tại các thời điểm khác nhau. 
- Một trang phục có thể xuất hiện trong nhiều phiếu trả đồ ở các lần giao dịch khác nhau. 
 
## 1.3. Business model by UML
### 1.3.1. Actor
- Actor là người dùng trực tiếp: Nhân viên thu ngân. Các actor này đều cùng là nhân viên trong cửa hàng cho thuê trang phục biểu diễn, nên có quan hệ kế thừa từ actor này. 
- Actor là người dùng gián tiếp: Khách hàng, dù không trực tiếp sử dụng và thao tác trên hệ thống, nhưng một số chức năng phải có khách hàng tham gia thì mới thực hiện được như: cho thuê trang phục, cho khách hàng trả trang phục.  
### 1.3.2. Các sub use case 
- Đăng nhập vào hệ thống 
- Xem giao diện của thu ngân 
- Tìm kiếm khách hàng 
- Xem thông tin khách hàng, danh sách trang phục đã trả và chưa trả 
- Kiểm tra thông tin trang phục được trả. 
- Ghi lại các tình trạng trang phục được trả và tiền phạt. 
- Thêm tình trạng trang phục mới 
- Xem thông tin và xuất hóa đơn 
### 1.3.3. Sơ đồ use case
- Các use case được mô tả như sau: 
    - Đăng nhập hệ thống: Use case này cho phép nhân viên thu ngân đăng nhập hệ thống. 
    - Xem giao diện của thu ngân: Use case này cho phép nhân viên thu ngân xem giao diện của thu ngân. 
    - Tìm kiếm khách hàng: Use case này cho phép nhân viên tìm kiếm khách hàng. 
    - Xem thông tin khách hàng, danh sách trang phục đã trả và chưa trả: Use case này cho phép nhân viên thu xem thông tin khách hàng và danh sách phiếu mượn: Use case này cho phép nhân viên thu ngân xem thông tin khách hàng và danh sách phiếu mượn. 
    - Kiểm tra thông tin trang phục được trả: Use case này cho phép nhân viên thu ngân kiểm tra thông tin trang phục được trả. 
    - Ghi lại tình trạng trang phục được trả và tiền phạt: Use case này cho phép nhân viên thu ngân ghi lại tình trạng trang phục được trả và tiền phạt. 
    - Thêm tình trạng trang phục mới: Use case này cho phép nhân viên thu ngân thêm tình trạng trang phục mới. 
    - Xem thông tin và xuất hóa đơn: Use case này cho phép nhân viên thu ngân xem thông tin và xuất hóa đơn. 

# 2. Pha phân tích
## 2.1. Kịch bản
<table border="1" style="border-collapse: collapse; width: 100%; text-align: left;" cellpadding="8">
  <tbody>
    <tr>
      <td><b>Scenario</b></td>
      <td>Cho khách hàng trả trang phục</td>
    </tr>
    <tr>
      <td><b>Actor</b></td>
      <td>Nhân viên thu ngân, Khách hàng</td>
    </tr>
    <tr>
      <td><b>Pre-condition</b></td>
      <td>
        <ul style="margin: 0; padding-left: 20px;">
          <li>Nhân viên thu ngân có tài khoản đúng định dạng.</li>
          <li>Khách hàng đã mượn một số lượng trang phục và cần trả.</li>
        </ul>
      </td>
    </tr>
    <tr>
      <td><b>Post-condition</b></td>
      <td>Khách hàng trả trang phục thành công.</td>
    </tr>
    <tr>
      <td><b>Main events</b></td>
      <td>
        <ol style="margin: 0; padding-left: 20px;">
          <li>Nhân viên thu ngân A đăng nhập vào hệ thống với username là A, mật khẩu là a@123 để khách hàng trả trang phục. </li>
          <li>Hệ thống hiện giao diện chính của nhân viên thu ngân, có lựa chọn “Trả trang phục và thanh toán”. </li>
          <li>Thu ngân chọn chức năng "Trả trang phục và thanh toán".</li>
          <li>Hệ thống hiện giao diện, yêu cầu thu ngân tìm kiếm khách hàng theo tên khách hàng, email hoặc số điện thoại. </li>
          <li>Thu ngân yêu cầu khách hàng cung cấp tên.</li>
          <li>Khách hàng cung cấp tên cho thu ngân.</li>
          <li>Thu ngân nhập tên khách hàng vào ô tìm kiếm.</li>
          <li>Hệ thống tìm kiếm và hiển thị danh sách khách hàng có tên trùng với tên khách hàng được cung cấp.</li>
          <ul>
              <li>Thanh tìm kiếm theo tên khách hàng</li>
              <li>Thanh tìm kiếm theo email </li>
              <li>Thanh tìm kiếm theo số điện thoại</li>
              <li>Nút tìm kiếm</li>
              <li>Nút "Quay lại"</li>
              <li>Danh sách khách hàng</li>
              <table>
                <tr>
                  <td>Mã</td>
                  <td>Họ tên</td>
                  <td>Địa chỉ</td>
                  <td>Số điện thoại</td>
                  <td>Email</td>
                  <td>Ghi chú</td>
                </tr>
                <tr>
                  <td>123</td>
                  <td>Nguyễn Văn B</td>
                  <td>Hà Nội</td>
                  <td>0123456789</td>
                  <td>b@gmail.com</td>
                  <td></td>
                </tr>
              </table>
            </ul>
          <li>Nhân viên thu ngân chọn đúng khách hàng trả trang phục. </li>
          <li>Hệ thống hiện ra giao diện thông tin khách hàng kèm danh sách trang phục đang mượn và đã trả cùng danh sách lỗi đã vi phạm của khách hàng đó:  </li>
          <ul>
            <li>Thông tin khách hàng</li>
            <table>
              <tr>
                <td>Mã</td>
                <td>Họ tên</td>
                <td>Địa chỉ</td>
                <td>Số điện thoại</td>
                <td>Email</td>
                <td>Ghi chú</td>
              </tr>
              <tr>
                <td>123</td>
                <td>Nguyễn Văn B</td>
                <td>Hà Nội</td>
                <td>0123456789</td>
                <td>b@gmail.com</td>
                <td></td>
              </tr>
            </table>
            <li>Danh sách trang phục đang mượn</li>
            <table>
              <tr>
                <td>Mã</td>
                <td>Tên trang phục</td>
                <td>Ngày mượn</td>
                <td>Giá cọc</td>
                <td>Giá mượn</td>
                <td>Số lượng mượn</td>
                <td>Số lượng trả</td>
              </tr>
              <tr>
                <td>123</td>
                <td>Áo dài cách tân đen nữ size XL </td>
                <td>10/03/2026</td>
                <td>1000</td>
                <td>10</td>
                <td>2</td>
                <td>0</td>
              </tr>
              <tr>
                <td>124</td>
                <td>Áo dài cách tân trắng nữ size L </td>
                <td>11/03/2026</td>
                <td>900</td>
                <td>10</td>
                <td>3</td>
                <td>0</td>
              </tr>
              <tr>
                <td>125</td>
                <td>Áo dài truyền thống đỏ nữ size M </td>
                <td>12/03/2026</td>
                <td>750</td>
                <td>15</td>
                <td>2</td>
                <td>0</td>
              </tr>
            </table>
            <li>Danh sách trang phục đã trả</li>
            <table>
              <tr>
                <td>Mã</td>
                <td>Tên trang phục</td>
                <td>Ngày mượn</td>
                <td>Ngày trả</td>
                <td>Số lượng</td>
                <td>Tiền thuê</td>
                <td>Tiền phạt</td>
              </tr>
              <tr>
                <td>123</td>
                <td>Áo dài cách tân đen nữ size M </td>
                <td>01/03/2026</td>
                <td>08/03/2026</td>
                <td>2</td>
                <td>160000</td>
                <td>0</td>
              </tr>
            </table>
            <li>Danh sách đồ đang cọc</li>
            <table>
              <tr>
                <td>Mã</td>
                <td>Tên cọc</td>
                <td>Ngày cọc</td>
                <td>Số lượng cọc</td>
                <td>Số tiền</td>
                <td>Ghi chú</td>
              </tr>
              <tr>
                <td>123</td>
                <td>Tiền mặt</td>
                <td>01/03/2026</td>
                <td>1</td>
                <td>1000000</td>
                <td></td>
              </tr>
            </table>
            <li>Nút "Tiếp"</li>
            <li>Nút "Hủy"</li>
          </ul>
          <li>Nhân viên yêu cầu khách hàng đưa trang phục cần trả.</li>
          <li>Khách hàng đưa trang phục cho nhân viên thu ngân. </li>
          <li>Nhân viên điền số lượng trả cho trang phục tương ứng, bấm [Tiếp].</li>
          <li>Hệ thống hiển thị giao diện để nhân viên thu ngân xác nhận trả đồ và kiểm tra tình trạng đồ gồm: </li>
          <ul>
            <li> Ngày trả: 16/03/2026</li>
            <li>Thông tin khách hàng</li>
            <table>
              <tr>
                <td>Mã</td>
                <td>Họ tên</td>
                <td>Địa chỉ</td>
                <td>Số điện thoại</td>
                <td>Email</td>
                <td>Ghi chú</td>
              </tr>
              <tr>
                <td>123</td>
                <td>Nguyễn Văn B</td>
                <td>Hà Nội</td>
                <td>0123456789</td>
                <td>b@gmail.com</td>
                <td></td>
              </tr>
            </table>
            <li>Danh sách trang phục được trả:</li>
            <table>
              <tr>
                <td>Mã</td>
                <td>Tên trang phục</td>
                <td>Ngày mượn</td>
                <td>Số lượng</td>
                <td>Tiền thuê</td>
              </tr>
              <tr>
                <td>123</td>
                <td>Áo dài cách tân đen nữ size M </td>
                <td>10/03/2026</td>
                <td>2</td>
                <td>120</td>
              </tr>
              <tr>
                <td>124</td>
                <td>Áo dài cách tân trắng nữ size L </td>
                <td>11/03/2026</td>
                <td>1</td>
                <td>50</td>
              </tr>
            </table>
            <li>Danh sách lỗi trang phục khi mượn:</li>
            <table>
              <tr>
                <td>Mã</td>
                <td>Tên trang phục</td>
                <td>Tên lỗi</td>
                <td>Số lượng trang phục lỗi</td>
                <td>Ngày phát hiện</td>
                <td>Ghi chú</td>
              </tr>
            </table>
            <li>Danh sách lỗi trang phục khi trả:</li>
            <table>
              <tr>
                <td>Mã</td>
                <td>Tên trang phục</td>
                <td>Tên lỗi</td>
                <td>Số lượng trang phục lỗi</td>
                <td>Tiền phạt</td>
                <td>Ghi chú</td>
              </tr>
              <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </table>
            <li>Tổng tiền mượn: 170</li>
            <li>Tổng tiền phạt: 0</li>
            <li>Nút "Hoàn thành"</li>
            <li>Nút "Hủy"</li>
          </ul>
          <li>Trang phục không có lỗi, nhân viên chọn [Hoàn thành].</li>
          <li>Hệ thống hiện Phiếu trả đồ kèm tổng tiền mượn, cọc, chênh lệch.</li>
          <ul>
            <li>Mã hóa đơn: 123</li>
            <li>Ngày trả: 16/03/2026</li>
            <li>Tên nhân viên: Nguyễn Văn A</li>
            <li>Thông tin khách hàng</li>
            <table>
              <tr>
                <td>Mã</td>
                <td>Họ tên</td>
                <td>Địa chỉ</td>
                <td>Số điện thoại</td>
                <td>Email</td>
                <td>Ghi chú</td>
              </tr>
              <tr>
                <td>123</td>
                <td>Nguyễn Văn B</td>
                <td>Hà Nội</td>
                <td>0123456789</td>
                <td>b@gmail.com</td>
                <td></td>
              </tr>
            </table>
            <li>Danh sách trang phục được trả:</li>
            <table>
              <tr>
                <td>Mã</td>
                <td>Tên trang phục</td>
                <td>Ngày mượn</td>
                <td>Số lượng</td>
                <td>Tiền thuê</td>
              </tr>
              <tr>
                <td>123</td>
                <td>Áo dài cách tân đen nữ size M </td>
                <td>10/03/2026</td>
                <td>2</td>
                <td>120</td>
              </tr>
              <tr>
                <td>124</td>
                <td>Áo dài cách tân trắng nữ size L </td>
                <td>11/03/2026</td>
                <td>1</td>
                <td>50</td>
              </tr>
            </table>
            <li>Danh sách lỗi trang phục khi mượn:</li>
            <table>
              <tr>
                <td>Mã</td>
                <td>Tên trang phục</td>
                <td>Tên lỗi</td>
                <td>Số lượng trang phục lỗi</td>
                <td>Ngày phát hiện</td>
                <td>Ghi chú</td>
              </tr>
            </table>
            <li>Danh sách lỗi trang phục khi trả:</li>
            <table>
              <tr>
                <td>Mã</td>
                <td>Tên trang phục</td>
                <td>Tên lỗi</td>
                <td>Số lượng trang phục lỗi</td>
                <td>Tiền phạt</td>
                <td>Ghi chú</td>
              </tr>
              <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </table>
            <li>Danh sách cọc được trả:</li>
            <table>
              <tr>
                <td>Mã</td>
                <td>Tên cọc</td>
                <td>Ngày cọc</td>
                <td>Số lượng cọc</td>
                <td>Số tiền</td>
                <td>Ghi chú</td>
              </tr>
            </table>
            <li>Tổng tiền mượn: 170</li>
            <li>Tổng tiền phạt: 0</li>
            <li>Tổng số tiền cần thanh toán: 170</li>
            <li>Xác nhận</li>
            <li>Hủy</li>
          </ul>
          <li>Nhân viên thu ngân đọc các thông tin trong phiếu trả và hỏi lại khách hàng về các thông tin trên phiếu trả. </li>
          <li>Khách hàng xác nhận thông tin chính xác.</li>
          <li>Nhân viên nhấn [Xác nhận].</li>
          <li>Hệ thống in phiếu và lưu DB.</li>
          <li>Nhân viên thu ngân đưa phiếu trả cho khách hàng, thông báo với khách hàng là đã trả đồ thành công. </li>
        </ol>
      </td>
    </tr>
    <tr>
      <td><b>Exception</b></td>
      <td>
        <b>2. Đăng nhập thất bại:</b> Bấm OK -> Quay lại đăng nhập -> Nhập đúng -> Vào hệ thống.<br><br>
        <b>8. Trùng tên/Không thấy KH:</b> Hỏi thêm SĐT/Email -> Tìm lại -> Hiện đúng KH.<br><br>
        <b>10. Sai số lượng:</b> Bấm OK -> Nhập lại đúng số lượng -> Thanh toán.<br><br>
        <b>15. Tình trạng thực tế không có trong hệ thống:</b> Chọn "Thêm tình trạng" -> Nhập chi tiết/phí phạt -> Bấm Thêm -> Hệ thống cập nhật lại tiền.<br><br>
      </td>
    </tr>
  </tbody>
</table>

## 2.2. Biểu đồ lớp thực thể
- Bước 1: Mô tả module bằng một đoạn văn
```
Hệ thống quản lý cửa hàng cho thuê trang phục biểu diễn cho phép nhân viên cửa hàng quản lý thông tin trang phục, cũng như quản lý việc mượn và trả trang phục. Module khách hàng trả đồ và thanh toán được thực hiện bởi nhân viên thu ngân và khách hàng, trong đó khách hàng mang trang phục đã mượn tới cửa hàng, nhân viên thu ngân tiến hành lấy thông tin khách hàng, tìm kiếm khách hàng và phiếu mượn trên hệ thống, tìm kiếm và kiểm trang phục được trả và thanh toán. Trong trường hợp trang phục được trả có lỗi, nhân viên thu ngân ghi lại lỗi lên trên hệ thống và thu phì phạt theo kèm số tiền thuê trang phục khi thanh toán. Nếu lỗi chưa có trên hệ thống, nhân viên thêm lỗi mới vào hệ thống. Cuối cùng in hóa đơn gồm tổng số tiền thuê, tổng số tiền phạt và số tiền cọc cần trả lại cho khách hàng. 
```
- Bước 2 + 3: Trích và đánh giá các danh từ:
    - Nhân viên thu ngân &rarr; Lớp User (username, password, fullname, role) 
    - Khách hàng &rarr; Lớp Client (fullname, email, tel, address, note) 
    - Trang phục &rarr; Lớp Costume (barcode, name, color, size, price, quantity, zone, description) 
    - Cửa hàng &rarr; Lớp Store (name, address, tel, description) 
    - Hệ thống &rarr; Danh từ trừu tượng &rarr; Loại 
    - Username/Password &rarr; Thuộc tính của lớp User 
    - Giao diện &rarr; Danh từ trừu tượng &rarr; Loại 
    - Thông tin khách hàng &rarr; Thuộc tính của lớp Client 
    - Nút/Checkbox &rarr; Danh từ trừu tượng &rarr; Loại 
    - Thông tin trang phục &rarr; Thuộc tính của lớp Costume 
    - Lỗi trang phục &rarr; Lớp Damage (name, detail, fee, note) 
    - Phí phạt &rarr; Thuộc tính của lớp Damage 
    - Máy in phiếu &rarr; Ngoài phạm vi hệ thống &rarr; Loại 
    - Phiếu trả đồ  &rarr; Lớp ReturnedReceipt (barcode, returnedAt, totalRentedFee, totalFineFee, note) 
    - Phiếu mượn đồ &rarr; Lớp RentedReceipt (barcode, rentedAt, saleoff, note) 
    - Thông tin phiếu trả &rarr; Thuộc tính của lớp ReturnedReceipt 
    - Số tiền thuê trang phục &rarr; Thuộc tính của lớp ReturnedReceipt 
    - Số tiền phạt &rarr; Thuộc tính của lớp ReturnedReceipt 
    - Cọc &rarr; Lớp DepositItem (name, value, note) 
- Bước 4 + 5: Xét quan hệ giữa các lớp và bổ sung các quan hệ đối tượng 
    - Quan hệ giữa các lớp thực thể được xác định như sau: 
    - Mỗi cửa hàng có thể có nhiều trang phục, mỗi trang phục lại chỉ thuộc về một cửa hàng duy nhất nên quan hệ Store – Costume là 1 – n. 
    - Mỗi khách hành có thể trả trang phục nhiều lần nên sẽ có nhiều phiếu trả đồ  (những lần khác nhau), nên quan hệ giữa Client – ReturnedReceipt là 1 – n. 
    - Mỗi khách hàng có thể gồm nhiều trang phục, mỗi trang phục lại có thể thuộc nhiều phiếu mượn khách nhau (ở những thời điểm khách nhau), vậy nên quan hệ giữa RentedReceipt – Costume là n – n. Ta cần một lớp ở giữa là RentedCostume. Mỗi RentedReceipt và Costumer ta xác định được duy nhất một RentedCostume.  
    - Mỗi khách hàng có thể chọn trả nhiều trang phục đã mượn, mỗi trang phục đã mượn lại có thể thuộc nhiều phiếu trả khác nhau (ở những thời điểm khác nhau), vậy nên quan hệ giữa ReturedReceipt – RentedCostume là n – n. Ta cần một lớp ở giữa là ReturnedCostume. Mỗi ReturedReceipt và RentedCostume ta xác định được duy nhất một RentedCostume.  
    - Mỗi lần mượn đồ, mỗi lỗi trang phục sẽ có nhiều trang phục tương ứng và một trang phục được mượn có thể mắc nhiều lỗi, vậy nên mối quan hệ giữa State – RentedCostume là n – n. Ta cần một lớp giữa là RentedDamage. 
    - Mỗi lần trả đồ, mỗi lỗi trang phục sẽ có nhiều trang phục tương ứng và một trang phục được trả có thể mắc nhiều lỗi, vậy nên mối quan hệ giữa Damage – ReturnedCostume là n – n. Ta cần một lớp giữa là ReturnedDamage. 
    - Nhân viên có thể tạo ra nhiều phiếu trả đồ , nên quan hệ User – ReturnedReceipt là 1 – n. Tượng tự quan hệ User – RentedReceipt cũng là 1 – n.  
    - Mỗi lần mượn khách hàng có thể cọc nhiều vật phẩm, và một vật phẩm có thể cọc trong nhiều lần cọc, vậy nên mối quan hệ giữa DepositItem – RentedReceipt là n – n. Ta cần một lớp giữa RentedDeposit. 
- Ta có được biểu đồ lớp thực thể: 
## 2.3. Biểu đồ lớp đầy đủ
### 2.3.1. Giao diện đang nhập &rarr; LoginView 
- Nhập tên người dung: inUsername 
- Nhập mật khẩu: inPassword 
- Nút đăng nhập: subLogin 
- Hệ thống cần kiểm tra đăng nhập có đúng ko &rarr; Cần phương tức checkLogin() 
    - Đầu vào: username, password 
    - Đầu ra: Boolean 
    - Lớp chủ thể: User 
### 2.3.2. Giao diện chính của nhân viên thu ngân &rarr; CashierHomeView 
- Lựa chọn cho thuê trang phục: subRent 
- Lựa chọn cho khách hàng trả trang phục: subReturn 
- Lựa chọn đăng xuất: subLogout 
### 2.3.3. Giao diện tìm kiếm khách hàng &rarr; SearchClientView 
- Nhập tên người dung: inFullname 
- Nhập số điệnt thoại: inTel 
- Nhập email: inEmail 
- Nút tìm kiếm: subSearch 
- Nút hủy tìm kiếm, quay lại trang trước đó: subCancel 
- Hiển thị danh sách các thông tin khách hàng: outsubListClient. 
- Hệ thống cần tìm kiếm khách hàng qua tên khách hàng &rarr; Cần phương thức searchClientByFullname() 
    - Đầu vào: fullname 
    - Đầu ra: List<Client> 
    - Lớp chủ thể: Client 
- Hệ thống cần tìm kiếm khách hàng qua email khách hàng &rarr; Cần phương thức searchClientByEmail() 
    - Đầu vào: email 
    - Đầu ra: List<Client> 
    - Lớp chủ thể: Client 
- Hệ thống cần tìm kiếm khách hàng qua số điện thoại khách hàng &rarr; Cần phương thức searchClientByTel() 
    - Đầu vào: tel 
    - Đầu ra: List<Client> 
    - Lớp chủ thể: Client 
### 2.3.4. Giao diện thông tin khách hàng &rarr; ClientInfoView 
- Hiển thị thông tin khách hàng: outClientInfo 
- Hiển thị danh sách trang phục khách hàng chưa trả và đã trả:  
    - outBarcode 
    - outName 
    - outRentedAt 
    - outPrice 
    - outQuantity (Số lượng trang phục chưa trả) 
- Nhập số lượng khách muốn trả trong đợt này: inReturnQuantity 
- outReturnedAt (Với trang phục đã trả xong 100%) 
- Nút tiếp tục: subNext 
- Nút hủy tìm kiếm, quay lại trang trước đó: subCancel 
- Hệ thống lấy thông tin trang phục đã thuê kèm tình trạng đã trả hay chưa trả &rarr; searchByClient() 
    - Đầu vào: Client 
    - Đầu ra: List<RentedReceipt> 
    - Lớp chủ thể: RentedReceipt 
- Hệ thống cần tính toán số lượng trang phục chưa trả &rarr; calculateRemainedQuantity(): 
    - Đầu vào: RentedCostume 
    - Đầu ra: int 
    - Lớp chủ thể: ReturnedReceipt 
### 2.3.5. Giao diện cập nhật tình trạng trang phục &rarr; ReturnProcessingView 
- Hiển thị ngày trả trang phục: outReturnedAt 
- Hiển thị thông tin khách hàng: outClientInfo 
- Hiển thị danh sách trang phục được chọn trả đợt này:  
    - outBarcode 
    - outName 
    - outRentedAt 
    - outReturnQuantity (Số lượng đang trả) 
    - outRentedCost 
- Hiển thị danh sách lỗi của trang phục khi thuê: 
    - outCostumeBarcode 
    - outCostumeName 
    - outRentedAt 
    - outDamageName 
    - outDamageQuantity 
    - outFineFee 
- Hiển thị danh sách lỗi của trang phục khi trả: 
    - outinCostumeBarcode 
    - outinCostumeName 
    - outRentedAt 
    - outinDamageName 
    - outinDamageQuantity 
    - outFineFee 
- Nút thêm lỗi trang phục: subAddDamage 
- Hiển thị tổng tiền thuê trang phục đợt này: outTotalRentedCost 
- Hiển thị tổng tiền phạt đợt này: outTotalFineFee 
- Nút hoàn thành: subFinish 
- Nút hủy tìm kiếm, quay lại trang trước đó: subCancel 
- Hệ thống cần tính tiền thuê trang phục theo ngày và số lượng trả &rarr; calculateRentedFee(): 
    - Đầu vào: returnedAt, rentedAt, quantity 
    - Đầu ra: rentedCost 
    - Lớp chủ thể: ReturnedCostume 
- Hệ thống cần cập nhật lại trạng thái trang phục do người dung mắc lỗi (rách, bẩn, …) &rarr; addReturnedDamage(): 
    - Đầu vào: ReturnedCostume, Damage 
    - Đầu ra: boolean 
    - Lớp chủ thể: ReturnedCostume 
### 2.3.6. Giao diện thêm lỗi trang phục mới &rarr; AddDamageView 
- Nhập tên trạng thái: inName 
- Nhập mô tả trạng thái: inDetail 
- Nhập phí phạt cho trạng thái: inFee 
- Nhập ghi chú: inNote 
- Nút thêm lỗi mới: subAdd 
- Nút hủy tìm kiếm, quay lại trang trước đó: subCancel 
- Hệ thống cần xử lý thêm lỗi vi phạm &rarr; addDamage(): 
    - Đầu vào: name, detail, fee, note	 
    - Đầu ra: Boolean 
    - Lớp chủ thể: Damage 
### 2.3.7. Giao diện xác nhận phiếu trả trang phục &rarr; ConfirmView 
- Hiển thị phiếu trả: outReturnedReceipt 
- Danh sách cọc trả đợt này: outReturnedDeposit 
- Nút xác nhận và in phiếu: subConfirm 
- Nút hủy và quay lại: subCancel 
- Hệ thống cần tính toán tổng tiền cho hóa đơn (tiền thuê, tiền phạt) &rarr; calculateTotalReceipt() 
    - Đầu vào: List<ReturnedCostume> 
    - Đầu ra: ReturnedReceipt 
    - Lớp chủ thể: ReturnedReceipt 
- Hệ thống cần cộng lại số lượng trang phục vào kho &rarr; updateQuantity(): 
    - Đầu vào: costumeId, returnQuantity 
    - Đầu ra: Boolean 
    - Lớp chủ thể: Costume 
- Khi xác nhận, hệ thống lưu phiếu trả mới &rarr; addReturnedReceipt():  
    - Đầu vào: ReturnedReceipt 
    - Đầu ra: Boolean 
    - Lớp chủ thể: ReturnedReceipt 
- Hệ thống kiểm tra xem phiếu mượn gốc đã hoàn thành chưa để kích hoạt luồng trả cọc &rarr; checkReturnedDeposit(): 
    - Đầu vào: rentedReceiptId 
    - Đầu ra: Boolean (Trả về True nếu status phiếu mượn là "Đã hoàn tất") 
    - Lớp chủ thể: RentedReceipt 

Ta được biểu đồ lớp thực thể bao gồm các lớp giao diện: 
## 2.4. Kịch bản chuẩn V2 và biều đồ tuần tự 
1. Khách hàng mang trang phục tới quầy thu ngân yêu cầu trả trang phục. 
2. Thu ngân đăng nhập với username là A, password là a@123 trên giao diện LoginView. 
3. Lớp LoginView gọi lớp User để xử lý. 
4. Lớp User thực hiện hàm checkLogin(). 
5. Lớp User trả về kết quả đăng nhập thành công cho LoginView. 
6. Lớp LoginView gọi lớp CashierHomeView 
7. Lớp CashierHomeView hiển thị cho thu ngân. 
8. Thu ngân chọn chức năng “Cho khách hàng trả trang phục” 
9. Lớp CashierHomeView gọi lớp SearchClientView 
10. Lớp SearchClientView hiển thị cho thu ngân 
11. Thu ngân hỏi tên khách hàng. 
12. Khách hàng trả lời cho thu ngân 
13. Thu ngân nhập tên khách hàng vào thanh tìm kiếm theo tên khách hàng. 
14. Lớp SearchClientView gọi lớp Client. 
15. Lớp Client thực hiện hàm searchClientByFullname(). 
16. Lớp Client trả về khách hàng cần tìm cho lớp SearchClientView. 
17. Lớp SearchClientView hiển thị khách hàng tìm được cho thu ngân. 
18. Thu ngân bấm chọn vào khách hàng được hiển thị. 
19. Lớp SearchClientView gọi lớp ClientInfoView 
20. Lớp ClientInfoView gọi lớp RentedReceipt. 
21. Lớp RentedReceipt thực hiện hàm searchByClient(). 
22. Lớp RentedReceipt trả về danh sách trang phục khách hàng chưa trả và đã trả cho lớp ClientInfoView. 
23. Lớp ClientInfoView hiển thị danh sách trang phục chưa trả và đã trả cho thu ngân. 
24. Thu ngân yêu cầu khách hàng trao trả trang phục đã thuê. 
25. Khách hàng giao lại trang phục cho đã thuê thu ngân. 
26. Thu ngân kiểm kê trang phục được trả và tick vào ô chọn trả ở các trang phục đó và bấm Next. 
27. Lớp ClientInfoView gọi lớp UpdateStateView 
28. Lớp UpdateStateView hiển thị cho thu ngân. 
29. Thu ngân nhập số lượng trang phục được trả. 
30. Lớp UpdateStateView gọi lớp ReturnedCostume. 
31. Lớp ReturnedCostume thực hiện hàm calculateRentedFee(). 
32. Lớp ReturnedCostume trả về số tiền thuê trang phục cho lớp UpdateStateView. 
33. Lớp UpdateStateView hiển thị số tiền thuê cho thu ngân. 
34. Thu ngân nhấn vào nút hoàn thành. 
35. Lớp UpdateStateView gọi lớp ConfirmView 
36. Lớp ConfirmView gọi lớp ReturnedReceipt. 
37. Lớp ReturnedReceipt thực hiện hàm calculateTotalReceipt(). 
38. Lớp ReturnedReceipt trả về phiếu trả sau khi được tính toán cho lớp ConfirmView. 
39. Lớp ConfirmView hiển thị thông tin cho thu ngân. 
40. Thu ngân đọc các thông tin cho khách hàng. 
41. Khách hàng xác nhận với thu ngân. 
42. Thu ngân thực hiện thanh toán số tiền chênh lệnh cho khách hàng. 
43. Khách hàng xác nhận đã nhận tiền. 
44. Thu ngân bấm nút xác nhận. 
45. Lớp ConfirmView gọi lớp ReturnedReceipt. 
46. Lớp ReturnedReceipt thực hiện hàm addReturnReceipt(). 
47. Lớp ReturnedReceipt trả về kết quả cho lớp ConfirmView. 
48. Lớp ConfirmView gọi lớp RentedCostume. 
49. Lớp RentedCostume thực hiên hàm updateRentedStatus(). 
50. Lớp RentedCostume trả về kết quả cho lớp ConfirmView. 
51. Lớp ConfirmView gọi lớp Costume. 
52. Lớp Costume thực hiện hàm updateQuantity(). 
53. Lớp Costume trả về kết quả cho lớp ConfirmView. 
54. Lớp ConfirmView báo trả đồ thành công cho thu ngân. 
55. Thu ngân thông báo quá trình trả đồ thành công cho khách hàng.

Ta có được biểu đồ tuần tự:
# 3. Pha thiết kế
## 3.1. Thiết kế lớp thực thể
- Bước 1: Hoàn thiện lớp và thuộc tính: 
    - Thêm ID vào tất cả các lớp. 
    - Bổ xung kiểu cho thuộc tính. 
- Bước 2: Chuyển các quan hệ Association thành quan hệ Aggregation/Composition tương ứng: 
    - Costume + RentedReceipt &rarr; RentedCostume được chuyển thành: Costume là thành phần của RentedCostume, RentedCostume là thành phần của RentedReceipt. 
    - RentedCostume + ReturnedReceipt &rarr; ReturnedCostume được chuyển thành: RentedCostume là thành phần của ReturnedCostume, ReturnedCostume là thành phần của ReturnedReceipt. 
    - DepositItem + RentedReceipt &rarr; RentedDeposit được chuyển thành: DepositItem là thành phần của RentedDeposit, RentedDeposit  là thành phần của RentedReceipt. 
    - RentedCostume + Damage &rarr; RentedDamage được chuyển thành: Damage là thành phần của RentedDamage, RentedDamage là thành phần của RentedCostume. 
    - ReturnedCostume + Damage &rarr; ReturnedDamage được chuyển thành: Damage là thành phần của ReturnedDamage, ReturnedDamage là thành phần của ReturnedCostume. 
- Bước 3: Bổ xung thuộc tính đối tượng tương ứng theo quan hệ thành phần: 
    - Client là thành phần của RentedReceipt, quan hệ 1 – n &rarr; RentedReceipt chứa một Client. 
    - User là thành phần của RentedReceipt, quan hệ 1 – n &rarr; RentedReceipt chứa một User. 
    - Client là thành phần của ReturnedReceipt, quan hệ 1 – n &rarr; ReturnedReceipt chứa một Client. 
    - User là thành phần của ReturnedReceipt, quan hệ 1 – n &rarr; ReturnedReceipt chứa một User. 
    - Costume là thành phần của Store, quan hệ n – 1 &rarr; Store có một danh sách Costume. 
    - DepositItem là thành phần của RentedDeposit, quan hệ 1 – n &rarr; RentedDeposit có một DepositItem. 
    - RentedDeposit là thành phần của RentedReceipt, quan hệ n – 1 &rarr; RentedReceipt có một danh sách RentedDeposit. 
    - Costume là thành phần của RentedCostume, quan hệ 1 – n &rarr; RentedCostume có một Costume. 
    - RentedCostume là thành phần của RentedReceipt, quan hệ n – 1 &rarr; RentedReceipt chứa một danh sách RentedCostume. 
    - ReturnedCostume là thành phần của ReturnedReceipt, quan hệ n – 1 &rarr; ReturnedReceipt chứa một danh sách ReturnedCostume. 
    - RentedDamage là thành phần của RentedCostume, quan hệ n – 1 &rarr; RentedCostume chứa một danh sách RentedDamage. 
    - Damage là thành phần của RentedDamage, quan hệ 1 – n &rarr; RentedDamage chứa một Damage. 
    - RentedCostume là thành phần của ReturnedCostume, quan hệ 1 – n &rarr; ReturnedCostume chứa một RentedCostume. 
    - ReturnedDamage là thành phần của ReturnedCostume, quan hệ n – 1 &rarr; ReturnedCostume chứa một danh sách ReturnedDamage. 
    - Damage là thành phần của ReturnedDamage, quan hệ 1 – n &rarr; ReturnedDamage chứa một Damage. 

Ta được biểu đồ lớp thực thể: 
## 3.2. Thiết kế cơ sở dữ liệu
- Bước 1: Với mỗi lớp thực thể tương ứng với một bảng dữ liệu có tên dạng tbl<tên lớp thực thể> 
    - Lớp User &rarr; bảng tblUser 
    - Lớp Client &rarr; bảng tblClient 
    - Lớp Store &rarr; bảng tblStore 
    - Lớp Costume &rarr; bảng tblCostume 
    - Lớp DepositItem &rarr; bảng tblDepositItem	 
    - Lớp Damage &rarr; bảng tblDamage 
    - Lớp RentedCostume &rarr; bảng tblRentedCostume 
    - Lớp RentedDeposit &rarr; bảng tblRentedDeposit 
    - Lớp RentedReceipt &rarr; bảng tblRentedReceipt 
    - Lớp RentedDamage &rarr; bảng tblRentedDamage 
    - Lớp ReturnedCostume &rarr; bảng tblReturnedCostume 
    - Lớp ReturnedReceipt &rarr; bảng tblReturnedReceipt 
    - Lớp ReturnedDamage &rarr; bảng tblReturnedDamage 
- Bước 2: Các thuộc tính không phải đối tượng của lớp nào thì chuyển thành cột của bảng tương ứng 
    - tblUser: id, username, password, fullname, role 
    - tblClient: id, fullname, email, tel, address, note 
    - tblStore: id, name, description, address, tel 
    - tblCostume: id, barcode, name, color, size, description, price, quantity, zone 
    - tblDepositItem: id, name, value, note 
    - tblDamage: id, name, detail, fee, note 
    - tblRentedCostume: id, price, quantity, saleoff 
    - tblRentedDeposit: id, rentedAt, quantity, isReturned, note 
    - tblRentedReceipt: id, barcode, rentedAt, saleoff, status, note 
    - tblRentedDamage: id, quantity, note 
    - tblReturnedCostume: id, quantity, returnedAt 
    - tblReturnedReceipt: id, barcode, returnedAt, totalRentedFee, totalFineFee, note 
    - tblReturnedDamage: id, fee, quantity, isPaid 
- Bước 3: Chuyển quan hệ số lượng giữa các lớp thành quan hệ số lượng giữa các bảng tương ứng 
    - 1 tblUser – n tblRentedReceipt 
    - 1 tblUser – n tblReturnedReceipt 
    - 1 tblClient – n tblRentedReceipt 
    - 1 tblClient – n tblReturnedReceipt 
    - 1 tblDepositItem – n tblRentedDeposit 
    - 1 tblStore – n tblCostume 
    - 1 tblCostume – n tblRentedCostume 
    - 1 tblRentedCostume – n tblReturnedCostume 
    - 1 tblRentedReceipt – n tblRentedCostume 
    - 1 tblRentedReceipt – n tblRentedDeposit 
    - 1 tblDamage – n tblRentedDamage 
    - 1 tblDamage – n tblReturnedDamage 
    - 1 tblRentedCostume – n tblRentedDamage 
    - 1 tblReturnedCostume – n tblReturnedDamage 
    - 1 tblReturnedReceipt – n tblReturnedCostume 
- Bước 4: Bổ sung khóa: Khóa chính tương ứng với thuộc tính id của bảng. Khóa ngoại được thiết lập dựa vào quan hệ số lượng với bảng khác: 
    - 1 tblUser – n tblRentedReceipt &rarr; bảng tblRentedReceipt có khóa ngoại idUser 
    - 1 tblUser – n tblReturnedReceipt &rarr; bảng tblReturnedReceipt có khóa ngoại idUser 
    - 1 tblClient – n tblRentedReceipt &rarr; bảng tblRentedReceipt có khóa ngoại idClient 
    - 1 tblClient – n tblReturnedReceipt &rarr; bảng tblReturnedReceipt có khóa ngoại idClient 
    - 1 tblDepositItem – n tblRentedDeposit &rarr; bảng tblRentedDeposit có khóa ngoại idDepositItem 
    - 1 tblStore – n tblCostume &rarr; bảng tblCostume có khóa ngoại idStore 
    - 1 tblCostume – n tblRentedCostume &rarr; bảng tblRentedCostume có khóa ngoại idCostume 
    - 1 tblRentedCostume – n tblReturnedCostume &rarr; bảng tblReturnedCostume có khóa ngoại idRentedCostume 
    - 1 tblRentedReceipt – n tblRentedCostume &rarr; bảng tblRentedCostume có khóa ngoại idRentedReceipt 
    - 1 tblRentedReceipt – n tblRentedDeposit &rarr; bảng tblRentedDeposit có khóa ngoại idRentedReceipt 
    - 1 tblReturnedReceipt – n tblReturnedCostume &rarr; bảng tblReturnedCostume có khóa ngoại idReturnedReceipt 
    - 1 tblDamage – n tblRentedDamage &rarr; bảng tblRentedDamage có khóa ngoại idDamage 
    - 1 tblDamage – n tblReturnedDamage &rarr; bảng tblReturnedDamage có khóa ngoại idDamage 
    - 1 tblRentedCostume – n tblRentedDamage &rarr; bảng tblRentedDamage có khóa ngoại idRentedCostume 
    - 1 tblReturnedCostume – n tblReturnedDamage &rarr; bảng tblReturnedDamage có khóa ngoại idReturnedCostume 
- Bước 5: Loại bỏ các thuộc tính dư thừa	 
    - Thuộc tính trùng lặp: 
        - returnedAt ở bảng tblReturnedCostume trùng với returnedAt ở bảng tblReturnedReceipt. 
        - rentedAt ở bảng tblRentedDeposit trùng với rentedAt ở bảng tblRentedReceipt. 
    - Thuộc tính dẫn xuất: 
        - totalRentedFee của bảng tblReturnedReceipt có thể được suy ra từ price ở bảng tblRentedCostume nhân với quantity ở bảng tblReturnedCostume.  
        - totalFineFee của bảng tblReturnedReceipt có thể được suy ra từ tổng (fee * quantity) ở bảng tblReturnedDamage. 

Ta có biểu đồ thực thể quan hệ: 
## 3.3. Thiết kế lớp đầy đủ
### 3.3.1. Thiết kế giao diện
### 3.3.2. Biểu đồ lớp đầy đủ
#### 3.3.2.1. LoginFrm 
- LoginFrm là giao diện đăng nhập. 
- Thuộc tính tường minh: 
    - txtUsername: JTextField 
    - txtPassword: JTextField 
    - btnLogin: JButton 
- Thuộc tính ẩn: Không có 

#### 3.3.2.2. CashierHomeFrm 
- CashierHomeFrm là giao diện trang chủ của thủ ngân. 
- Thuộc tính tường minh: 
    - btnRentCostume: JButton 
    - btnReturnCostume: JButton 
    - btnLogout: JButton 
- Thuộc tính ẩn:  
    - u: User 
#### 3.3.2.3. SearchClientFrm 
- SearchClientFrm là giao diện tìm kiếm khách hàng theo thông tin khách hàng. 
- Thuộc tính tường minh: 
    - txtFullname: JTextField 
    - txtEmail: JTextField 
    - txtTel: JTextField 
    - btnSearch: JButton 
    - tblClient: JTable 
- Thuộc tính ẩn: 
    - u: User 
#### 3.3.2.4. ClientInfoFrm 
- ClientInfoFrm là giao diện hiển thị thông tin khách hàng được chọn (khách hàng tới trả đồ) và chọn trang phục được trả cùng số lượng trả. 
- Thuộc tính tường minh: 
    - tblClient: JTable 
    - tblRentedCostume: JTable 
    - tblReturnedCostume: JTable 
    - btnNext: JButton 
    - btnCancel: JButton 
- Thuộc tính ẩn: 
    - u: User 
#### 3.3.2.5. ReturnProcessingFrm 
- ReturnProcessingFrm là giao diện cho phép nhân viên thu ngân điền ghi nhận lỗi trang phục nếu có. 
- Các thuộc tính tường minh: 
    - txtReturnedAt: JTextField 
    - tblClient: JTable 
    - tblReturnedCostume: JTable 
    - tblRentedDamage: JTable 
    - tblReturnedDamage: JTable 
    - btnAddDamage: JButton 
    - txtTotalRentedCost: JTextField 
    - txtTotalFineFee: JTextField 
    - btnFinish: JButton 
- Thuộc tính ẩn: 
    - returnedReceipt: ReturnedReceipt 
#### 3.3.2.6. AddDamageFrm 
- AddDamageFrm là giao diện cho phép nhân viên thu ngân thêm lỗi mới. 
- Các thuộc tính tường minh: 
    - txtName: JTextField 
    - txtDetail: JTextField 
    - txtFee: JTextField 
    - txtNote: JTextField 
    - btnAdd: JButton 
    - btnCancel: JButton 
- Thuộc tính ẩn: 
    - damage: Damage 
#### 3.3.2.7. ConfirmFrm 
- ConfirmFrm là giao diện xác nhận thông tin của phiếu trả và thanh toán. 
- Thuộc tính tường minh: 
    - tblClient: JTable 
    - txtReturnedAt: JTextField 
    - tblReturnedCostume: JTable 
    - tblReturnedDamage: JTable 
    - txtTotalRentedCost: JTextField 
    - txtTotalFineFee: JTextField 
    - txtTotalFeeL JTextField 
    - tblReturnedDeposit: JTable 
    - btnConfirm: JButton 
    - btnCancel: JButton 
- Thuộc tính ẩn: 
    - returnedReceipt: ReturnedReceipt 
#### 3.3.2.6. AddDamageFrm 
- AddDamageFrm là giao diện cho phép nhân viên thu ngân thêm lỗi mới. 
- Các thuộc tính tường minh: 
    - txtName: JTextField 
    - txtDetail: JTextField 
    - txtFee: JTextField 
    - txtNote: JTextField 
    - btnAdd: JButton 
    - btnCancel: JButton 
- Thuộc tính ẩn: 
    - damage: Damage 
#### 3.3.2.7. ConfirmFrm 
- ConfirmFrm là giao diện xác nhận thông tin của phiếu trả và thanh toán. 
- Thuộc tính tường minh: 
    - tblClient: JTable 
    - txtReturnedAt: JTextField 
    - tblReturnedCostume: JTable 
    - tblReturnedDamage: JTable 
    - txtTotalRentedCost: JTextField 
    - txtTotalFineFee: JTextField 
    - txtTotalFeeL JTextField 
    - tblReturnedDeposit: JTable 
    - btnConfirm: JButton 
    - btnCancel: JButton 
- Thuộc tính ẩn: 
    - returnedReceipt: ReturnedReceipt 
### 3.3.3. Các lớp DAO 
- DAO là một lớp cung cấp kết nối chung cho tất cả các lớp DAO kế thừa trong hệ thống. 
- **UserDAO**
    - UserDAO: lớp thao tác với cơ sở dữ liệu liên quan tới lớp User. 
    - Phương thức: checkLogin 
        - Input: User 
        - Output: Boolean 
- **ClientDAO**
    - ClientDAO: lớp thao tác với cơ sở dữ liệu liên quan tới lớp Client 
    - Phương thức: searchClient 
        - Input: Client 
        - Output: List<Client> 
- **CostumeDAO**
    - CostumeDAO: lớp thao tác với cơ sở dữ liệu liên quan tới lớp Costume 
    - Phương thức: updateQuantity 
        - Input: Costume 
        - Output: Boolean 
- **DamageDAO**
    - DamageDAO: lớp thao tác với cơ sở dữ liệu liên quan tới lớp Damage 
    - Phương thức: addDamage 
        - Input: Damage 
        - Output: Boolean 
- **RentedReceiptDAO**
    - RentedReceiptDAO: lớp thao tác với cơ sở dữ liệu liên quan tới lớp RentedReceipt 
    - Phương thức: searchByClient 
        - Input: Đối tượng Client. 
        - Output: List<RentedReceipt> 
    - Phương thức: checkReturnedDeposit 
        - Input: RentedReceipt 
        - Output: Boolean 
- **ReturnedReceiptDAO**
    - ReturnedReceiptDAO: lớp thao tác với cơ sở dữ liệu liên quan tới lớp ReturnedReceipt 
    - Phương thức: addReturnedReceipt 
        - Input: Đối tượng ReturnedReceipt. 
        - Output: boolean 

 

 

 

 