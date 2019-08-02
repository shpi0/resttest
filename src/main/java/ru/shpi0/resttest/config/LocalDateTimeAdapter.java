package ru.shpi0.resttest.config;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(v,DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Override
    public String marshal(LocalDateTime v) throws Exception {
        return v.format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss"));
    }

}
