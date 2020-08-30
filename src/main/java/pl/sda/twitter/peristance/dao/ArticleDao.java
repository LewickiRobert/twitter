package pl.sda.twitter.peristance.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.sda.twitter.peristance.HibernateUtil;
import pl.sda.twitter.peristance.entities.TbArticle;

import java.util.List;

public class ArticleDao {

    public List getArticles(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            final Query q = session.createQuery("SELECT o from "+ TbArticle.class.getName() +" o");
            session.getTransaction().commit();
            return q.getResultList();

        }
    }
}
