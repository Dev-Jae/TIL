package part2_2.ch13.domain.userinfo.dao;

import part2_2.ch13.domain.userinfo.UserInfo;

/**
 * packageName : part2_2.ch13.domain.userinfo.dao
 * fileName : UserInfoDao
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/09/06            jae                   최초생성
 */
public interface UserInfoDao {

    void insertUserInfo(UserInfo userInfo);
    void updateUserInfo(UserInfo userInfo);
    void deleteUserInfo(UserInfo userInfo);

}
