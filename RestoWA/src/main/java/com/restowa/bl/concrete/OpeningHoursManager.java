package com.restowa.bl.concrete;

import com.restowa.domain.model.OpeningHours;
import com.restowa.domain.repository.OpeningHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OpeningHoursManager {

    private OpeningHoursRepository repo;

    public OpeningHoursManager() {

    }

    @Autowired
    public OpeningHoursManager(OpeningHoursRepository ohrepo) {
        this.repo = ohrepo;
    }

    public OpeningHours getOpeningHoursById(int id) {
        return this.repo.findById(id).get();
    }
}
