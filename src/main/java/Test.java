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

        List<PersonalData> personalDataList = List.of(
                PersonalData.builder()
                        .name("Demand")
                        .login("gqiv")
                        .password("umydglxb")
                        .roleList(List.of(roles.get(1)))
                        .build(),
                PersonalData.builder()
                        .name("Actress")
                        .login("lcbamivn")
                        .password("hnbg")
                        .roleList(List.of(roles.get(2), roles.get(1)))
                        .build(),
                PersonalData.builder()
                        .name("Event")
                        .login("hftpqj")
                        .password("xllwhux")
                        .roleList(List.of(roles.get(2), roles.get(3)))
                        .build(),
                PersonalData.builder()
                        .name("Excuse")
                        .login("zpomidi")
                        .password("bltfpn")
                        .roleList(List.of(roles.get(1), roles.get(5), roles.get(4)))
                        .build(),
                PersonalData.builder()
                        .name("Pupil")
                        .login("tsmy")
                        .password("cvk")
                        .roleList(List.of(roles.get(0)))
                        .build(),
                PersonalData.builder()
                        .name("Limit")
                        .login("tuwxfdk")
                        .password("xfvszkl")
                        .roleList(List.of(roles.get(0), roles.get(3)))
                        .build());

        for (PersonalData pd : personalDataList) {
            personalDataDao.addPersonal(pd);
        }

        for (PersonalData pd : personalDataDao.getAllPersonal()){
            PrintData.printPersonal(pd);
        }

        PersonalData personalData = personalDataList.get(1);
        Role role = roles.get(2);

        personalData.setName("Replace");
        personalDataDao.editPersonal(personalData, personalData.getId());

        PrintData.printPersonal(personalDataDao.getPersonal(personalData.getId()));

        PrintData.printRole(personalDataDao.getPersonalOfRole(role.getId()));

        personalDataDao.deletePersonal(personalData.getId());

        for (PersonalData pd : personalDataDao.getAllPersonal()){
            PrintData.printPersonal(pd);
        }

    }
}
