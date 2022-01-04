package cinema.project.dao.impl;

import cinema.project.dao.TicketDao;
import cinema.project.exception.DataProcessingException;
import cinema.project.lib.Dao;
import cinema.project.model.Ticket;
import cinema.project.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class TicketDaoImpl implements TicketDao {
    @Override
    public Ticket add(Ticket ticket) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert ticket: " + ticket, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
