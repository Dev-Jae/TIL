package part2_2.ch13.domain.userinfo.dao.oracle;

import part2_2.ch13.domain.userinfo.UserInfo;
import part2_2.ch13.domain.userinfo.dao.UserInfoDao;

/**
 * packageName : part2_2.ch13.domain.userinfo.dao.oracle
 * fileName : UserInfoOracleDao
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/09/06            jae                   최초생성
 */
public class UserInfoOracleDao implements UserInfoDao {

    @Override
    public void insertUserInfo(UserInfo userInfo) {
        System.out.println("Insert into Oracle DB userID = " + userInfo.getUserId());
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        System.out.println("Update set Oracle DB userID = " + userInfo.getUserId());
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        System.out.println("Delete from Oracle DB userID = " + userInfo.getUserId());
    }
}
