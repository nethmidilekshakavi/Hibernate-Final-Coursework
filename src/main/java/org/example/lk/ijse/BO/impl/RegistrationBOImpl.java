package org.example.lk.ijse.BO.impl;
import org.example.lk.ijse.BO.custom.RegistrationBO;
import org.example.lk.ijse.DAO.DaoFactory;
import org.example.lk.ijse.DAO.cutom.CourseDao;
import org.example.lk.ijse.DAO.cutom.PaymentDao;
import org.example.lk.ijse.DAO.cutom.RegistrationDao;
import org.example.lk.ijse.DAO.cutom.StudentDao;
import org.example.lk.ijse.Entity.Course;
import org.example.lk.ijse.Entity.Payment;
import org.example.lk.ijse.Entity.Registration;
import org.example.lk.ijse.Entity.Student;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {
    CourseDao courseDao = (CourseDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.COURSE);
    StudentDao studentDao = (StudentDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.STUDENT);
    RegistrationDao registrationDao = (RegistrationDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.REGISTRATION);
    PaymentDao paymentDao = (PaymentDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.PAYMENT);


    @Override
    public boolean saveCourse(Course entity) throws IOException {
        return courseDao.save(new Course(entity.getId(),entity.getProgramId(),entity.getProgramName(),entity.getDuration(),entity.getFee(),entity.getRegistrations()));
    }

    @Override
    public boolean updateCourse(Course entity) throws IOException {
        return courseDao.update(new Course(entity.getId(),entity.getProgramId(),entity.getProgramName(),entity.getDuration(),entity.getFee(),entity.getRegistrations()));
    }

    @Override
    public boolean deleteCourse(String id) throws IOException {
        return courseDao.delete(id);
    }

    @Override
    public List<Course> getAllCourse() throws IOException {

        List<Course> allCourse = courseDao.getaAll();
        return allCourse;

    }

    @Override
    public List<Course> SearchCID(String cid) throws IOException {
        return courseDao.SearchCID(cid);

    }


    @Override
    public boolean saveStudent(Student entity) throws IOException {
        return studentDao.save(new Student(entity.getId(),entity.getFirstName(),entity.getLastName(),entity.getAddress(),entity.getEmail(),entity.getPhoneNumber(),entity.getEnrollmentDate(),entity.getRegistrations(),entity.getRole()));
    }


    @Override
    public boolean updateStudent(Student entity) throws IOException {
        return studentDao.update(new Student(entity.getId(),entity.getFirstName(),entity.getLastName(),entity.getAddress(),entity.getEmail(),entity.getPhoneNumber(),entity.getEnrollmentDate(),entity.getRegistrations(),entity.getRole()));
    }

    @Override
    public boolean deleteStudent(int id) throws IOException {
        return studentDao.delete(id);
    }

    @Override
    public List<Student> getAllStudent() throws IOException {

        List<Student> allStudent = studentDao.getaAll();
        return allStudent;

    }

    @Override
    public List<Student> SearchSID(int sid) throws IOException {

        return studentDao.SearchSID(sid);

    }

    @Override
    public Student serachbyIDS(int cid) throws SQLException, ClassNotFoundException {
        return studentDao.searchById(cid);
    }


    @Override
    public Course serachbyCIDs(String cid) throws SQLException, ClassNotFoundException {
        return courseDao.searchByCId(cid);
    }

    @Override
    public boolean saveRegistration(Registration registration, Payment payment) {
        try {
            boolean registrationSaved = registrationDao.save(new Registration(
                    registration.getId(),
                    registration.getEnrollmentDate(),
                    registration.getPayment(),
                    registration.getDueAmount(),
                    registration.getStudentName(),
                    registration.getProgramName(),
                    registration.getDuration(),
                    registration.getStudent(),
                    registration.getCourse(),
                    registration.getPaymentList()
            ));

            boolean paymentSaved = paymentDao.save(new Payment(
                    payment.getId(),
                    payment.getEnrollmentDate(),
                    payment.getPayment(),
                    payment.getDueAmount(),
                    payment.getStudentName(),
                    payment.getProgramName(),
                    payment.getDuePayment(),
                    payment.getRegistration()
            ));

            // Return true if both save operations are successful
            return registrationSaved && paymentSaved;
        } catch (IOException e) {
            // Log the error and rethrow if necessary
            System.err.println("IOException occurred: " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            // Catch any other exceptions that might occur
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public List<Registration> getAllRegistrationDetails() throws IOException {
        List<Registration> alldetails = registrationDao.getaAll();
        return alldetails;
    }

    @Override
    public boolean deleteRegistration(Long id) throws IOException {
        return registrationDao.delete(id);
    }

    @Override
    public Registration serachbyRID(Long rid) throws SQLException, ClassNotFoundException {
        return registrationDao.searchByRID(rid);
    }

    @Override
    public boolean updateRegistration(Registration registration) throws SQLException {
        try (Session session = FactoryConfiguration.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // HQL query to update dueAmount
            String hql = "UPDATE Registration r SET r.dueAmount = :dueAmount WHERE r.id = :id";

            Query query = session.createQuery(hql);
            query.setParameter("dueAmount", registration.getDueAmount());
            query.setParameter("id", registration.getId());

            int result = query.executeUpdate();

            if (result > 0) {
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Error updating registration due amount", e);
        }
    }

}
