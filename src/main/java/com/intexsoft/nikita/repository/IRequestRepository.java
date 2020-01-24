package com.intexsoft.nikita.repository;

import com.intexsoft.nikita.entity.Request;

public interface IRequestRepository {

    Request getRequestById(Long id);
}
