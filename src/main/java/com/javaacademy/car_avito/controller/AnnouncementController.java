package com.javaacademy.car_avito.controller;

import com.javaacademy.car_avito.announcement.Announcement;
import com.javaacademy.car_avito.service.AnnouncementStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Controller - перехват Http-запросов
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/announcement")
public class AnnouncementController {

    private final AnnouncementStorage announcementStorage;

    //     4.1 Создать объявление
    @PostMapping
    public void saveAnnouncement(@RequestBody Announcement announcement) {
        announcementStorage.save(announcement);
    }

    //   4.2 Получить объявления по определённому бренду
    @GetMapping("/search")
    public List<Announcement> getAllByBrand(@RequestParam String brandName) {
        return announcementStorage.getByBrand(brandName);
    }

    // 4.3 Удалить объявление по уникальному идентификатору
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        return announcementStorage.deleteById(id);
    }

    // 4.4 Нахождение машины по уникальному идентификатору(id)
    @GetMapping("/{id}")
    public Announcement getAnnouncementById(@PathVariable Integer id) {
        return announcementStorage.getById(id).get();
    }

    // Получение всех объявлений
    @GetMapping
    public List<Announcement> getAll() {
        return announcementStorage.getAll();
    }

    // Удаление всех объявлений
    @DeleteMapping
    public void deleteAll() {
        announcementStorage.deleteAll();
    }

    // 6 * Получение по любым параметрам(правильно не работает)
    @GetMapping("/params/search")
    public void getAnnouncementForDiffParameters(@RequestParam(required = false) String brandName,
                                                 @RequestParam(required = false) String color,
                                                 @RequestParam(required = false) BigDecimal price) {
        announcementStorage.getByDiffParameters(brandName, color, price);
    }


}
