**HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG**

**KHOA CÔNG NGHỆ THÔNG TIN I**

**HỌC PHẦN NHẬP MÔN CÔNG NGHỆ PHẦN MỀM**

**đỀ TÀI: Hệ thống quản lí cửa hàng cho thuê trang phục biểu diễn**

**Lớp: D23CTCN01-B**

**Mã nhóm: N08**

|     |     |     |
| --- | --- | --- |
| **STT** | **Thành viên** | **Mã sinh viên** |
| 1   | Nguyễn Thị Ngọc Hà | B23DCCN264 |
| **2** | **Nguyễn Tự Kiên** | **B23DCCN465** |
| 3   | Nguyễn Duy Nghĩa | B23DCCN600 |
| 4   | Phạm Văn Tư | B23DCCN879 |

**Module: “Khách hàng trả đồ và thanh toán”**

**Yêu cầu: Pha thiết kế**

**Học kỳ 2 năm học 2025 – 2026**

Mục lục

[A. Pha yêu cầu 3](#_Toc225794737)

[I. Bảng thuật ngữ 3](#_Toc225794738)

[II. Mô hình nghiệp vụ (Business model) 16](#_Toc225794739)

[1\. Mục đích và phạm vi của hệ thống 16](#_Toc225794742)

[2\. Ai được sử dụng hệ thống và sử dụng để làm gì? 16](#_Toc225794743)

[3\. Các chức năng của hệ thống hoạt động như thế nào? 17](#_Toc225794744)

[4\. Các đối tượng cần xử lý 27](#_Toc225794745)

[5\. Quan hệ giữa các đối tượng 29](#_Toc225794746)

[III. Business model by UML (Mô tả bằng UML) 30](#_Toc225794747)

[1\. Biếu đồ Use case tổng quát 30](#_Toc225794748)

[2\. Biểu đồ use case chi tiết 31](#_Toc225794750)

[B. Pha phân tích 32](#_Toc225794751)

[I. Kịch bản 32](#_Toc225794752)

[II. Biểu đồ lớp thực thể 39](#_Toc225794753)

[III. Biểu đồ lớp đầy đủ 41](#_Toc225794754)

[IV. Kịch bản chuẩn V2 và biều đồ tuần tự 44](#_Toc225794755)

# Pha yêu cầu

## Bảng thuật ngữ

|     |     |     |     |
| --- | --- | --- | --- |
| **STT** | **Thuật ngữ tiếng Việt** | **Thuật ngữ tiếng Anh** | **Giải nghĩa** |
| Nhóm khái niệm liên quan đến người |     |     |     |
| 1   | Nhân viên bán hàng | Sales Staff | Người trực tiếp tư vấn, hỗ trợ khách chọn trang phục và phối hợp lập phiếu thuê. |
| 2   | Quản lý cửa hàng | Store Manager | Người điều hành hoạt động chung của cửa hàng, giám sát nhân viên và theo dõi hiệu quả kinh doanh. |
| 3   | Quản trị viên hệ thống | System Administrator | Người quản lí tài khoản hệ thống, phân quyền truy cập và duy trì hoạt động phần mềm. |
| 4   | Nhân viên toàn thời gian | Full-time Employee | Nhân viên làm việc theo thời gian cố định toàn ngày tại cửa hàng. |
| 5   | Nhân viên bán thời gian | Part-time Employee | Nhân viên làm việc theo ca hoặc khung giờ ngắn hơn nhân viên toàn thời gian. |
| 6   | Nhân viên kho | Warehouse Staff | Người phụ trách kiểm kê, sắp xếp, bảo quản và xuất/nhập trang phục trong kho. |
| 7   | Nhân viên thu ngân | Cashier | Người lập phiếu thuê, hóa đơn trả, thu tiền cọc và xử lí thanh toán cho khách. |
| 8   | Nhân viên kiểm đồ | Return Inspection Staff | Người kiểm tra tình trạng trang phục khi khách trả, ghi nhận lỗi và đề xuất mức phạt. |
| 9   | Nhân viên giao hàng | Delivery Staff | Người phụ trách giao và nhận trang phục nếu cửa hàng có hỗ trợ vận chuyển. |
| 10  | Nhân viên chăm sóc khách hàng | Customer Service Staff | Người tiếp nhận thắc mắc, hỗ trợ khách hàng trước, trong và sau quá trình thuê. |
| 11  | Khách hàng | Customer | Người thuê trang phục từ cửa hàng để sử dụng trong một khoảng thời gian nhất định. |
| 12  | Khách hàng mới | New Customer | Khách thuê lần đầu tại cửa hàng, thường phải đặt cọc theo quy định chuẩn. |
| 13  | Khách hàng quen | Returning Customer | Khách đã từng thuê trước đó, có lịch sử giao dịch và có thể được áp dụng chính sách linh hoạt hơn. |
| 14  | Khách hàng VIP | VIP Customer | Khách hàng có giá trị cao hoặc tần suất thuê lớn, được hưởng ưu đãi đặc biệt. |
| 15  | Khách đặt trước | Pre-order Customer | Khách đặt giữ trang phục trước ngày nhận hàng. |
| 16  | Nhà cung cấp trang phục | Costume Supplier | Đơn vị cung cấp trang phục cho cửa hàng thông qua hoạt động nhập hàng. |
| 17  | Nhà cung cấp phụ kiện | Accessory Supplier | Đơn vị cung cấp các phụ kiện đi kèm như mũ, khăn, giày, đạo cụ. |
| 18  | Đối tác vận chuyển | Logistics Partner | Bên thứ ba hỗ trợ giao nhận trang phục giữa cửa hàng và khách hàng. |
| 19  | Đơn vị giặt ủi | Laundry Service Provider | Đơn vị xử lí vệ sinh, giặt, là hoặc hấp trang phục sau mỗi đợt thuê. |
| 20  | Đơn vị sửa chữa | Repair Service Provider | Đơn vị chuyên khâu vá, chỉnh sửa, thay thế chi tiết bị hỏng trên trang phục. |
| 21  | Người thuê chính | Primary Renter | Người đứng tên trên phiếu thuê và chịu trách nhiệm cho toàn bộ đơn thuê. |
| 22  | Người nhận hàng | Recipient | Người trực tiếp nhận trang phục từ cửa hàng hoặc từ đơn vị vận chuyển. |
| 23  | Người trả hàng | Returner | Người trực tiếp mang trang phục đến cửa hàng để hoàn trả. |
| Nhóm khái niệm liên quan đến vật |     |     |     |
| 24  | Trang phục | Costume | Mặt hàng chính được cửa hàng cho khách thuê để biểu diễn. |
| 25  | Phụ kiện | Accessory | Vật phẩm đi kèm trang phục như mũ, khăn, thắt lưng, giày, găng tay. |
| 26  | Bộ trang phục | Costume Set | Tập hợp nhiều món trang phục và phụ kiện được cho thuê như một gói hoàn chỉnh. |
| 27  | Mẫu trang phục | Costume Model | Thiết kế chuẩn của một loại trang phục trước khi xét đến số lượng cụ thể. |
| 28  | Chủng loại trang phục | Costume Category | Nhóm phân loại lớn của trang phục như dân gian, hiện đại, sân khấu, lễ hội. |
| 29  | Kiểu trang phục | Costume Type | Dạng hoặc loại trang phục dựa trên công năng, phong cách hoặc đối tượng sử dụng. |
| 30  | Chất liệu | Material | Loại vải hoặc vật liệu cấu thành trang phục như lụa, cotton, ren, nhung. |
| 31  | Kiểu dáng | Design Style | Hình thức thiết kế bên ngoài của trang phục như ôm sát, xòe, cổ điển, cách tân. |
| 32  | Kích cỡ | Size | Thông số thể hiện mức độ phù hợp của trang phục với vóc dáng người mặc. |
| 33  | Màu sắc | Color | Thuộc tính màu của trang phục, thường dùng để tìm kiếm và phân biệt mẫu. |
| 34  | Họa tiết | Pattern | Các chi tiết trang trí trên bề mặt trang phục như thêu, in, đính kết. |
| 35  | Tình trạng trang phục ban đầu | Initial Costume Condition | Trạng thái hiện tại của trang phục như mới, tốt, cần giặt, hư hỏng. |
| 36  | Tình trạng trang phục sau khi trả | Returned Costume Condition | Trạng thái hiện tại của trang phục như mới, tốt, cần giặt, hư hỏng. |
| 37  | Giá gốc | Original Price | Giá trị thực của trang phục, thường dùng để tính mức tiền cọc tối đa cần giữ. |
| 38  | Giá mượn | Rental Price | Chi phí khách phải trả để thuê trang phục trong đơn vị thời gian quy định. |
| 39  | Giá nhập | Purchase Price | Giá cửa hàng mua trang phục từ nhà cung cấp. |
| 40  | Số lượng tồn | Stock Quantity | Số lượng trang phục hiện có sẵn trong kho và có thể cho thuê. |
| 41  | Số lượng đang thuê | Rented Quantity | Số lượng trang phục hiện đang nằm trong các phiếu thuê chưa hoàn tất. |
| 42  | Mã trang phục | Costume ID | Mã định danh duy nhất cho từng loại hoặc từng mẫu trang phục trong hệ thống. |
| 43  | Tên trang phục | Costume Name | Tên duy nhất của từng loại trang phục. |
| 44  | Mã khách hàng | Customer ID | Mã định danh duy nhất của khách hàng trong cơ sở dữ liệu. |
| 45  | Tên khách hàng | Customer Name | Tên của mỗi khách hàng mượn trang phục. |
| 46  | Mã nhà cung cấp | Supplier ID | Mã dùng để nhận diện một nhà cung cấp cụ thể. |
| 47  | Tên nhà cung cấp | Supplier Name | Tên của mỗi nhà cung cấp. |
| 48  | Hồ sơ khách hàng | Customer Profile | Tập hợp thông tin cá nhân, liên hệ và lịch sử thuê của khách hàng. |
| 49  | Lịch sử thuê | Rental History | Danh sách các lần thuê trước đây của một khách hàng. |
| 50  | Phiếu mượn | Rental Receipt | Chứng từ ghi nhận một lần khách thuê trang phục. |
| 51  | Chi tiết phiếu mượn | Rental Order Detail | Danh sách các trang phục cụ thể kèm số lượng, giá trong một phiếu thuê. |
| 52  | Hóa đơn trả đồ | Return Receipt | Chứng từ ghi nhận một lần khách hoàn trả một phần hoặc toàn bộ trang phục đang thuê. |
| 53  | Chi tiết hóa đơn trả đồ | Return Detail | Các dòng thông tin cụ thể về từng trang phục được trả trong một hóa đơn. |
| 54  | Phiếu nhập | Purchase Receipt | Chứng từ ghi nhận một lần nhập hàng từ nhà cung cấp. |
| 55  | Chi tiết phiếu nhập | Purchase Receipt Detail | Danh sách từng loại trang phục được nhập trong một phiếu nhập. |
| 56  | Biên bản vi phạm | Fine Receipt | Chứng từ được tạo ra khi khách hàng vi phạm quy định. |
| 57  | Chi tiết biên bản vi phạm | Fine Receipt Detail | Danh sách từng loại trang phục được nhập cùng lỗi và tiền phạt trong một phiếu tr |
| 58  | Hóa đơn thanh toán | Payment Invoice | Chứng từ tổng hợp tiền thuê, tiền phạt, tiền cọc và số tiền phải thu/trả lại. |
| 59  | Lỗi hư hỏng | Damage Defect | Hư hại vật lý trên trang phục như rách, đứt, mất chi tiết. |
| 60  | Lỗi mất trang phục | Lost Costume | Trường hợp trang phục không được hoàn trả đầy đủ số lượng. |
| 61  | Lỗi thiếu phụ kiện | Missing Accessories | Trường hợp thiếu phụ kiện khi hoàn trả. |
| 62  | Vết bẩn | Stain | Dấu bẩn phát sinh trong quá trình sử dụng làm ảnh hưởng chất lượng trang phục. |
| 63  | Tiền phạt | Penalty Amount | Khoản tiền khách phải trả thêm do làm hỏng hoặc làm bẩn trang phục. |
| 64  | Tiền đặt cọc | Security Deposit | Khoản tiền cửa hàng tạm giữ để đảm bảo khách hoàn trả trang phục đúng quy định. |
| 65  | Tiền cọc cần trả | Refundable Deposit | Phần tiền đặt cọc được xác định để hoàn trả lại cho khách sau khi kiểm tra việc hoàn trả trang phục và các điều kiện liên quan. |
| 66  | Tổng tiền cần trả lại khách | Total Refund Amount | Tổng số tiền cửa hàng cần hoàn trả cho khách, bao gồm tiền cọc được trả lại sau khi đã trừ các khoản chi phí hoặc bồi thường phát sinh nếu có. |
| 67  | Doanh thu | Revenue | Tổng số tiền cửa hàng thu được từ hoạt động cho thuê và các khoản liên quan. |
| 68  | Báo cáo thống kê | Statistical Report | Tài liệu hoặc màn hình tổng hợp dữ liệu phục vụ quản lí, theo dõi và ra quyết định. |
| 69  | Trạng thái đơn thuê | Rental Status | Tình trạng hiện tại của phiếu thuê như đang thuê, trả một phần, đã tất toán. |
| 70  | Hạn trả | Due Date | Mốc thời gian khách phải hoàn trả trang phục theo thỏa thuận. |
| 71  | Thời gian thuê | Rental Duration | Khoảng thời gian tính từ lúc nhận trang phục đến lúc trả. |
| 72  | Danh mục trang phục | Costume Catalog | Tập hợp danh sách các mẫu trang phục mà cửa hàng đang quản lí. |
| 73  | Ảnh trang phục | Costume Image | Hình ảnh minh họa giúp nhận diện và hỗ trợ tìm kiếm trang phục. |
| 74  | Ghi chú đơn hàng | Order Note | Thông tin bổ sung được ghi kèm trong phiếu thuê hoặc hóa đơn trả đồ. |
| Nhóm khái niệm liên quan đến hành động |     |     |     |
| 75  | Tìm kiếm khách hàng | Search Customer | Hoạt động tra cứu khách hàng theo tên, số điện thoại hoặc mã khách hàng. |
| 76  | Thêm khách hàng mới | Add New Customer | Hoạt động nhập thông tin để tạo hồ sơ cho khách thuê lần đầu. |
| 77  | Cập nhật thông tin khách hàng | Update Customer Information | Chỉnh sửa thông tin liên hệ hoặc dữ liệu liên quan của khách hàng. |
| 78  | Tìm kiếm trang phục | Search Costume | Hoạt động tra cứu trang phục theo tên, loại, mã hoặc thuộc tính khác. |
| 79  | Thêm trang phục mới | Add New Costume | Hoạt động nhập và lưu thông tin một trang phục mới vào hệ thống. |
| 80  | Sửa thông tin trang phục | Edit Costume Information | Hoạt động chỉnh sửa các thông tin của trang phục đã có trong hệ thống. |
| 81  | Kiểm tra tồn kho | Check Inventory | Xác định số lượng trang phục hiện còn để quyết định khả năng cho thuê. |
| 82  | Chọn trang phục thuê | Select Costume for Rental | Thao tác thêm các trang phục khách muốn thuê vào phiếu thuê. |
| 83  | Nhập số lượng thuê | Enter Rental Quantity | Ghi nhận số lượng từng loại trang phục mà khách muốn thuê. |
| 84  | Tạo phiếu mượn | Create Rental Order | Hoạt động xác nhận và lưu một giao dịch thuê vào hệ thống. |
| 85  | In phiếu mượn | Print Rental Receipt | Xuất phiếu thuê ra giấy hoặc dạng in cho khách xác nhận. |
| 86  | Thu tiền cọc | Collect Deposit | Nhận khoản tiền đảm bảo từ khách tại thời điểm lập phiếu thuê. |
| 87  | Nhập hàng | Import Inventory | Tiếp nhận trang phục từ nhà cung cấp vào kho cửa hàng. |
| 88  | Lập phiếu nhập | Create Purchase Receipt | Ghi nhận chứng từ cho một lần nhập hàng. |
| 89  | Cập nhật số lượng tồn | Update Stock Quantity | Điều chỉnh số lượng tồn kho sau khi nhập, thuê hoặc trả hàng. |
| 90  | Tìm kiếm các trang phục được trả | Search Returned Costumes | Xác định các trang phục đang được khách mang tới hoàn trả. |
| 91  | Đánh dấu các trang phục được trả | Mark Returned Items | Chọn những món mà khách trả trong một lần thanh toán. |
| 92  | Điền số lượng trang phục được trả | Enter Returned Quantity | Nhập số lượng thực tế của từng loại trang phục mà khách hoàn trả. |
| 93  | Kiểm tra tình trạng trang phục | Inspect Costume Condition | Đánh giá mức độ sạch, hỏng, thiếu phụ kiện hay các vấn đề khác của trang phục. |
| 94  | Nhập tình trạng trang phục được trả | Record Returned Costume Condition | Ghi nhận kết quả kiểm tra tình trạng vào hệ thống. |
| 95  | Nhập tiền phạt | Enter Penalty Amount | Ghi nhận khoản bồi thường tương ứng với các lỗi phát sinh. |
| 96  | Tính tiền mượn | Calculate Rental Fee | Xác định số tiền thuê dựa trên thời gian thuê, giá thuê và số lượng. |
| 97  | Tính tiền cọc trả lại | Calculate Refundable Deposit | Xác định số tiền cọc được hoàn trả cho khách. |
| 98  | Tính tiền cần trả lại cho khách | Calculate Amount to Refund | Xác định số tiền cuối cùng cần hoàn trả cho khách sau khi trừ các chi phí, bồi thường hoặc khoản phát sinh liên quan. |
| 99  | Tính tiền phạt | Calculate Penalty Fee | Tổng hợp các khoản phạt do hư hỏng, bẩn hoặc vi phạm điều kiện thuê. |
| 100 | Tính tiền cọc cần giữ lại | Calculate Remaining Deposit Hold | Xác định số tiền cọc tối đa còn phải giữ sau khi khách trả một phần đồ. |
| 101 | Tạo hóa đơn trả trang phục | Create Return Invoice | Lập hóa đơn tổng hợp cho giao dịch trả đồ và thanh toán. |
| 102 | Thực hiện thanh toán | Process Payment | Thao tác thu thêm tiền hoặc hoàn tiền cho khách tùy theo kết quả tính toán. |
| 103 | Hoàn tiền cho khách | Refund Customer | Trả lại cho khách phần tiền cọc dư hoặc số tiền được hoàn. |
| 104 | Xác nhận trả đồ | Confirm Return | Xác nhận lại thông tin với khách hàng và cập nhật dữ liệu hệ thống. |
| 105 | Cập nhật trạng thái trang phục | Update Costume Status | Chuyển trạng thái trang phục sau khi kiểm tra như sẵn sàng cho thuê, cần giặt, cần sửa. |
| 106 | Giao trang phục | Deliver Costume | Bàn giao trang phục cho khách tại quầy hoặc qua dịch vụ vận chuyển. |
| 107 | Nhận lại trang phục | Receive Returned Costume | Tiếp nhận trang phục do khách hoàn trả về cửa hàng. |
| 108 | Gia hạn thuê | Extend Rental Period | Kéo dài thời gian thuê theo yêu cầu của khách, nếu cửa hàng cho phép. |
| 109 | Hủy phiếu mượn | Cancel Rental Order | Hủy giao dịch thuê trước khi đơn được hoàn tất hoặc trước khi giao hàng. |
| 110 | Thống kê trang phục được mượn nhiều | Generate Most Rented Costumes Report | Tổng hợp những trang phục có tần suất thuê cao trong một khoảng thời gian. |
| 111 | Thống kê doanh thu | Generate Revenue Report | Tổng hợp doanh thu theo tháng, quý hoặc năm để phục vụ quản lí. |
| 112 | Xem chi tiết hóa đơn | View Invoice Details | Mở thông tin chi tiết của một hóa đơn hoặc giao dịch cụ thể. |
| 113 | Kiểm kê kho | Inventory Audit | Đối chiếu số lượng thực tế trong kho với dữ liệu hệ thống. |
| 114 | Bảo dưỡng trang phục | Maintain Costume | Thực hiện giặt, sửa, phục hồi hoặc chăm sóc để trang phục đạt trạng thái sử dụng tốt. |
| 115 | Phân quyền người dùng | User Authorization | Thiết lập quyền truy cập khác nhau cho quản lí, nhân viên, quản trị viên. |
| 116 | Đăng nhập hệ thống | System Login | Hoạt động xác thực người dùng trước khi sử dụng phần mềm. |
| Nhóm khái niệm liên quan đến quy định, luật lệ |     |     |     |
| 117 | Quy định thuê trang phục | Costume Rental Regulation | Bộ quy tắc chung điều chỉnh việc thuê, sử dụng và hoàn trả trang phục. |
| 118 | Chính sách đặt cọc | Deposit Policy | Quy định về mức tiền cọc, điều kiện giữ cọc và hoàn cọc cho khách. |
| 119 | Chính sách bồi thường | Compensation Policy | Quy định xác định trách nhiệm và mức bồi thường khi trang phục bị hư hỏng hoặc thất lạc. |
| 120 | Chính sách vận chuyển | Delivery Policy | Quy định về giao nhận, phí vận chuyển, thời gian giao và phạm vi áp dụng. |
| 121 | Điều kiện trả đồ | Return Conditions | Các yêu cầu về số lượng, tình trạng và cách thức hoàn trả trang phục. |
| 122 | Quy định trả một phần | Partial Return Rule | Quy định cho phép khách trả trước một phần số đồ đã thuê thay vì phải trả hết cùng lúc. |
| 123 | Quy định hoàn cọc | Deposit Refund Rule | Quy định về thời điểm, mức hoàn và cách hoàn tiền cọc cho khách. |
| 124 | Quy định giữ cọc tối đa | Maximum Deposit Hold Rule | Quy định rằng tiền cọc giữ lại không được vượt quá tổng giá trị gốc của số đồ còn đang thuê. |
| 125 | Quy định khách thuê lần đầu | First-time Renter Rule | Quy định áp dụng riêng cho khách mới, thường yêu cầu mức cọc chặt chẽ hơn. |
| 126 | Quy định khách hàng thân thiết | Loyal Customer Policy | Chính sách ưu đãi hoặc linh hoạt hơn dành cho khách có lịch sử thuê tốt. |
| 127 | Quy định xử lí hư hỏng | Damage Handling Policy | Cách xác định lỗi, quy trình ghi nhận và nguyên tắc áp dụng mức phạt khi đồ bị hỏng. |
| 128 | Quy định xử lí vết bẩn | Stain Handling Policy | Quy định phân loại mức độ bẩn và khoản chi phí phát sinh để làm sạch hoặc phục hồi. |
| 129 | Quy định mất trang phục | Lost Item Policy | Điều khoản về trách nhiệm và số tiền bồi thường khi khách làm mất trang phục hoặc phụ kiện. |
| 130 | Quy định hủy đơn | Cancellation Policy | Quy định về việc hủy phiếu thuê, thời điểm được hủy và chi phí liên quan nếu có. |
| 131 | Quy định kiểm tra tình trạng | Condition Inspection Rule | Chuẩn mực dùng để đánh giá tình trạng trang phục lúc nhận về. |
| 132 | Quy định kiểm kê kho | Inventory Control Rule | Nguyên tắc đối chiếu tồn kho định kỳ nhằm tránh thất thoát và sai lệch dữ liệu. |
| 133 | Quy định phân quyền truy cập | Access Control Policy | Quy định ai được phép xem, sửa, xóa hoặc thống kê dữ liệu trong hệ thống. |
| 134 | Chính sách bảo mật thông tin khách hàng | Customer Data Privacy Policy | Quy định bảo vệ thông tin cá nhân, lịch sử thuê và dữ liệu thanh toán của khách hàng. |

## Mô hình nghiệp vụ (Business model)

1.  
2.  

### Mục đích và phạm vi của hệ thống

- Mục đích: Đây là ứng dụng máy tính để bàn cho phép quản lý việc thuê trang phục, trả đồ và thanh toán, thống kê trang phục được mượn nhiều và thống kê doanh thu trong nội bộ cửa hàng cho thuê trang phục biểu diễn.
- Phạm vi:
- Ứng dụng: máy tính để bàn (có thể chạy trên nhiều máy của các nhân viên khác nhau nhưng đồng bộ cơ sở dữ liệu).
- Phạm vi sử dụng: bên trong cửa hàng
- Người dùng: chỉ cho các nhân viên của cửa hàng, bao gồm:
- Quản lý cửa hàng
- Nhân viên thu ngân
- Các chức năng:
- Cho thuê trang phục
- Cho khách hàng trả trang phục.
- Xem thống kê trang phục được mượn nhiều.
- Xem thống kê doanh thu.

### Ai được sử dụng hệ thống và sử dụng để làm gì?

- Chỉ nhân viên cửa hàng có thể sử dụng ứng dụng này, bao gồm: quản lý cửa hàng, nhân viên thu ngân.
- Nhân viên thu ngân có thể sử dụng các chức năng sau:
- Cho thuê trang phục
- Cho khách hàng trả trang phục.
- Quản lý cửa hàng có thể sử dụng các chức năng sau:
- Xem thống kê.

### Các chức năng của hệ thống hoạt động như thế nào? 

1.  

#### Modul “Cho thuê trang phục” 

- Khách hàng cầm trang phục muốn thuê đến quầy nhân viên thu ngân yêu cầu làm phiếu mượn  
- Nhân viên chọn chức năng cho thuê trang phục, hệ thống hiển thị giao diện gồm:
- Ô nhập tên khách hàng để tìm kiếm
- Nút tìm kiếm
- Nhân viên hỏi tên đầy đủ của khách hàng, khách hàng cung cấp tên của mình
- Nhân viên nhập tên khách hàng và nhấp tìm kiếm

® Hệ thống truy vấn trong cơ sở dữ liệu và trả về danh sách khách hàng có tên vừa nhập gồm: mã khách hàng, tên khách hàng, số điện thoại, email, địa chỉ, ghi chú (nếu có)

® Nếu có nhiều khách hàng có cùng tên, nhân viên hỏi thêm thông tin khác của khách hàng: số điện thoại hoặc email

® Khách hàng cung cấp thông tin cho nhân viên

- Nếu khách hàng đã có trong danh sách hiển thị (khách hàng đã từng thuê trang phục)

® Nhân viên click chọn đúng vào dòng ứng với khách hàng

- Nếu khách hàng không có trong dách sách hiển thị (khách hàng lần đầu mượn)

® Nhân viên thực hiện thêm mới khách hàng

® Nhân viên hỏi thông tin cá nhân của khách hàng

® Khách hàng cung cấp thông tin cho nhân viên

® Nhân viên nhập thông tin khách hàng và click thêm mới khách hàng vào hệ thống

® Hệ thống thêm thông tin khách hàng vào và nhảy đến giao diện tìm kiếm khách hàng theo tên

® Nhân viên tiến hành nhập tên của khách hàng mới thêm vào ô nhập và ấn tìm kiếm

® Hệ thống hiển thị giao diện thêm trang phục mượn vào phiếu

- Hệ thống hiện giao diện thêm trang phục mượn vào phiếu, giao diện hệ thống gồm:
- Mã phiếu mượn (hệ thống tự động cập nhật)
- Ngày mượn (mặc định là ngày hiện tại)
- Người tạo phiếu mượn
- Thông tin khách hàng: tên, số điện thoại, email, địa chỉ, ghi chú (nếu có)
- Nút tìm kiếm trang phục
- Bảng kết quả tìm kiếm
- Bảng danh sách trang phục mượn
- Ô tổng tiền cọc (có thể chỉnh sửa)
- Nút next
- Nhân viên click chọn nút tìm kiếm trang phục
- Hệ thống hiện giao diện tìm kiếm trang phục theo tên gồm:
- Ô nhập tên trang phục
- Nút tìm kiếm
- Với mỗi trang phục được khách hàng mượn, nhân viên tiến hành nhập tên trang phục và nhấn nút tìm kiếm

® Hệ thống hiện lên danh sách các trang phục có tên vừa nhập, chỉ hiển thị các trang phục trong trạng thái sẵn sàng cho thuê (không hiện trang phục đang sửa hoặc chờ sửa), bao gồm:

- Mã trang phục
- Tên trang phục
- Số lượng còn lại
- Giá gốc
- Nhân viên click chọn dòng đúng với trang phục do khách hàng chọn thuê

® Hộp thoại nhập số lượng hiện ra gồm: ô nhập số lượng trang phục mượn, nút Next

® Nhân viên đếm số trang phục thuộc cùng loại trang phục đó và xác nhận lại với khách hàng

® Khách hàng xác nhận số lượng trang phục muốn mượn với nhân viên

® Nhân viên nhập đúng số lượng đó và ấn Next

® Hệ thống hiển thị giao diện chi tiết trang phục mượn để nhân viên kiểm kê lại tình trạng hiện tại của trang phục, giao diện bao gồm:

- Mã trang phục
- Mã phiếu mượn
- Số lượng mượn
- Bảng tình trạng trang phục, gồm: Tình trạng trang phục (Tốt/Bẩn nhẹ/Lỗi nhỏ), số lượng, ghi chú (nếu có)
- Nút lưu để thêm vào phiếu

® Nhân viên kiểm tra từng bộ trang phục và yêu cầu khách hàng xác nhận lại tình trạng từng bộ trang phục

® Khách hàng xác nhận lại tình trạng trạng phục với nhân viên

® Nhân viên nhập số lượng và tình trạng từng bộ trang phục vào hệ thống và ấn nút xác nhận

® Hệ thống tự động thêm 1 dòng chứa thông tin chi tiết của trang phục vào phiếu mượn và quay lại giao diện thêm trang phục vào phiếu mượn

- Lặp lại thao tác tìm kiếm trang phục, nhập số lượng và xác nhận cho đến khi hết các trang phục khách hàng muốn mượn
- Khi đã tiến hành nhập hết các trang phục do khách hàng chọn thuê

® Nhân viên tiến hành nhập tiền cọc:

- Nếu khách hàng đã từng thuê trang phục (khách quen)

® Mức cọc do nhân viên và khách hàng tự thỏa thuận

® Nhân viên sửa lại ô tổng tiền cọc và click next

- Nếu khách hàng là khách hàng mới (lần đầu thuê)

® Nhân viên click next, hệ thống tự động tính tiền cọc theo công thức:

Tổng số tiền cần đặt cọc = tổng giá gốc của mỗi trang phục x số lượng mượn trang phục đó

- Hệ thống hiển thị giao diện xác nhận tạo phiếu mượn lên màn hình, giao diện bao gồm:
- Mã phiếu mượn
- Ngày giờ mượn
- Người tạo phiếu
- Thông tin cá nhân khách hàng gồm: tên, số điện thoại, email, địa chỉ, ghi chú (nếu có)
- Danh sách trang phục mượn, mỗi dòng bao gồm: mã trang phục, tên trang phục, số lượng trang phục mượn (kèm tình trạng), ghi chú tình trạng trang phục, giá gốc của mỗi trang phục
- Tổng số tiền cần đặt cọc
- Nút xác nhận
- Nút quay lại
- Nút in phiếu mượn
- Nhân viên đọc lại toàn bộ thông tin phiếu mượn cho khách hàng và yêu cầu khách hàng xác nhận
- Khách hàng xác nhận lại thông tin với nhân viên
- Nhân viên click xác nhận để lưu dữ liệu vào hệ thống và click in phiếu mượn
- Hệ thống in phiếu mượn ra
- Nhân viên đưa phiếu mượn cho khách hàng
- Khách hàng nhận phiếu mượn, ký xác nhận và đóng tiền cọc đúng theo trong phiếu
- Nhân viên nhận tiền cọc

#### Modul “Khách hàng trả đồ và thanh toán”

- Khi khách hàng đến trả trang phục, nhân viên thu ngân chọn menu “Tìm danh sách trang phục mượn theo tên khách hàng”.
- Nhân viên hỏi tên đầy đủ của khách hàng. Khách hàng cung cấp tên của mình.
- Nhân viên nhập tên khách hàng vào ô tìm kiếm và click “Tìm kiếm”.
- Hệ thống hiển thị danh sách các khách hàng có tên vừa nhập, và kèm với các thông tin khác của khách hàng, bao gồm:
- Mã khách hàng
- Tên khách hàng
- Số điện thoại
- Email
- Địa chỉ khách hàng
- Nhân viên chọn đúng khách hàng cần xử lý trả trang phục.
- Nếu không tìm thấy khách hàng, nhân viên kiểm tra lại thông tin tìm kiếm. Nếu vẫn không tìm thấy, thông báo cho quản lý/admin.
- Nếu có nhiều khách hàng có cùng tên xuất hiện, nhân viên hỏi thêm thông tin như số điện thoại, email, địa chỉ khách hàng. Dựa vào các thông tin đó để tìm kiếm khách hàng cần tìm.
- Sau khi chọn đúng khách hàng, hệ thống hiện lên danh sách các trang phục mà khách hàng đó đã trả và chưa trả, mỗi trang phục trên một dòng với các thông tin bảo gồm:
- Danh sách trang phục chưa trả:
- Mã trang phục
- Tên trang phục
- Ngày mượn
- Giá mượn
- Giá gốc
- Số lượng mượn
- Tình trạng trang phục khi mượn
- Ô chọn trả
- Danh sách trang phục đã trả:
- Mã trang phục
- Tên trang phục
- Ngày mượn
- Ngày trả
- Tình trạng trang phục khi trả
- Số lượng trả
- Nhân viên tick vào ô chọn trả cho các trang phục mà khách hàng đem trả (có thể không trả hết 1 lần), sau đó click nút “Tiếp” để qua bước cập nhật trạng thái trang phục được trả.
- Nếu nhân viên chưa chọn trang phục nào mà nhấn “Tiếp”, hệ thống hiển thị thông báo yêu cầu chọn ít nhất một trang phục để trả.
- Hệ thống hiện lại một bảng biểu bao gồm ngày trả, danh sách các trang phục được trả và số tổng số tiền phạt.
- Danh sách trang phục được trả gồm các trang phục được trả với các thông tin như sau:
- Mã trang phục
- Tên trang phục
- Ngày mượn
- Tiền mượn
- Số lượng trả (giá trị tối thiểu là 1, tối đa là số lượng trang phục đã mượn)
- Số tiền thuê tính đến ngày đang trả = Số lượng trả x Số tiền mượn x (Ngày trả - ngày mượn) (Nếu ngày trả cùng ngày, tính tiền mượn của 1 ngày)
- Nếu số lượng trả nhỏ hơn 1 hoặc lớn hơn số lượng mượn, hệ thống báo lỗi số lượng trả không phù hợp.
- Với mỗi trang phục được chọn trả:
- Nhân viên kiểm tra tình trạng thực tế.
- Nếu có lỗi khi trả (hư hỏng, thiếu phụ kiện, …), nhân viên thêm trang phục có lỗi vào bảng lỗi, thêm lỗi kèm số lượng trang phục lỗi.
- Nếu lỗi chưa có trong hệ thống, nhân viên chọn “Thêm lỗi” và điền các thông tin bao gồm:
- Tên lỗi
- Mô tả lỗi.
- Tiền phạt.
- Ghi chú
- Sau khi cập nhật trạng thái trang phục được trả, nhân viên kéo xuống và click nút “Hoàn thành”.
- Hệ thống hiển thị phiếu trả đồ bao gồm:
- Mã hóa đơn
- Ngày trả
- Người lập hóa đơn
- Thông tin khách hàng:
    - Mã khách hàng
    - Tên khách hàng
    - Số điện thoại
    - Email
    - Địa chỉ
    - Ghi chú
- Danh sách thông tin trang phục được trả:
    - Mã trang phục
    - Tên trang phục
    - Ngày mượn
    - Giá gốc
    - Giá mượn
    - Số lượng trả
    - Số tiền thuê tính đến ngày đang trả
    - Số tiền cọc cần trả
- Danh sách lỗi:
    - Mã trang phục
    - Tên trang phục
    - Số lượng
    - Tên lỗi
    - Phí phạt
- Tổng số tiền mượn
- Tổng số tiền phạt
- Tổng số tiền phải thanh toán = Tổng số tiền mượn + Tổng số tiền phạt
- Tổng số cọc cần trả
- Số tiền chênh lệch = Tổng số tiền phải thanh toán - Số tiền đặt cọc cần trả
- Quy tắc xử lý tiền cọc:
- Nếu khách hàng trả một phần trang phục:
    - Hệ thống giữ lại tiền cọc tối đa bằng tổng giá trị gốc của các trang phục còn đang thuê (Số tiền đặt cọc cần trả).
    - Nếu tiền cọc còn lại lớn hơn giá trị gốc các trang phục còn thuê, khách hàng được nhận lại phần dư.
- Nếu khách hàng trả hết toàn bộ trang phục:
    - Hệ thống hoàn lại toàn bộ tiền cọc còn lại cho khách hàng.
- Khách hàng kiểm tra các thông tin trong phiếu, sau đó nhân viên kéo xuống dưới và click "Xác nhận".
- Hệ thống cập nhật các trang phục vừa trả vào cơ sở dữ liệu, in phiếu cho khách hàng.

#### Modul “Thống kê trang phục được mượn nhiều”

- Quản lý muốn thống kê các trang phục được mượn nhiều ® Trên menu hệ thống chọn thống kê trang phục được mượn nhiều.
- Giao diện hiển thị sẽ yêu cầu chọn khoảng thời gian mong muốn:
    - Chọn ngày bắt đầu và ngày kết thúc.
    - Nút thao tác: Tìm kiếm, Làm mới.
    - Bảng kết quả thống kê trống, gồm các cột: STT, Mã trang phục, Tên trang phục, Kiểu trang phục, Chủng loại trang phuc, Tổng số lượt được mượn, Tổng số tiền thu được.
- Hệ thống thực hiện truy xuất theo khoảng thời gian yêu cầu:
    - Nếu trong khoảng thời gian đó không có phiếu mượn nào ® Bảng hiển danh sách kết quả trống.
        - Nếu quản lý muốn thống kê khoảng thời gian khác thì lặp lại bước nhập thời gian.
        - Nếu quản lý không muốn tìm thêm thống kê của các ngày khác thì kết thúc.
    - Nếu trong khoảng thời gian đó có tồn tại phiếu mượn:
        - Hệ thống hiển thị danh sách các trang phục được mượn nhiều theo dạng bảng, mỗi dòng tương ứng với một trang phục với đầy đủ thông tin:
            - Mã trang phục.
            - Tên trang phục.
            - Kiểu trang phục.
            - Chủng loại trang phục.
            - Tổng số lượt được mượn.
            - Tổng số tiền thu được.
        - Bảng danh sách sẽ được sắp xếp theo thứ tự giảm dần của cột tổng số lượt mượn, tiếp theo là giảm dần của cột tổng số tiền thu được.
- Quản lý muốn xem chi tiết các phiếu mượn theo 1 trang phục nào đó ® Quản lý click vào 1 dòng của trang phục.
- Hệ thống hiển thị giao diện “Thống kê danh sách phiếu mượn” gồm có:
    - Bảng danh sách các phiếu mượn có mượn trang phục đó trong khoảng thời gian đang được chọn, mỗi phiếu mượn tương ứng với một dòng gồm các thông tin:
        - Mã phiếu mượn.
        - Tên khách hàng mượn.
        - Số lượng mượn.
        - Ngày giờ mượn.
        - Ngày giờ trả.
        - Tổng số tiền.
    - Một dòng bên dưới bảng danh sách có thống kê tổng số tiền thu được.
    - Nút Quay lại.
- Quản lý thực hiện ấn nút Quay lại trên màn hình để đóng danh sách phiếu mượn và xem tiếp các trang phục được mượn nhiều khác.

#### Modul “Thống kê doanh thu”

- Quản lý cửa hàng đăng nhập vào hệ thống

→ Giao diện chính của quản lý xuất hiện trong đó có các chức năng: thống kê trang phục được mượn nhiều, thống kê doanh thu và thông tin nhân viên quản lý.

→ Quản lý chọn chức năng thống kê doanh thu.

→ Giao diện lựa chọn kiểu thống kê xuất hiện với các lựa chọn:

- Thống kê theo tháng
- Thống kê theo quý
- Thống kê theo năm
- Nút Xem thống kê.
- Quản lý chọn một kiểu thống kê, ví dụ theo tháng, rồi nhấn nút “Xem thống kê”

→ Hệ thống tổng hợp doanh thu theo kiểu thống kê mà quản lý đã chọn, dựa trên các phiếu mượn và danh sách các trang phục đã được mượn trong hệ thống. Doanh thu được tính theo tiền thuê phát sinh theo thời gian thuê

→ Với mỗi trang phục được mượn, hệ thống tính doanh thu theo công thức:

Doanh thu của trang phục = Giá mượn x Số lượng mượn x Số ngày thuê được ghi nhận.

- Trong đó:
- Nếu trang phục đã được trả trong kỳ thống kê, số ngày thuê được ghi nhận được tính từ ngày mượn hoặc ngày bắt đầu của kỳ nếu trang phục được mượn từ kỳ trước đến ngày trả, nếu ngày trả trùng với ngày mượn thì vẫn tính là một ngày.
- Nếu trang phục chưa được trả trong kỳ, hệ thống vẫn tính tiền thuê bình thường từ ngày mượn hoặc ngày bắt đầu của kỳ nếu trang phục được mượn từ kỳ trước cho đến ngày kết thúc kỳ thống kê.

→ Doanh thu của một kỳ thống kê bằng tổng doanh thu tạm tính của tất cả các trang phục có ít nhất một ngày được mượn nằm trong khoảng thời gian của kỳ đó dựa theo công thức trên.

→ Kết quả được hiển thị dưới dạng bảng.

- Nếu quản lý chọn thống kê theo tháng, quý hoặc năm, mỗi dòng trong bảng sẽ tương ứng với một kỳ thống kê theo lựa chọn đó và chứa các thông tin:
- Tên kỳ thống kê (tháng / quý / năm)
- Tổng số phiếu mượn phát sinh trong kỳ
- Tổng số khách hàng phát sinh giao dịch trong kỳ
- Tổng doanh thu tạm tính của kỳ.
- Các dòng trong bảng thống kê được sắp xếp theo thứ tự thời gian từ gần nhất đến cũ nhất.
- Quản lý xem bảng danh sách kết quả hiện lên

→ Nếu muốn xem chi tiết thông tin một kỳ cụ thể (tháng, quý hoặc năm), quản lý nhấn chọn vào một dòng trong bảng.

→ Hệ thống hiển thị giao diện chi tiết doanh thu của kỳ đã chọn. Giao diện này bao gồm:

- Phần đầu giao diện hiển thị các thông tin tổng quan của kỳ được chọn, bao gồm:
- Tên kỳ thống kê (tháng / quý / năm)
- Thời gian bắt đầu
- Thời gian kết thúc
- Tổng số phiếu mượn phát sinh trong kỳ
- Tổng số khách hàng phát sinh giao dịch trong kỳ
- Tổng doanh thu tạm tính của kỳ.
- Phía dưới là bảng danh sách các phiếu mượn trong kỳ đã chọn. Mỗi dòng trong bảng tương ứng với một phiếu mượn và chứa các trường thông tin:
- Mã phiếu mượn
- Mã khách hàng
- Tên khách hàng
- Ngày giờ mượn
- Tổng số loại trang phục
- Tổng số lượng trang phục
- Tổng số ngày thuê được ghi nhận cho đến ngày kết thúc kỳ thống kê
- Doanh thu tạm tính của phiếu mượn
- Trạng thái phiếu mượn (đang mượn / trả một phần / đã trả hết).
- Nếu quản lý muốn xem chi tiết hơn một phiếu mượn cụ thể, quản lý có thể nhấn chọn vào dòng tương ứng.  
    → Hệ thống hiển thị danh sách các trang phục thuộc phiếu mượn đó. Mỗi dòng tương ứng với một trang phục và chứa các thông tin:
- Mã trang phục
- Tên trang phục
- Giá mượn
- Số lượng mượn
- Ngày giờ mượn
- Ngày giờ trả (nếu đã trả)
- Số ngày thuê được ghi nhận
- Doanh thu tạm tính của dòng trang phục.
- Nếu trong kỳ được chọn không phát sinh giao dịch thuê nào, hệ thống vẫn hiển thị giao diện chi tiết của kỳ đó, trong đó phần thông tin kỳ thống kê vẫn bao gồm:
- Tên kỳ
- Thời gian bắt đầu
- Thời gian kết thúc
- Tổng số phiếu mượn = 0
- Tổng số khách hàng phát sinh giao dịch = 0
- Tổng doanh thu tạm tính = 0
- Bảng danh sách thống kê không có dòng dữ liệu và hiển thị thông báo: “Không có giao dịch trong kỳ thống kê đã chọn”.
- Quản lý có thể chọn từng dòng để đối chiếu với các giao dịch thực tế nếu cần kiểm tra chi tiết hơn

→ Sau khi xem xong, quản lý nhấn nút quay lại để trở về giao diện thống kê hoặc giao diện chính của quản lý.

### Các đối tượng cần xử lý

- Khách hàng
- Mã khách hàng
- Tên khách hàng
- Số điện thoại
- Email
- Địa chỉ
- Ghi chú (nếu có)
- Trang phục
- Mã trang phục. 
- Tên trang phục. 
- Kiểu trang phục. 
- Chủng loại trang phục. 
- Giá gốc.
- Giá mượn.
- Tình trạng trang phục.
- Số lượng tồn kho.
- Nhân viên
- Mã nhân viên
- Tên nhân viên
- Số điện thoại
- Chức vụ (thu ngân, quản lý)
- Phiếu mượn đưa cho khách hàng
- Mã phiếu mượn
- Ngày giờ mượn
- Thông tin cá nhân khách hàng
- Danh sách trang phục mượn
- Tổng số tiền cần đặt cọc 
- Phiếu trả đồ :
- Mã hóa đơn 
- Ngày trả
- Thông tin cá nhân khách hàng
- Danh sách trang phục được trả
- Danh sách lỗi
- Tổng số tiền mượn
- Tổng số tiền phạt
- Số tiền đặt cọc cần trả 
- Số tiền khách phải trả thêm hoặc được nhận lại
- Phiếu mượn trong hệ thống để thống kê theo doanh thu
- Mã phiếu mượn
- Mã khách hàng
- Tên khách hàng
- Ngày giờ mượn
- Tổng số loại trang phục
- Tổng số lượng trang phục
- Tổng số ngày thuê được ghi nhận cho đến ngày kết thúc kỳ thống kê
- Doanh thu tạm tính của phiếu mượn
- Trạng thái phiếu mượn (đang mượn / trả một phần / đã trả hết). 

### Quan hệ giữa các đối tượng

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
- Một báo cáo thống kê doanh thu được tổng hợp từ nhiều phiếu mượn trong hệ thống.
- Một phiếu mượn có thể đóng góp dữ liệu vào nhiều kỳ thống kê doanh thu nếu thời gian thuê kéo dài qua nhiều kỳ khác nhau.
- Một báo cáo thống kê trang phục được mượn nhiều được tổng hợp từ nhiều phiếu mượn và dữ liệu trang phục trong khoảng thời gian được chọn.
- Một phiếu mượn có thể đóng góp dữ liệu vào nhiều báo cáo thống kê trang phục được mượn nhiều.

## Business model by UML (Mô tả bằng UML)

### Biếu đồ Use case tổng quát

#### Actors

- Actor là người dùng trực tiếp: Nhân viên quản lý và nhân viên thu ngân. Các actor này đều cùng là nhân viên trong cửa hàng cho thuê trang phục biểu diễn, nên có quan hệ kế thừa từ actor này.
- Actor là người dùng gián tiếp: Khách hàng, dù không trực tiếp sử dụng và thao tác trên hệ thống, nhưng một số chức năng phải có khách hàng tham gia thì mới thực hiện được như: cho thuê trang phục, cho khách hàng trả trang phục. 
    1.  

#### Các chức năng liên quan đến các actor

- Nhân viên thu ngân:
- Cho khách hàng thuê trang phục.
- Cho khách hàng trả trang phục .
- Nhân viên quản lý:
- Xem thống kê trang phục được mượn nhiều.
- Xem thống kê doanh thu.
- Các chức năng này đều cùng là xem thống kê, nên ta tạo chức năng trừu tượng là xem thống kê.

#### Sơ đồ use case tổng quan

Các use case được mô tả như sau:

- Cho thuê trang phục: Use case này cho phép nhân viên thu ngân cho khách hàng thuê trang phục.
- Cho khách hàng trả trang phục: Use case này cho phép nhân viên thu ngân cho khách hàng trả trang phục.
- Xem thống kê: Use case này cho phép nhân viên quản lý xem thống kê.
- Xem thống kê trang phục được mượn nhiều: Use case này cho phép nhân viên quản lý xem thống kê trang phục được mượn nhiều.
- Xem thống kê doanh thu: Use case này cho phép nhân viên quản lý xem thống kê doanh thu.

### Biểu đồ use case chi tiết

#### Use case và actor từ use case tổng quan.

- Use case: Cho khách hàng trả trang phục
- Actor: Nhân viên thu ngân, khách hàng

#### Các sub use case

- Đăng nhập vào hệ thống
- Xem giao diện của thu ngân
- Tìm kiếm khách hàng
- Xem thông tin khách hàng, danh sách trang phục đã trả và chưa trả
- Kiểm tra thông tin trang phục được trả.
- Ghi lại các tình trạng trang phục được trả và tiền phạt.
- Thêm tình trạng trang phục mới
- Xem thông tin và xuất hóa đơn

#### Sơ đồ use case chi tiết

Các use case được mô tả như sau:

- Đăng nhập hệ thống: Use case này cho phép nhân viên thu ngân đăng nhập hệ thống.
- Xem giao diện của thu ngân: Use case này cho phép nhân viên thu ngân xem giao diện của thu ngân.
- Tìm kiếm khách hàng: Use case này cho phép nhân viên tìm kiếm khách hàng.
- Xem thông tin khách hàng, danh sách trang phục đã trả và chưa trả: Use case này cho phép nhân viên thu xem thông tin khách hàng và danh sách phiếu mượn: Use case này cho phép nhân viên thu ngân xem thông tin khách hàng và danh sách phiếu mượn.
- Kiểm tra thông tin trang phục được trả: Use case này cho phép nhân viên thu ngân kiểm tra thông tin trang phục được trả.
- Ghi lại tình trạng trang phục được trả và tiền phạt: Use case này cho phép nhân viên thu ngân ghi lại tình trạng trang phục được trả và tiền phạt.
- Thêm tình trạng trang phục mới: Use case này cho phép nhân viên thu ngân thêm tình trạng trang phục mới.
- Xem thông tin và xuất hóa đơn: Use case này cho phép nhân viên thu ngân xem thông tin và xuất hóa đơn.

# Pha phân tích

## Kịch bản

<div class="joplin-table-wrapper"><table><tbody><tr><td><p><strong>Scenario</strong></p></td><td><p>Cho khách hàng trả trang phục</p></td></tr><tr><td><p><strong>Actor</strong></p></td><td><p>Nhân viên thu ngân, khách hàng</p></td></tr><tr><td><p><strong>Pre-condition</strong></p></td><td><ul><li>Nhân viên thu ngân có tài khoản đúng định dạng nhân viên thu ngân.</li><li>Khách hàng đã mượn một số lượng trang phục và cần trả.</li></ul></td></tr><tr><td><p><strong>Post-condition</strong></p></td><td><p>Khách hàng trả trang phục thành công</p></td></tr><tr><td><p><strong>Main events</strong></p></td><td><ul><li><ol><li>Nhân viên thu ngân A đăng nhập vào hệ thống với username là A, mật khẩu là a@123 để khách hàng trả trang phục.</li><li>Hệ thống hiện giao diện chính của nhân viên thu ngân, có lựa chọn “Cho khách hàng trả trang phục”.</li><li>Thu ngân chọn chức năng “Cho khách hàng trả trang phục”.</li><li>Hệ thống hiện giao diện, yêu cầu thu ngân tìm kiếm khách hàng theo tên khách hàng, email hoặc số điện thoại.</li><li>Thu ngân yêu cầu khách hàng cung cấp tên.</li><li>Khách hàng cung cấp tên cho thu ngân.</li><li>Thu ngân nhập tên vào hệ thống.</li><li>Hệ thống hiện ra giao diện tìm kiếm và danh sách các khách hàng đi kèm một số thông tin khách hàng:</li></ol></li></ul><p>Thanh tìm kiếm theo tên khách hàng</p><p>Thanh tìm kiếm theo email</p><p>Thanh tìm kiếm theo số điện thoại</p><p>Nút tìm kiếm</p><table><tbody><tr><td><p>Mã</p></td><td><p>Họ tên</p></td><td><p>Địa chỉ</p></td><td><p>SĐT</p></td><td><p>Email</p></td><td><p>Ghi chú</p></td></tr><tr><td><p>123</p></td><td><p>Nguyễn Văn B</p></td><td><p>Hà Nội</p></td><td><p>0123456789</p></td><td><p><a href="mailto:b@gmail.com">b@gmail.com</a></p></td><td><p></p></td></tr></tbody></table><ul><li><ol><li>Nhân viên thu ngân chọn đúng khách hàng trả trang phục.</li><li>Hệ thống hiện ra giao diện thông tin khách hàng kèm danh sách trang phục đang mượn và đã trả cùng danh sách lỗi đã vi phạm của khách hàng đó:</li></ol></li></ul><p>Thông tin khách hàng:</p><table><tbody><tr><td><p>Mã</p></td><td><p>Họ tên</p></td><td><p>Địa chỉ</p></td><td><p>SĐT</p></td><td><p>Email</p></td><td><p>Ghi chú</p></td></tr><tr><td><p>123</p></td><td><p>Nguyễn Văn B</p></td><td><p>Hà Nội</p></td><td><p>0123456789</p></td><td><p><a href="mailto:b@gmail.com">b@gmail.com</a></p></td><td><p></p></td></tr></tbody></table><p>Danh sách trang phục đang mượn:</p><input type="checkbox"><input type="checkbox"><input type="checkbox" checked="checked"><table><tbody><tr><td><p>Mã</p></td><td><p>Tên</p></td><td><p>Ngày mượn</p></td><td><p>Giá mượn</p></td><td><p>Giá cọc</p></td><td><p>Số lượng</p></td><td><p>Tình trạng</p></td><td><p>Chọn trả</p></td></tr><tr><td><p>123</p></td><td><p>Áo dài cách tân đen nữ size XL</p></td><td><p>10/03/2026</p></td><td><p>10</p></td><td><p>1000</p></td><td><p>2</p></td><td><p>Sạch</p></td></tr><tr><td><p>124</p></td><td><p>Áo dài cách tân trắng nữ size L</p></td><td><p>11/03/2026</p></td><td><p>10</p></td><td><p>900</p></td><td><p>3</p></td><td><p>Hơi bẩn</p></td></tr><tr><td><p>125</p></td><td><p>Áo dài truyền thống đỏ</p><p>nữ size M</p></td><td><p>12/03/2026</p></td><td><p>15</p></td><td><p>750</p></td><td><p>2</p></td><td><p>Sạch</p></td></tr></tbody></table><p>Danh sách trang phục đã trả:</p><table><tbody><tr><td><p>Mã</p></td><td><p>Tên</p></td><td><p>Ngày mượn</p></td><td><p>Giá mượn</p></td><td><p>Giá cọc</p></td><td><p>Số lượng</p></td><td><p>Tình trạng</p></td><td><p>Ngày trả</p></td></tr><tr><td><p>123</p></td><td><p>Áo dài cách tân đen nữ size M</p></td><td><p>01/03/2026</p></td><td><p>10</p></td><td><p>1000</p></td><td><p>2</p></td><td><p>Sạch</p></td><td><p>08/03/2026</p></td></tr></tbody></table><p>Nút “Trả trang phục”</p><ul><li><ol><li>Nhân viên yêu cầu khách hàng đưa các trang phục cần trả.</li><li>Khách hàng đưa trang phục cho nhân viên thu ngân.</li><li>Nhân viên xem thông tin được đính kèm trên trang phục, tick vào ô “Chọn trả” cho các trang phục đó, sau đó bấm nút “Tiếp”.</li><li>Hệ thống hiển thị giao diện để nhân viên thu ngân xác nhận trả đồ và kiểm tra tình trạng đồ gồm:</li></ol></li></ul><p>Ngày trả: 16/03/2026</p><p>Thông tin khách hàng:</p><table><tbody><tr><td><p>Mã</p></td><td><p>Họ tên</p></td><td><p>Địa chỉ</p></td><td><p>SĐT</p></td><td><p>Email</p></td><td><p>Ghi chú</p></td></tr><tr><td><p>123</p></td><td><p>Nguyễn Văn B</p></td><td><p>Hà Nội</p></td><td><p>0123456789</p></td><td><p><a href="mailto:b@gmail.com">b@gmail.com</a></p></td><td><p></p></td></tr></tbody></table><p>Danh sách trang phục được trả:</p><table><tbody><tr><td><p>Mã</p></td><td><p>Tên</p></td><td><p>Ngày mượn</p></td><td><p>Số lượng trả</p></td><td><p>Thành tiền</p></td><td><p>Tình trạng</p></td><td><p>Tiền phạt</p></td></tr><tr><td><p>123</p></td><td><p>Áo dài cách tân đen nữ size L</p></td><td><p>10/03/2026</p></td><td><p>1</p></td><td><p>60</p></td><td><p>Sạch</p></td><td><p>0</p></td></tr><tr><td><p>125</p></td><td><p>Áo dài truyền thống đỏ nữ size L</p></td><td><p>12/03/2026</p></td><td><p>2</p></td><td><p>120</p></td><td><p>Sạch</p></td><td><p>0</p></td></tr></tbody></table><p>Nút “Thêm tình trạng trang phục”</p><p>Tổng số tiền thuê: 180.000VNĐ</p><p>Tổng tiền phạt: 0VNĐ</p><p>Nút “Quay lại”</p><p>Nút “Hoàn thành”</p><ul><li><ol><li>Nhân viên thu ngân nhập số lượng trang phục mà khách hàng trả ứng với từng loại trang phục, tình trạng trang phục khi trả không thay đổi so với tình trạng trang phục khi mượn, thu ngân click “Hoàn thành”.</li><li>Hệ thống hiện phiếu trả đồ bao gồm:</li></ol></li></ul><p>Mã hóa đợn: 123</p><p>Người lập phiếu: Nguyễn Văn A</p><p>Ngày trả: 16/03/2026</p><p>Thông tin khách hàng:</p><table><tbody><tr><td><p>Mã</p></td><td><p>Họ tên</p></td><td><p>Địa chỉ</p></td><td><p>SĐT</p></td><td><p>Email</p></td><td><p>Ghi chú</p></td></tr><tr><td><p>123</p></td><td><p>Nguyễn Văn B</p></td><td><p>Hà Nội</p></td><td><p>0123456789</p></td><td><p><a href="mailto:b@gmail.com">b@gmail.com</a></p></td><td><p></p></td></tr></tbody></table><p>Danh sách thông tin trang phục:</p><table><tbody><tr><td><p>Mã</p></td><td><p>Tên</p></td><td><p>Ngày mượn</p></td><td><p>Giá mượn</p></td><td><p>Giá cọc</p></td><td><p>Tình trạng mượn</p></td></tr><tr><td><p>123</p></td><td><p>Áo dài cách tân đen nữ size L</p></td><td><p>10/03/2026</p></td><td><p>10</p></td><td><p>1000</p></td><td><p>Sạch</p></td></tr><tr><td><p>125</p></td><td><p>Áo dài truyền thống đỏ nữ size L</p></td><td><p>12/03/2026</p></td><td><p>15</p></td><td><p>750</p></td><td><p>Sạch</p></td></tr></tbody></table><p>Thông tin trang phục được trả:</p><table><tbody><tr><td><p>Mã</p></td><td><p>Tên</p></td><td><p>Số lượng trả</p></td><td><p>Tổng tiền mượn</p></td><td><p>Tình trạng trả</p></td><td><p>Số tiền phạt</p></td></tr><tr><td><p>123</p></td><td><p>Áo dài cách tân đen nữ size L</p></td><td><p>1</p></td><td><p>60</p></td><td><p>Sạch</p></td><td><p>0</p></td></tr><tr><td><p>125</p></td><td><p>Áo dài truyền thống đỏ nữ size L</p></td><td><p>2</p></td><td><p>120</p></td><td><p>Sạch</p></td><td><p>0</p></td></tr></tbody></table><p>Tổng số tiền mượn: 180.000VNĐ</p><p>Tổng số tiền phạt: 0VNĐ</p><p>Tổng số tiền cần thanh toán: 180.000VNĐ</p><p>Tổng số tiền cọc cần trả: 2.500.000VNĐ</p><p>Số tiền chênh lệch: -2.320.000VNĐ</p><p>Nút “Xác nhận”</p><ul><li><ol><li>Nhân viên thu ngân đọc các thông tin trong phiếu trả và hỏi lại khách hàng về các thông tin trên phiếu trả.</li><li>Khách hàng xác nhận thông tin chính xác.</li><li>Nhân viên nhấn nút “Xác nhận”</li><li>Hệ thống in phiếu trả và cập nhật vào cơ sở dữ liệu.</li><li>Nhân viên thu ngân đưa phiếu trả cho khách hàng, thông báo với khách hàng là đã trả đồ thành công.</li></ol></li></ul></td></tr><tr><td><p>Exception</p></td><td><p>2. Hệ thống hiển thị thông báo “Đăng nhập thất bại”</p><p>2.1. Nhân viên thu ngân click “Ok”.</p><p>2.2. Hệ thống hiện giao diện đăng nhập.</p><p>2.3. Nhân viên thu ngân nhập lại username là A, mật khẩu là a@123</p><p>2.4. Hệ thống hiện giao diện chính của nhân viên thu ngân.</p><p></p><p>8. Hệ thống hiện ra&nbsp;giao diện&nbsp;tìm kiếm và&nbsp;danh sách rỗng hoặc nhiều khách hàng cùng tên.</p><p>8.1. Thu ngân yêu cầu thêm số điện thoại, và email.</p><p>8.2. Khách hàng cung cấp các thông tin thu ngân cần.</p><p>8.3. Thu ngân tìm kiếm dựa trên các thông tin được bổ xung.</p><p>8.4. Hệ thống hiển thị khách hàng duy nhất có thông tin ứng với các thông tin đó.</p><p></p><p>14. Hệ thống hiển thị thông báo lỗi yêu cầu chọn ít nhất một trang phục để trả.</p><p>14.1. Nhân viên thu ngân click Ok.</p><p>14.2. Hệ thống hiện lại giao diện thông tin phiếu mượn và danh sách trang phục.</p><p>14.3. Nhân viên thu ngân tick vào ô "Chọn trả" đối với các trang phục mà khách hàng mang trả sau đó bấm nút "Tiếp".</p><p></p><p>15. Hệ thống không hiển thị tình trạng trang phục nào phù hợp với tình trạng thực tế của trang phục.</p><p>15.1. Nhân viên thu ngân click nút "Thêm tình trạng trang phục mới".</p><p>15.2. Hệ thống hiện giao diện thêm lỗi, có các ô nhập:</p><p>- Tên tình trạng</p><p>- Chi tiết tình trạng</p><p>- Phí phạt</p><p>- Ghi chú</p><p>- Nút "Thêm"</p><p>15.3. Nhân viên thu ngân điền thông tin lỗi tương ứng, phí phạt theo quy định cửa hàng, và click nút "Thêm".</p><p>15.4. Hệ thống quay lại giao diện xác nhận trả đồ, đã có tình trạng trang phục vừa thêm xuất hiện trong "Danh sách trang phục được trả" và tổng tiền phạt được hệ thống tự động cập nhật.</p><p></p><p>16. Hệ thống báo lỗi số lượng trả không phù hợp.</p><p>16.1. Nhân viên thu ngân click “Ok”.</p><p>16.2. Hệ thống hiện lại giao diện xác nhận trả đồ.</p><p>16.3. Nhân viên thu ngân nhập lại đúng số lượng trang phục thực tế khách mang trả sau đó click "Thanh toán".</p><p></p><p>20. Hệ thống in ra số tiền chênh lênh &gt; 0 (số tiền cần thanh toán &gt; số tiền cọc cần hoàn trả)</p><p>20.1. Nhân viên thu ngân thu ngân yêu cầu khách hàng thanh toán số tiền chênh lệch</p><p>20.2. Khách hàng tiến thành thanh toán</p><p>20.3. Nhân viên thu ngân nhận tiền và thông báo cho khách hàng trả đồ thành công.</p></td></tr></tbody></table></div>

## Biểu đồ lớp thực thể

**Bước 1: Mô trả module bằng một đoạn văn**

Hệ thống quản lý cửa hàng cho thuê trang phục biểu diễn cho phép nhân viên cửa hàng quản lý thông tin trang phục, cũng như quản lý việc mượn và trả trang phục. Module khách hàng trả đồ và thanh toán được thực hiện bởi nhân viên thu ngân và khách hàng, trong đó khách hàng mang trang phục đã mượn tới cửa hàng, nhân viên thu ngân tiến hành lấy thông tin khách hàng, tìm kiếm khách hàng và phiếu mượn trên hệ thống, tìm kiếm và kiểm trang phục được trả và thanh toán. Trong trường hợp trang phục được trả có lỗi, nhân viên thu ngân ghi lại lỗi lên trên hệ thống và thu phì phạt theo kèm số tiền thuê trang phục khi thanh toán. Nếu lỗi chưa có trên hệ thống, nhân viên thêm lỗi mới vào hệ thống. Cuối cùng in hóa đơn gồm tổng số tiền thuê, tổng số tiền phạt và số tiền cọc cần trả lại cho khách hàng.

**Bước 2 + 3: Trích và đánh giá các danh từ**

- Nhân viên thu ngân à Lớp **User** (username, password, fullname, role)
- Khách hàng à Lớp **Client** (fullname, email, tel, address, note)
- Trang phục à Lớp **Costume** (barcode, name, color, size, price, quantity, zone, description)
- Cửa hàng à Lớp **Store** (name, address, tel, description)
- Hệ thống à Danh từ trừu tượng à Loại
- Username/Password à Thuộc tính của lớp User
- Giao diện à Danh từ trừu tượng à Loại
- Thông tin khách hàng à Thuộc tính của lớp Client
- Nút/Checkbox à Danh từ trừu tượng à Loại
- Thông tin trang phục à Thuộc tính của lớp Costume
- Lỗi trang phục à Lớp **Damage** (name, detail, fee, note)
- Phí phạt à Thuộc tính của lớp Damage
- Máy in phiếu à Ngoài phạm vi hệ thống à Loại
- Phiếu trả đồ à Lớp **ReturnedReceipt** (barcode, returnedAt, chargeFee, note)
- Phiếu mượn đồ à Lớp **RentedReceipt** (barcode, rentedAt, saleoff, note)
- Thông tin phiếu trả à Thuộc tính của lớp ReturnedReceipt
- Số tiền thuê trang phục à Thuộc tính của lớp ReturnedReceipt
- Số tiền phạt à Thuộc tính của lớp ReturnedReceipt
- Cọc à Lớp **DepositItem** (name, value, note)

**Bước 4 + 5: Xét quan hệ giữa các lớp và bổ sung các quan hệ đối tượng**

- Quan hệ giữa các lớp thực thể được xác định như sau:
    - Mỗi cửa hàng có thể có nhiều trang phục, mỗi trang phục lại chỉ thuộc về một cửa hàng duy nhất nên quan hệ Store – Costume là 1 – n.
    - Mỗi khách hành có thể trả trang phục nhiều lần nên sẽ có nhiều phiếu trả đồ (những lần khác nhau), nên quan hệ giữa Client – ReturnedReceipt là 1 – n.
    - Mỗi khách hàng có thể gồm nhiều trang phục, mỗi trang phục lại có thể thuộc nhiều phiếu mượn khách nhau (ở những thời điểm khách nhau), vậy nên quan hệ giữa RentedReceipt – Costume là n – n. Ta cần một lớp ở giữa là RentedCostume. Mỗi RentedReceipt và Costumer ta xác định được duy nhất một RentedCostume.
    - Mỗi khách hàng có thể chọn trả nhiều trang phục đã mượn, mỗi trang phục đã mượn lại có thể thuộc nhiều phiếu trả khác nhau (ở những thời điểm khác nhau), vậy nên quan hệ giữa ReturedReceipt – RentedCostume là n – n. Ta cần một lớp ở giữa là ReturnedCostume. Mỗi ReturedReceipt và RentedCostume ta xác định được duy nhất một RentedCostume.
    - Mỗi lần mượn đồ, mỗi lỗi trang phục sẽ có nhiều trang phục tương ứng và một trang phục được mượn có thể mắc nhiều lỗi, vậy nên mối quan hệ giữa State – RentedCostume là n – n. Ta cần một lớp giữa là RentedDamage.
    - Mỗi lần trả đồ, mỗi lỗi trang phục sẽ có nhiều trang phục tương ứng và một trang phục được trả có thể mắc nhiều lỗi, vậy nên mối quan hệ giữa Damage – ReturnedCostume là n – n. Ta cần một lớp giữa là ReturnedDamage.
    - Nhân viên có thể tạo ra nhiều phiếu trả đồ , nên quan hệ User – ReturnedReceipt là 1 – n. Tượng tự quan hệ User – RentedReceipt cũng là 1 – n.
    - Mỗi lần mượn khách hàng có thể cọc nhiều vật phẩm, và một vật phẩm có thể cọc trong nhiều lần cọc, vậy nên mối quan hệ giữa DepositItem – RentedReceipt là n – n. Ta cần một lớp giữa RentedDeposit.
    - Mỗi lần trả khách hàng có thể chọn trả nhiều vật phẩm, và một vật phẩm cọc có thể được trả trong nhiều lần trả, vậy nên mối quan hệ giữa RentedDeposit – ReturnedReceipt là n – n. Ta cần một lớp giữa ReturnedDeposit.

**Ta có được biểu đồ lớp thực thể:**

## Biểu đồ lớp đầy đủ

- 1.  **_Giao diện đang nhập à LoginView_**
- Nhập tên người dung: inUsername
- Nhập mật khẩu: inPassword
- Nút đăng nhập: subLogin
- Hệ thống cần kiểm tra đăng nhập có đúng ko à Cần phương tức checkLogin()
    
    - Đầu vào: username, password
    - Đầu ra: Boolean
    - Lớp chủ thể: User
    
    1.  **_Giao diện chính của nhân viên thu ngân à CashierHomeView_**
- Lựa chọn cho thuê trang phục: subRent
- Lựa chọn cho khách hàng trả trang phục: subReturn
    1.  **_Giao diện tìm kiếm khách hàng à SearchClientView_**
- Nhập tên người dung: inFullname
- Nhập số điệnt thoại: inTel
- Nhập email: inEmail
- Nút tìm kiếm: subSearch
- Hiển thị danh sách các thông tin khách hàng: outsubListClient.
- Hệ thống cần tìm kiếm khách hàng qua tên khách hàng à Cần phương thức searchClientByFullname()
    - Đầu vào: fullname
    - Đầu ra: List&lt;Client&gt;
    - Lớp chủ thể: Client
- Hệ thống cần tìm kiếm khách hàng qua email khách hàng à Cần phương thức searchClientByEmail()
    - Đầu vào: email
    - Đầu ra: List&lt;Client&gt;
    - Lớp chủ thể: Client
- Hệ thống cần tìm kiếm khách hàng qua số điện thoại khách hàng à Cần phương thức searchClientByTel()
    
    - Đầu vào: tel
    - Đầu ra: List&lt;Client&gt;
    - Lớp chủ thể: Client
    
    1.  **_Giao diện thông tin khách hàng à ClientInfoView_**
- Hiển thị thông tin khách hàng: outClientInfo
- Hiển thị danh sách trang phục khách hàng chưa trả và đã trả:
    - outSlug
    - outName
    - outRentedAt
    - outPrice
    - outDeposit
    - outQuantity
    - outRentedDamage
    - inReturn (với trang phục chưa trả)
    - outReturnedAt (với trang phục đã trả)
- Nút tiếp tục: subNext
- Hệ thống lấy thông tin trang phục đã thuê kèm tình trạng đã trả hay chưa trả à searchByClient()
    
    - Đầu vào: Client
    - Đầu ra: List&lt;RentedReceipt&gt;
    - Lớp chủ thể: RentedReceipt
    
    1.  **_Giao diện cập nhật tình trạng trang phục à AddDamageCostumeView_**
- Hiển thị ngày trả trang phục: outReturnedAt
- Hiển thị thông tin khách hàng: outClientInfo
- Hiển thị danh sách trang phục được chọn trả:
    - outSlug
    - outName
    - outRentedAt
    - inQuantity
    - outRentedCost
    - outinReturnedDamage
    - outFineFee
- Nút thêm trạng thái trang phục mới: subAddState
- Hiển thị tiền thuê trang phục: outTotalRentedCost
- Hiển thị tổng tiền phạt: outTotalFineFee
- Nút hoàn thành: subFinish
- Hệ thống cần tính tiền thuê trang phục theo ngày và số lượng trả à calculateRentedFee():
    - Đầu vào: returnedAt, rentedAt, quantity
    - Đầu ra: rentedCost
    - Lớp chủ thể: ReturnedCostume
- Hệ thống cần lấy phí phạt theo trạng thái trang phục à getFineFee():
    - Đầu vào: stateName
    - Đầu ra: fineFee
    - Lớp chủ thể: State
- Hệ thống cần cập nhật lại trạng thái trang phục do người dung mắc lỗi (rách, bẩn, …) à addReturnedDamage():
    
    - Đầu vào: ReturnedCostume, Damage
    - Đầu ra: boolean
    - Lớp chủ thể: ReturnedDamage
    
    1.  **_Giao diện thêm lỗi trang phục mới à AddDamageView_**
- Nhập tên trạng thái: inName
- Nhập mô tả trạng thái: inDetail
- Nhập phí phạt cho trạng thái: inFee
- Nhập ghi chú: inNote
- Hệ thống cần xử lý thêm lỗi vi phạm à addDamage():
    
    - Đầu vào: name, detail, fee, note
    - Đầu ra: Boolean
    - Lớp chủ thể: State
    
    1.  **_Giao diện xác nhận phiếu trả trang phục à ConfirmView_**
- Hiển thị phiếu trả: outReturnedReceipt
- Nút xác nhận và in phiếu: subConfirm
- Nút hủy và quay lại: subCancel
- Hệ thống cần tính toán tổng tiền cho hóa đơn (tiền thuê, tiền phạt, tiền cọc) à calculateTotalReceipt()
    - Đầu vào: List&lt;ReturnedCostume&gt;
    - Đầu ra: ReturnedReceipt
    - Lớp chủ thể: ReturnedReceipt
- Hệ thống cần cập nhật trạng thái của món đồ thuê gốc thành "Đã trả" à updateRentedStatus()
    - Đầu vào: rentedCostumeId, isReturned (true)
    - Đầu ra: Boolean
    - Lớp chủ thể: RentedCostume
- Hệ thống cần cộng lại số lượng trang phục vào kho à updateQuantity()
    - Đầu vào: costumeId, returnedAmount
    - Đầu ra: Boolean
    - Lớp chủ thể: Costume
- Khi xác nhận, hệ thống lưu phiếu trả mới à addReturnedReceipt()
    - Đầu vào: ReturnedReceipt
    - Đầu ra: Boolean
    - Lớp chủ thể: ReturnedReceipt

Ta được biểu đồ lớp thực thể bao gồm các lớp giao diện:

## Kịch bản chuẩn V2 và biều đồ tuần tự

- 1.  Khách hàng mang trang phục tới quầy thu ngân yêu cầu trả trang phục.
    2.  Thu ngân đăng nhập với username là A, password là a@123 trên giao diện LoginView.
    3.  Lớp LoginView gọi lớp User để xử lý.
    4.  Lớp User thực hiện hàm checkLogin().
    5.  Lớp User trả về kết quả đăng nhập thành công cho LoginView.
    6.  Lớp LoginView gọi lớp CashierHomeView
    7.  Lớp CashierHomeView hiển thị cho thu ngân.
    8.  Thu ngân chọn chức năng “Cho khách hàng trả trang phục”
    9.  Lớp CashierHomeView gọi lớp SearchClientView
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

Ta được biểu đồ tuần tự như sau:

# Pha thiết kế

## Thiết kế lớp thực thể

- Bước 1: Hoàn thiện lớp và thuộc tính:
    - Thêm ID vào tất cả các lớp.
    - Bổ xung kiểu cho thuộc tính.
- Bước 2: Chuyển các quan hệ Association thành quan hệ Aggregation/Composition tương ứng:
    - Costume + RentedReceipt à RentedCostume được chuyển thành: Costume là thành phần của RentedCostume, RentedCostume là thành phần của RentedReceipt.
    - RentedCostume + ReturnedReceipt à ReturnedCostume được chuyển thành: RentedCostume là thành phần của ReturnedCostume, ReturnedCostume là thành phần của ReturnedReceipt.
    - DepositItem + RentedReceipt à RentedDeposit được chuyển thành: DepositItem là thành phần của RentedDeposit, RentedDeposite là thành phần của RentedReceipt.
    - RentedDeposit + ReturnedReceipt à ReturnedDeposit được chuyển thành: RentedDeposit là thành phần của ReturnedDeposit, ReturnedDeposit là thành phần của ReturnedReceipt.
    - RentedCostume + Damage à RentedDamage được chuyển thành: Damage là thành phần của RentedDamage, RentedDamage là thành phần của RentedCostume.
    - ReturnedCostume + Damage à ReturnedDamage được chuyển thành: Damage là thành phần của ReturnedDamage , ReturnCostumeDamage là thành phần của ReturnedCostume.
- Bước 3: Bổ xung thuộc tính đối tượng tương ứng theo quan hệ thành phần:
    - Client là thành phần của RentedReceipt, quan hệ 1 – n à RentedReceipt chứa một Client.
    - User là thành phần của RentedReceipt, quan hệ 1 – n à RentedReceipt chứa một User.
    - Client là thành phần của ReturnedReceipt, quan hệ 1 – n à ReturnedReceipt chứa một Client.
    - User là thành phần của ReturnedReceipt, quan hệ 1 – n à ReturnedReceipt chứa một User.
    - Costume là thành phần của Store, quan hệ n – 1 à Store có một danh sách Costume.
    - DepositItem là thành phần của RentedDeposit, quan hệ 1 – n à RentedDeposit có một DepositItem.
    - RentedDeposit là thành phần của ReturnedDeposit, quan hệ 1 – n à ReturnedDeposit có một RentedDeposit.
    - RentedDeposit là thành phần của RentedReceipt, quan hệ n – 1 à RentedReceipt có một danh sách RentedDeposit.
    - ReturnedDeposit là thành phần của ReturnedReceipt, quan hệ n – 1 à ReturnedReceipt có một danh sách ReturnedDeposit.
    - Costume là thành phần của RentedCostume, quan hệ 1 – n à RentedCostume có một Costume.
    - RentedCostume là thành phần của RentedReceipt, quan hệ n – 1 à RentedReceipt chứa một danh sách RentedCostume.
    - ReturnedCostume là thành phần của ReturnedReceipt, quan hệ n – 1 à ReturnedReceipt chứa một danh sách ReturnedCostume.
    - RentedDamage là thành phần của RentedCostume, quan hệ n – 1 à RentedCostume chứa một danh sách RentedDamage.
    - Damage là thành phần của RentedDamage, quan hện 1 – n à RentedDamage chứa một Damage.
    - RentedCostume là thành phần của ReturnedCostume, quan hệ 1 – n à ReturnedCostume chứa một RentedCostume.
    - ReturnedDamage là thành phần của ReturnedCostume, quan hệ n – 1 à ReturnedCostume chứa một danh sách ReturnedDamage.
    - Damage là thành phần của ReturnedDamage, quan hệ 1 – n à ReturnedDamage chứa một Damage.

Ta được biểu đồ lớp thực thể:

## Thiết kế cơ sở dữ liệu

- Bước 1: Với mỗi lớp thực thể tương ứng với một bảng dữ liệu có tên dạng tbl&lt;tên lớp thực thể&gt;
    - Lớp User à bảng tblUser
    - Lớp Client à bảng tblClient
    - Lớp Store à bảng tblStore
    - Lớp Costume à bảng tblCostume
    - Lớp DepositItem à bảng tblDepositItem
    - Lớp Damage à bảng tblDamage
    - Lớp RentedCostume à bảng tblRentedCostume
    - Lớp RentedDeposit à bảng tblRentedDeposit
    - Lớp RentedReceipt à bảng tblRentedReceipt
    - Lớp RentedDamage à bảng tblRentedDamage
    - Lớp ReturnedCostume à bảng tblReturnedCostume
    - Lớp ReturnedDeposit à bảng tblReturnedDeposit
    - Lớp ReturnedReceipt à bảng tblReturnedReceipt
    - Lớp ReturnedDamage à bảng tblReturnedDamage
- Bước 2: Các thuộc tính không phải đối tượng của lớp nào thì chuyển thành cột của bảng tương ứng
    - tblUser: id, username, password, fullname, role
    - tblClient: id, fullname, email, tel, address, note
    - tblStore: id, name, description, address, tel
    - tblCostume: id, barcode, name, color, size, description, price, quantity, zone
    - tblDepositItem: id, name, value, note
    - tblDamage: id, name, detail, fee, note
    - tblRentedCostume: id, price, quantity, saleoff, isReturned
    - tblRentedDeposit: id, rentedAt, quantity, note
    - tblRentedReceipt: id, barcode, rentedAt, saleoff, note
    - tblRentedDamage: id, quantity, note
    - tblReturnedCostume: id, quantity, returnedAt
    - tblReturnedDeposit: id, returnedAt, quantity, note
    - tblReturnedReceipt: id, barcode, returnedAt, chargeFee, note
    - tblReturnedDamate: id, fee, quantity, isPaid
- Bước 3: Chuyển quan hệ số lượng giữa các lớp thành quan hệ số lượng giữa các bảng tương ứng
    - 1 tblUser – n tblRentedReceipt
    - 1 tblUser – n tblReturnedReceipt
    - 1 tblClient – n tblRentedReceipt
    - 1 tblClient – n tblReturnedReceipt
    - 1 tblDepositItem – n tblRentedDeposit
    - 1 tblRentedDeposit – n tblReturnedDeposit
    - 1 tblStore – n tblCostume
    - 1 tblCostume – n tblRentedCostume
    - 1 tblRentedCostume – n tblReturnedCostume
    - 1 tblRentedReceipt – n tblRentedCostume
    - 1 tblRentedReceipt – n tblRentedDeposit
    - 1 tblReturnedReceipt – n tblReturnedCostume
    - 1 tblReturnedReceipt – n tblReturnedDeposit
    - 1 tblDamage – n tblRentedDamage
    - 1 tblDamage – n tblReturnedDamage
    - 1 tblRentedCostume – n tblRentedDamage
    - 1 tblReturnedCostume – n tblReturnedDamage
- Bước 4: Bổ sung khóa: Khóa chính tương ứng với thuộc tính id của bảng. Khóa ngoại được thiết lập dựa vào quan hệ số lượng với bảng khác:
    - 1 tblUser – n tblRentedReceipt à bảng tblRentedReceipt có khóa ngoại idUser
    - 1 tblUser – n tblReturnedReceipt à bảng tblReturnedReceipt có khóa ngoại idUser
    - 1 tblClient – n tblRentedReceipt à bảng tblRentedReceipt có khóa ngoại idClient
    - 1 tblClient – n tblReturnedReceipt à bảng tblReturnedReceipt có khóa ngoại idClient
    - 1 tblDepositItem – n tblRentedDeposit à bảng tblRentedDeposit có khóa ngoại idDepositItem
    - 1 tblRentedDeposit – n tblReturnedDeposit à bảng tblReturnedDeposit có khóa ngoại idDepositItem
    - 1 tblStore – n tblCostume à bảng tblCostume có khóa ngoại idStore
    - 1 tblCostume – n tblRentedCostume à bảng tblRentedCostume có khóa ngoại idCostume
    - 1 tblRentedCostume – n tblReturnedCostume à bảng tblReturnedCostume có khóa ngoại idRentedCostume
    - 1 tblRentedReceipt – n tblRentedCostume à bảng tblRentedCostume có khóa ngoại idRentedReceipt
    - 1 tblRentedReceipt – n tblRentedDeposit à bảng tblRenderDeposit có khóa ngoại idRentedReceipt
    - 1 tblReturnedReceipt – n tblReturnedCostume à bảng tblReturnedCostume có khóa ngoại idRentedReceipt
    - 1 tblReturnedReceipt – n tblReturnedDeposit à bảng tblReturnedDeposit có khóa ngoại idReturnedReceipt
    - 1 tblDamage – n tblRentedDamage à bảng tblRentedDamage có khóa ngoại idDamage
    - 1 tblDamage – n tblReturnedDamage à bảng tblReturnedDamage có khóa ngoại idDamage
    - 1 tblRentedCostume – n tblRentedDamage à bảng tblRentedDamage có khóa ngoại idRentedCostume
    - 1 tblReturnedCostume – n tblReturnedDamage à bảng tblReturnedDamage có khóa ngoại idReturnedCostume
- Bước 5: Loại bỏ các thuộc tính dư thừa

Ta có biểu đồ thực thể quan hệ:# Returning_Costume_Module
# Returning_Costume_Module
# Returning_Costume_Module
