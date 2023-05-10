package PersonalData;

import Roles.Role;

import java.util.List;

public interface PersonalDataDao {
    List<PersonalData> getAllPersonal();

    PersonalData getPersonal(int id);

    Role getPersonalOfRole(int role_id);

    void deletePersonal(int id);

    void addPersonal(PersonalData personalData);

    void editPersonal(PersonalData personalData, int id);
}
