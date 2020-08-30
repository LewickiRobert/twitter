package pl.sda.twitter.services;

import pl.sda.twitter.peristance.dao.ArticleDao;

import java.util.List;

public class ArticleService {

    private ArticleDao articleDao = new ArticleDao();

    public List getArticles(){
        return articleDao.getArticles();
    }
}
