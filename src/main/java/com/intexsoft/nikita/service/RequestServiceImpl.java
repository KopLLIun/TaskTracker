package com.intexsoft.nikita.service;

import com.intexsoft.nikita.entity.Request;
import com.intexsoft.nikita.repository.IRequestRepository;
import com.intexsoft.nikita.repository.RequestRepositoryImpl;

public class RequestServiceImpl implements IRequestService {

    private final IRequestRepository requestRepository = new RequestRepositoryImpl();

    @Override
    public Request getRequestById(Long id) {
        return requestRepository.getRequestById(id);
    }
}
