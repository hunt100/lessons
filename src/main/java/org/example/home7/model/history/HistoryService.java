package org.example.home7.model.history;

import java.util.List;

public interface HistoryService {

    void addHistoryRecord(String historyRecord);

    List<String> getHistory();

}
