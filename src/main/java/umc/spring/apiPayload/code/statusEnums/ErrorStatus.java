package umc.spring.apiPayload.code.statusEnums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),


    // 멤버 관려 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "해당하는 회원 ID가 존재하지 않습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    // 예시,,,
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    // 테스트용
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),

    // 음식 카테고리
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "FOOD_CATEGORY4001", "해당하는 음식 카테고리 ID가 존재하지 않습니다."),

    // 가게 카테고리
    STORE_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "STORE_CATEGORY4001", "해당하는 가게 카테고리 ID가 존재하지 않습니다."),

    // 지역
    REGION_NOT_FOUND(HttpStatus.BAD_REQUEST, "REGION4001", "해당하는 지역 ID가 존재하지 않습니다."),

    // 가게
    STORE_NOT_FOUND(HttpStatus.BAD_REQUEST, "STORE4001", "해당하는 가게 ID가 존재하지 않습니다."),

    // 미션
    MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST, "MISSION4001", "해당하는 미션 ID가 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}