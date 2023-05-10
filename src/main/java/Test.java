import PersonalData.*;
import Roles.*;
import Work.PrintData;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        RoleDaoImpl rolesDao = new RoleDaoImpl();
        PersonalDataDaoImpl personalDataDao = new PersonalDataDaoImpl();

        List<Role> roles = List.of(
                Role.builder()
                        .role("Разработчик")
                        .build(),
                Role.builder()
                        .role("Аналитик")
                        .build(),
                Role.builder()
                        .role("Тестировщик")
                        .build(),
                Role.builder()
                        .role("Менеджер")
                        .build(),
                Role.builder()
                        .role("Дизайнер")
                        .build(),
                Role.builder()
                        .role("По умолчанию")
                        .build());

//        for (Role role : roles) {
//            rolesDao.addRole(role);
//        }
//        for (Role role : roles) {
//            System.out.println(role.getId());
//        }

        List<PersonalData> personalDataList = List.of(
                PersonalData.builder()
                        .name("Demand")
                        .login("gqiv")
                        .password("umydglxb")
                        .roleList(List.of(rolesDao.getRole(25)))
                        .build(),
                PersonalData.builder()
                        .name("Actress")
                        .login("lcbamivn")
                        .password("hnbg")
                        .roleList(List.of(rolesDao.getRole(22), rolesDao.getRole(24)))
                        .build(),
                PersonalData.builder()
                        .name("Event")
                        .login("hftpqj")
                        .password("xllwhux")
                        .roleList(List.of(rolesDao.getRole(25), rolesDao.getRole(20)))
                        .build(),
                PersonalData.builder()
                        .name("Excuse")
                        .login("zpomidi")
                        .password("bltfpn")
                        .roleList(List.of(rolesDao.getRole(23), rolesDao.getRole(22), rolesDao.getRole(24)))
                        .build(),
                PersonalData.builder()
                        .name("Pupil")
                        .login("tsmy")
                        .password("cvk")
                        .roleList(List.of(rolesDao.getRole(21)))
                        .build(),
                PersonalData.builder()
                        .name("Limit")
                        .login("tuwxfdk")
                        .password("xfvszkl")
                        .roleList(List.of(rolesDao.getRole(21), rolesDao.getRole(22)))
                        .build());

//        for (PersonalData pd : personalDataList) {
//            personalDataDao.addPersonal(pd);
//        }

//        int i = 3;
//        for (PersonalData pd : personalDataList) {
//            personalDataDao.editPersonal(pd, i);
//            i++;
//        }

        PrintData.printRole(personalDataDao.getPersonalOfRole(25));

//        PrintData.printPersonal(personalDataDao.getPersonal(4));

    }
}
