package dao;

import entity.Student_Plus;
import utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class Student_PlusDAO {
    private EntityManager em = JpaUtils.getEntityManager();
    @Override
    protected  void finalize() throws Throwable{
        em.close();
        super.finalize();
    }

    public Student_Plus create (Student_Plus entity){
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public Student_Plus update(Student_Plus entity){
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return entity;
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public Student_Plus remove(int id){
        try {
            em.getTransaction().begin();
            Student_Plus entity = this.findById(id);
            em.remove(entity);
            em.getTransaction().commit();
            return entity;
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public Student_Plus findById(int id) {
        return em.find(Student_Plus.class, id);
    }

    //Tim kiem phan trang
    public List<Student_Plus> findPage(int page, int size){
        String jpql = "Select o from Student_Plus o";
        TypedQuery<Student_Plus> query = em.createQuery(jpql, Student_Plus.class);
        query.setFirstResult(page*size);
        query.setMaxResults(size);
        return  query.getResultList();
    }

    public List<Student_Plus> searchStudents(String keyword) {
        String jpql = "SELECT s FROM Student_Plus s WHERE s.name LIKE :keyword";
        TypedQuery<Student_Plus> query = em.createQuery(jpql, Student_Plus.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }


    public List<Student_Plus> findAll(int pageNumber, int pageSize) {
        String jpql = "SELECT o FROM Student_Plus o ORDER BY o.id DESC";
        TypedQuery<Student_Plus> query = em.createQuery(jpql, Student_Plus.class);

        pageNumber = pageNumber < 1 ? 1 : pageNumber;

        query.setFirstResult((pageNumber - 1)*pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }






}
