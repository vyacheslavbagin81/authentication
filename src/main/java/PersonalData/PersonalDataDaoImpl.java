package PersonalData;

import Roles.Role;
import Work.WorkPersistence;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
public class PersonalDataDaoImpl implements PersonalDataDao {
    @Override
    public List<PersonalData> getAllPersonal() {
        String sql = "SELECT p FROM PersonalData p";
        EntityManager entityManager = WorkPersistence.readPersistence();
        List<PersonalData> personalDataList = entityManager.createQuery(sql).getResultList();
        entityManager.getTransaction().commit();
        WorkPersistence.closePersistence(entityManager);
        return personalDataList;
    }

    @Override
    public PersonalData getPersonal(int id) {
        EntityManager entityManager = WorkPersistence.readPersistence();
        PersonalData personalData = entityManager.find(PersonalData.class, id);
        WorkPersistence.closePersistence(entityManager);
        return personalData;
    }

    @Override
    public Role getPersonalOfRole(int role_id) {
        EntityManager entityManager = WorkPersistence.readPersistence();
        Role role = entityManager.find(Role.class, role_id);
        WorkPersistence.closePersistence(entityManager);
        return role;
    }

    @Override
    public void deletePersonal(int id) {
        EntityManager entityManager = WorkPersistence.readPersistence();
        entityManager.remove(entityManager.find(PersonalData.class, id));
        WorkPersistence.closePersistence(entityManager);
    }

    @Override
    public void editPersonal(PersonalData personalData, int id) {
        EntityManager entityManager = WorkPersistence.readPersistence();
        PersonalData pd  = entityManager.find(PersonalData.class, id);
        personalData.setId(id);
        personalData.setDateAndTimeOfProfileModification(LocalDateTime.now());
        personalData.setDateAndTimeOfProfileCreation(pd.getDateAndTimeOfProfileCreation());
        entityManager.merge(personalData);
        WorkPersistence.closePersistence(entityManager);
    }

    @Override
    public void addPersonal(PersonalData personalData) {
        personalData.setDateAndTimeOfProfileCreation(LocalDateTime.now());
        EntityManager entityManager = WorkPersistence.readPersistence();
        entityManager.persist(personalData);
        WorkPersistence.closePersistence(entityManager);
    }
}
