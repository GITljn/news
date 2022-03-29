package com.ljn.service;

import com.ljn.entity.News;
import com.ljn.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;

    public Boolean insertNews(News news) {
        news.setCreate(new Date());
        int count = newsMapper.insertNews(news);
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean deleteNews(Integer id) {
        int count = newsMapper.deleteNews(id);
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean updateNews(News news) {
        int count = newsMapper.updateNews(news);
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    public News selectNews(Integer id) {
        return newsMapper.selectNews(id);
    }

    public ArrayList<News> selectNewsByPage(Integer page, Integer size) {
        return newsMapper.selectNewsByPage((page-1) * size, size);
    }

    public Boolean deleteNewsBatch(Integer[] ids) {
        int count = newsMapper.deleteNewsBatch(ids);
        if (count == ids.length) {
            return true;
        } else {
            return false;
        }
    }
}
