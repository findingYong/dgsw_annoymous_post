package org.dgsw.finding_yong.service;

import lombok.RequiredArgsConstructor;
import org.dgsw.finding_yong.repository.DgswRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DgswService {

    private final DgswRepository dgswRepository;
}
