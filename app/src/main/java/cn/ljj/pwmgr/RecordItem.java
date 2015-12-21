package cn.ljj.pwmgr;

public class RecordItem {
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_KEYWORD = "keyword";
    public static final String KEY_PASSWORD = "password";
    private String description;
    private String keyword;
    private String password;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String str) {
        if(str == null) {
            return;
        }
        keyword = str;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String str) {
        if(str == null) {
            return;
        }
        description = str;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String str) {
        if(str == null) {
            return;
        }
        password = str;
    }
}
