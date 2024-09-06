package com.working.hours.serviceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.working.hours.model.WorkingHours;
import com.working.hours.repo.WorkingHoursRepository;
import com.working.hours.service.WorkingHoursService;

@Service
public class WorkingHoursServiceImpl implements WorkingHoursService {

    @Autowired
    private WorkingHoursRepository workingHoursRepository;

    @Override
    public List<WorkingHours> getAllWorkingHours() {
        return workingHoursRepository.findAll();
    }

    @Override
    public WorkingHours getWorkingHoursById(Long id) {
        Optional<WorkingHours> workingHours = workingHoursRepository.findById(id);
        return workingHours.orElse(null);  // Return null if not found
    }

    @Override
    public WorkingHours createWorkingHours(WorkingHours workingHours) {
        return workingHoursRepository.save(workingHours);
    }

    @Override
    public WorkingHours updateWorkingHours(Long id, WorkingHours workingHours) {
        Optional<WorkingHours> existingRecord = workingHoursRepository.findById(id);
        if (existingRecord.isPresent()) {
            WorkingHours existing = existingRecord.get();
            existing.setDayOfWeek(workingHours.getDayOfWeek());
            existing.setOpenTime(workingHours.getOpenTime());
            existing.setCloseTime(workingHours.getCloseTime());
            return workingHoursRepository.save(existing);
        }
        return null;  // Or handle with an exception
    }

    @Override
    public void deleteWorkingHours(Long id) {
        workingHoursRepository.deleteById(id);
    }
}
