package com.ctl.telepresencek8s;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DummyRestController {

    private final QotmClient qotmClient;

    @Autowired
    public DummyRestController(QotmClient qotmClient) {
        this.qotmClient = qotmClient;
    }

    @GetMapping(path = "/quote/{name}")
    public String quote(@PathVariable String name) {
        final String quote = qotmClient.getQuote().getQuote();
        return String.format("A quote for %s: %s", name, quote);
    }
}
