package com.mihisa.remindme.server.controller;


import com.mihisa.remindme.server.entity.Remind;
import com.mihisa.remindme.server.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ReminderController {

    @Autowired
    private ReminderService service;

    @RequestMapping(value = "/reminders", method = GET)
    @ResponseBody
    public List<Remind> getAllReminders() {

        return service.getAll();
    }

    @RequestMapping(value = "/reminders/{id}", method = GET)
    @ResponseBody
    public Remind getReminder(@PathVariable("id") long remindID) {
        //return createMockRemind();
        return service.getById(remindID);
    }

    @RequestMapping(value = "/reminders/{id}", method = POST)
    @ResponseBody
    public Remind saveReminder(@RequestBody Remind remind) {
        return service.save(remind);
    }

    @RequestMapping(value = "/reminders/{id}", method = DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        service.remove(id);
    }
    private Remind createMockRemind() {
        Remind remind = new Remind();
        remind.setId(1);
        remind.setRemindDate(new Date());
        remind.setTitle("My first remind");

        return remind;
    }
}




