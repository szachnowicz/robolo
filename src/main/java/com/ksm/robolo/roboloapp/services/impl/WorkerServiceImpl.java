package com.ksm.robolo.roboloapp.services.impl;

import com.ksm.robolo.roboloapp.domain.TaskEntity;
import com.ksm.robolo.roboloapp.domain.WorkerEntity;
import com.ksm.robolo.roboloapp.repository.UserRepository;
import com.ksm.robolo.roboloapp.repository.WorkerRepository;
import com.ksm.robolo.roboloapp.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl extends AbstractService<WorkerEntity> {

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.repository = workerRepository;
    }


}