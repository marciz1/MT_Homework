package com.homework.feed.service.impl;

import com.homework.feed.model.Quotation;
import com.homework.feed.service.QuotationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuotationServiceImpl implements QuotationService {

    private static final String FEED_HOST = "5.39.85.131";
    private static final int FEED_PORT = 2302;

    private static final Logger LOGGER = LoggerFactory.getLogger(QuotationServiceImpl.class);

    private Map<String, Quotation> quotations = new HashMap<>();

    @Override
    public void run() {
        String input;

        try (
            Socket socket = new Socket(FEED_HOST, FEED_PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)
        ) {

            logIn(reader, writer);
            while ((input = reader.readLine()) != null) {
                updateQuotations(input);
            }

        } catch (UnknownHostException e) {
            LOGGER.error("Host [" + e.getMessage() + "] does not exist");
        } catch (IOException e) {
            LOGGER.error("Connection refused with [" + FEED_HOST + ":" + FEED_PORT + "]");
        }
    }

    @Override
    public List<Quotation> getQuotations() {
        return new ArrayList<>(quotations.values());
    }

    private void updateQuotations(String input) {
        String[] parts = input.split(" +");
        Quotation quotation = new Quotation(parts[0], Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), new Date());
        quotations.put(quotation.getInstrument(), quotation);
    }

    private void logIn(BufferedReader reader, PrintWriter writer) throws IOException {
        reader.readLine();
        writer.println("abc");
        reader.readLine();
        writer.println("abc123");
        reader.readLine();
        writer.println("> Symbols:ALL");
    }
}
