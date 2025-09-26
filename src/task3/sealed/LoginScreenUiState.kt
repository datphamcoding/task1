package task3.sealed

/**
 * Lớp `LoginScreenUiState` là một sealed class đại diện cho các trạng thái khác nhau của giao diện người dùng (UI).
 * Việc sử dụng sealed class giúp đảm bảo rằng tất cả các trạng thái có thể có của UI đều được định nghĩa
 * và xử lý một cách tường minh, giúp mã nguồn dễ quản lý và ít lỗi hơn.
 */
sealed class LoginScreenUiState {
   /**
    * Trạng thái `Loading` biểu thị rằng dữ liệu đang được tải hoặc xử lý.
    */
   object Loading : LoginScreenUiState()
   /**
    * Trạng thái `Success` biểu thị rằng hoạt động đã thành công và trả về dữ liệu.
    * @param data Dữ liệu được trả về sau khi hoạt động thành công.
    */
   data class Success(val data: String) : LoginScreenUiState()
   /**
    * Trạng thái `Error` biểu thị rằng đã xảy ra lỗi trong quá trình xử lý.
    * @param message Thông báo lỗi mô tả chi tiết về lỗi đã xảy ra.
    */
   data class Error(val message: String) : LoginScreenUiState()
}