package com.ctl.telepresencek8s;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "qotm")
public interface QotmClient {

    @GetMapping(path = "/")
    Quote getQuote();
}
