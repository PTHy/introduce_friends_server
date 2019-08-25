package kr.hs.dgsw.introduce_friends_server.Protocol;

public enum ResponseType {
    FAIL(0, "명령을 실행하지 못했습니다");

    final private int code;
    final private String desc;

    ResponseType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int code() { return this.code; }

    public String desc() { return this.desc; }
}
