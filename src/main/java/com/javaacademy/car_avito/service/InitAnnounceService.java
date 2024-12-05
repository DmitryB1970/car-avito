package com.javaacademy.car_avito.service;

import com.javaacademy.car_avito.announcement.Announcement;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
@Profile("init")
@RequiredArgsConstructor

public class InitAnnounceService {

    private static final BigDecimal MERCEDES_PRICE = BigDecimal.valueOf(50_000);
    private static final BigDecimal BMW_PRICE = BigDecimal.valueOf(52_000);
    private static final BigDecimal AUDI_PRICE = BigDecimal.valueOf(35_000);
    private static final BigDecimal KIA_PRICE = BigDecimal.valueOf(30_000);


    private final AnnouncementStorage announcementStorage;

    @PostConstruct
    public void init() {
        Announcement announcement1 = createAnnouncement("Mercedes", "black", MERCEDES_PRICE);
        Announcement announcement2 = createAnnouncement("BMW", "red", BMW_PRICE);
        Announcement announcement3 = createAnnouncement("Audi", "green", AUDI_PRICE);
        Announcement announcement4 = createAnnouncement("KIA", "blue", KIA_PRICE);

        announcementStorage.save(announcement1);
        announcementStorage.save(announcement2);
        announcementStorage.save(announcement3);
        announcementStorage.save(announcement4);
    }


    public Announcement createAnnouncement(String brandName, String color, BigDecimal price) {
        return Announcement.builder()
                .brandName(brandName)
                .color(color)
                .price(price)
                .build();
    }


}
