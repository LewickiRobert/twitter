package pl.sda.twitter.peristance.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.sda.twitter.peristance.HibernateUtil;
import pl.sda.twitter.peristance.entities.TbArticle;
import pl.sda.twitter.peristance.entities.TbUser;

import java.util.List;

public class ArticleDao {

    public void addNewArticle(TbUser tbUser, String content) {
        try (final Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            final TbArticle tbArticle = new TbArticle();
            tbArticle.setContent(content);
            tbArticle.setUser(tbUser);
            session.save(tbArticle);
            session.getTransaction().commit();
        }
    }

    public List getArticles() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            final Query q = session.createQuery("SELECT o from " + TbArticle.class.getName() + " o");
            session.getTransaction().commit();
            return q.getResultList();

        }
    }
}
