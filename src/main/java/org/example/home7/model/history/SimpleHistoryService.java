package org.example.home7.model.history;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SimpleHistoryService implements HistoryService {

    private static final Logger log = LoggerFactory.getLogger(SimpleHistoryService.class);

    private final List<String> historyRecords;

    public SimpleHistoryService() {
        this.historyRecords = new ArrayList<>();
    }

    @Override
    public void addHistoryRecord(String historyRecord) {
        historyRecords.add(historyRecord);
        log.debug("Added history record [{}] to history", historyRecord);
    }

    @Override
    public List<String> getHistory() {
        log.debug("Getting all history records...");
        return historyRecords;
    }
}
