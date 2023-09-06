package part2_2.ch13.web.userinfo;

import part2_2.ch13.domain.userinfo.UserInfo;
import part2_2.ch13.domain.userinfo.dao.UserInfoDao;
import part2_2.ch13.domain.userinfo.dao.mysql.UserInfoMySqlDao;
import part2_2.ch13.domain.userinfo.dao.oracle.UserInfoOracleDao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * packageName : part2_2.ch13.web.userinfo
 * fileName : UserInfoClient
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/09/06            jae                   최초생성, 인터페이스 다향성
 */
public class UserInfoClient {
    public static void main(String[] args) throws IOException {

        // 파일에서 바이트 단위로 입력할 수 있도록 하는 클래스(다양한 타입의 확장자를 가진 파일을 읽기 위해 사용)
        FileInputStream fis = new FileInputStream("db.properties");

        // properties 파일에 저장된 설정정보를 사용할 수 있도록 도와주는 클래스, Hashtables의 하위 클래스 이므로 Map의 속성 사용
        Properties properties = new Properties();
        properties.load(fis);

        String dbType = properties.getProperty("DBTYPE");
        System.out.println("DB Type : " + dbType);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("12345");
        userInfo.setPassword("!@#!@$");
        userInfo.setUserName("Chu");

        UserInfoDao userInfoDao = null;

        if(dbType.equals("ORACLE")){
            userInfoDao = new UserInfoOracleDao();
        } else if(dbType.equals("MYSQL")){
            userInfoDao = new UserInfoMySqlDao();
        } else{
            System.out.println("db error");
            return;
        }

        userInfoDao.insertUserInfo(userInfo);
        userInfoDao.updateUserInfo(userInfo);
        userInfoDao.deleteUserInfo(userInfo);

    }
}
