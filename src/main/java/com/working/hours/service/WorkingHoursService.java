package com.working.hours.service;

import java.util.List;

import com.working.hours.model.WorkingHours;

public interface WorkingHoursService {
    List<WorkingHours> getAllWorkingHours();
    WorkingHours getWorkingHoursById(Long id);
    WorkingHours createWorkingHours(WorkingHours workingHours);
    WorkingHours updateWorkingHours(Long id, WorkingHours workingHours);
    void deleteWorkingHours(Long id);
}
