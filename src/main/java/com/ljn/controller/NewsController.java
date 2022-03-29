package com.ljn.controller;

import com.ljn.entity.News;
import com.ljn.service.NewsService;
import com.ljn.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @PostMapping("/insertNews")
    public Result insertNews(@RequestBody News news) {
        Boolean flag = newsService.insertNews(news);
        if (flag) {
            return Result.ok().message("插入成功");
        } else {
            return Result.error().message("插入失败");
        }
    }

    @DeleteMapping("/deleteNews/{id}")
    public Result deleteNews(@PathVariable Integer id) {
        Boolean flag = newsService.deleteNews(id);
        if (flag) {
            return Result.ok().message("删除成功");
        } else {
            return Result.error().message("删除失败");
        }
    }

    @PostMapping("/updateNews")
    public Result updateNews(@RequestBody News news) {
        Boolean flag = newsService.updateNews(news);
        if (flag) {
            return Result.ok().message("修改成功");
        } else {
            return Result.error().message("修改失败");
        }
    }

    @GetMapping("/selectNews/{id}")
    public Result selectNews(@PathVariable Integer id) {
        News news = newsService.selectNews(id);
        if (news != null) {
            return Result.ok().message("查找成功").data("news", news);
        } else {
            return Result.error().message("查找失败").data("news", null);
        }
    }

    @GetMapping("/selectNewsByPage/{page}/{size}")
    public Result selectNewsByPage(@PathVariable Integer page,
                                   @PathVariable Integer size) {
        ArrayList<News> newsArrayList = newsService.selectNewsByPage(page, size);
        return Result.ok().message("查找成功").data("newsList", newsArrayList);
    }

    @DeleteMapping("/deleteNewsBatch")
    public Result deleteNewsBatch(@RequestBody Integer[] ids) {
        Boolean flag = newsService.deleteNewsBatch(ids);
        if (flag) {
            return Result.ok().message("删除成功");
        } else {
            return Result.error().message("删除失败");
        }
    }
}
