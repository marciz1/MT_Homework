package com.homework.feed.service;

import com.homework.feed.model.Quotation;

import java.util.List;

public interface QuotationService extends Runnable {
    List<Quotation> getQuotations();
}
