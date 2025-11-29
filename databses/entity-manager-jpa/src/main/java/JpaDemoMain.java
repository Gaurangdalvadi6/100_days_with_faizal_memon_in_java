import jakarta.persistence.EntityManager;

public class JpaDemoMain {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();

        try{
            UserClassHibernate user = new UserClassHibernate("Dev");
            entityManager.getTransaction().begin();
            entityManager.persist(user); // save(user)
            entityManager.getTransaction().commit();
            System.out.println("User saved : " + user.getId());
        }catch (Exception e){
            e.printStackTrace();;
        } finally {
            entityManager.close();
            JPAUtil.close();
        }
    }
}
