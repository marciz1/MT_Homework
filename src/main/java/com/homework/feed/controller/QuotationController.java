package com.homework.feed.controller;

import com.homework.feed.model.Quotation;
import com.homework.feed.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/feedService")
public class QuotationController {

    private final QuotationService service;

    @Autowired
    public QuotationController(QuotationService service) {
        this.service = service;
    }

    @RequestMapping(
        value = "/instruments",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Quotation> getQuotations() {
        return service.getQuotations();
    }
}
