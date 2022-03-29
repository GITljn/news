package com.ljn.mapper;

import com.ljn.entity.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface NewsMapper {
    int insertNews(News news);

    int deleteNews(Integer id);

    int updateNews(News news);

    News selectNews(Integer id);

    ArrayList<News> selectNewsByPage(int start, Integer size);

    int deleteNewsBatch(Integer[] ids);
}
