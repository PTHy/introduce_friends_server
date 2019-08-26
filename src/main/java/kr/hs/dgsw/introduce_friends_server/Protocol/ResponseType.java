package kr.hs.dgsw.introduce_friends_server.Protocol;

public enum ResponseType {
    FAIL(0, "명령을 실행하지 못했습니다"),

    GET_POSTS_SUCCESS(100, "글 리스트 조회에 성공하였습니다"),
    CREATE_POST_SUCCESS(101, "글 생성에 성공하였습니다"),
    MODIFY_POST_SUCCESS(102, "글 수정에 성공하였습니다"),
    DELETE_POST_SUCCESS(103, "글 삭제에 성공하였습니다"),

    GET_USERS_SUCCESS(200, "유저 리스트 조회에 성공하였습니다"),
    REGISTER_USER_SUCCESS(201, "유저 회원가입에 성공하였습니다"),
    LOGIN_USER_SUCCESS(202, "유저 로그인에 성공하였습니다"),
    MODIFY_USER_SUCCESS(203, "유저 정보 수정에 성공하였습니다"),
    DELETE_USER_SUCCESS(204, "회원 탈퇴에 성공하였습니다");


    final private int code;
    final private String desc;

    ResponseType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int code() { return this.code; }

    public String desc() { return this.desc; }
}
