package com.example.vetclinica.controller;

import com.example.vetclinica.domain.Message;
import com.example.vetclinica.domain.Novost;
import com.example.vetclinica.domain.User;
import com.example.vetclinica.repos.MessageRepos;
import com.example.vetclinica.repos.NovostRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private MessageRepos messageRepos;

    @Autowired
    private NovostRepos novostRepos;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        Iterable<Novost> novost = novostRepos.findAll();
        model.put("novost",novost);

        return "greeting";
    }

    @PostMapping("/")
    public String add_news(
            @RequestParam String text,
            @RequestParam Date date_post, Map<String, Date> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Novost novost= new Novost(text,date_post);
        novostRepos.save(novost);

        Iterable<Novost> novosts = novostRepos.findAll();
        model.put("novosts", (Date) novosts);

        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> messages = messageRepos.findAll();

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepos.findByTag(filter);
        } else {
            messages = messageRepos.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Message message = new Message(text, tag, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            message.setFilename(resultFilename);
        }

        messageRepos.save(message);

        Iterable<Message> messages = messageRepos.findAll();

        model.put("messages", messages);

        return "main";
    }
}
