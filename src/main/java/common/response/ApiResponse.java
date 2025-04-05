package common.response;
import common.response.code.CommonCode;

public record ApiResponse<T>(
    String code,
    String message,
    T data
) {
  public static <T> ApiResponse<T> from(String code, String message, T data) {
    return new ApiResponse<>(code, message, data);
  }

  public static <T> ApiResponse<T> success() {
    return new ApiResponse<>(CommonCode.COMMON_SUCCESS.getCode(), CommonCode.COMMON_SUCCESS.getMessage(), null);
  }

  public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>(CommonCode.COMMON_SUCCESS.getCode(), CommonCode.COMMON_SUCCESS.getMessage(), data);
  }

  public static <T> ApiResponse<T> fail(String code, String message) {
    return new ApiResponse<>(code, message, null);
  }
}