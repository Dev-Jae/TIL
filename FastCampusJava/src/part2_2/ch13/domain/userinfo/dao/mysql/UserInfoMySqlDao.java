package part2_2.ch13.domain.userinfo.dao.mysql;

import part2_2.ch13.domain.userinfo.UserInfo;
import part2_2.ch13.domain.userinfo.dao.UserInfoDao;

/**
 * packageName : part2_2.ch13.domain.userinfo.dao.mysql
 * fileName : UserInfoMySqlDao
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/09/06            jae                   최초생성
 */
public class UserInfoMySqlDao implements UserInfoDao {

    @Override
    public void insertUserInfo(UserInfo userInfo) {
        System.out.println("Insert into MySQL DB userID = " + userInfo.getUserId());
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        System.out.println("Update set MySQL DB userID = " + userInfo.getUserId());
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        System.out.println("Delete from MySQL DB userID = " + userInfo.getUserId());
    }
}
