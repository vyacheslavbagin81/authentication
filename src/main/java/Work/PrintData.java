package Work;

import PersonalData.PersonalData;
import Roles.Role;

import java.time.format.DateTimeFormatter;

public class PrintData {
    public static void printPersonal(PersonalData personalData) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy kk:mm");
        String dataSozd = personalData.getDateAndTimeOfProfileCreation().format(formatter);
        String dataRed = "Ne redakt";
        StringBuilder spisokRoles = new StringBuilder();
        for (Role role : personalData.getRoleList()) {
            spisokRoles.append(role.getRole()).append(", ");
        }
        if (personalData.getDateAndTimeOfProfileModification() != null) {
            dataRed = personalData.getDateAndTimeOfProfileModification().format(formatter);
        }
        printSep();
        System.out.print("Персональные данные под id №" + personalData.getId() + " созданы " + dataSozd + "\n" +
                "были отредактированы - " + dataRed + "\n" +
                "name: " + personalData.getName() + "\n" +
                "login: " + personalData.getLogin() + "\n" +
                "password: " + personalData.getPassword() + "\n" +
                "роли: " + spisokRoles + "\n");
        printSep();
    }

    public static void printRole(Role role) {
        StringBuilder spisokRoles = new StringBuilder();
        for (PersonalData personalData : role.getPersonalDataList()) {
            spisokRoles.append("id " + personalData.getId() + " " + personalData.getName()).append(", ");
        }
        printSep();
        System.out.printf("Под ролью %s были созданы следующие аккаунты:\n", role.getRole());
        System.out.println(spisokRoles);
        printSep();
    }

    private static void printSep() {
        System.out.println("-----------------------------------------------");
    }
}
