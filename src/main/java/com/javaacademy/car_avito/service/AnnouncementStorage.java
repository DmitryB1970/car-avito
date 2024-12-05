package com.javaacademy.car_avito.service;

import com.javaacademy.car_avito.announcement.Announcement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class AnnouncementStorage {

    private final Map<Integer, Announcement> announcementMap = new HashMap<>();
    private Integer count = 0;


    // 3.1 Сохранение объявления
    public void save(Announcement announcement) {
        count++;
        announcement.setId(count);
        announcementMap.put(count, announcement);
    }

    //     3.2 Получение всех объявлений
    public List<Announcement> getAll() {
        return announcementMap.values().stream().collect(Collectors.toList());
    }

    // 3.3 Получение объявлений по идентификатору
    public Optional<Announcement> getById(Integer id) {
        return Optional.ofNullable(announcementMap.get(id));
    }

    // 3.4 Удаление по id
    public boolean deleteById(Integer id) {
        return announcementMap.remove(id) != null;
    }

    // Удаление всех элементов
    public void deleteAll() {
        announcementMap.clear();
    }

    // Нахождение по названию бренда
    public List<Announcement> getByBrand(String brandName) {
        return announcementMap.values().stream()
                .filter(announcement -> Objects.equals(announcement.getBrandName(), brandName))
                .collect(Collectors.toList());
    }

    //  6* Нахождение по разным параметрам(не работает как надо: отрабатывает только первый параметр)
    public List<Announcement> getByDiffParameters(String brandName, String color, BigDecimal price) {
        return announcementMap.values().stream()
                .filter(announcement -> Objects.equals(announcement.getBrandName(), brandName))
                .filter(announcement -> Objects.equals(announcement.getColor(), color))
                .filter(announcement -> Objects.equals(announcement.getPrice(), price))
                .collect(Collectors.toList());
    }

}
