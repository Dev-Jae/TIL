package part2_2.ch13.domain.userinfo;

/**
 * packageName : part2_2.ch13.domain.userinfo
 * fileName : UserInfo
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/09/06            jae                   최초생성
 */
public class UserInfo {

    private String userId;
    private String password;
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
