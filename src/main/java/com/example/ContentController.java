package com.example;

import entity.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.ContentRepository;


/**
 * Created by 80561 on 2017/3/17.
 */
@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentRepository repository;

    // ！！！增删查改 swagger
    // 添加
    @PostMapping
    public long create(@RequestBody Content content){
        repository.save(content);
        return content.getId();
    }

    @PutMapping
    public Boolean update(@RequestBody Content content){
        repository.save(content);

        return true;
    }

    // 删除
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable long id){
        repository.delete(id);
        return true;
    }

    // 查找
    @GetMapping("/{id}")
    public Content get(@PathVariable long id) {
        Content content = repository.findOne(id);

        return content;
    }
    //保存
    @PostMapping(value = "/{id}")
    public Long updatePassage(@RequestBody Content content,@PathVariable Long id){
        Content new_content = repository.findOne(id);
        new_content.setContent(content.getContent());
        new_content.setTitle(content.getTitle());
        new_content.setTime(content.getTime());
        repository.save(new_content);
        return new_content.getId();

    }
}
