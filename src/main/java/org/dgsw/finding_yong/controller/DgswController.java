package org.dgsw.finding_yong.controller;

import lombok.RequiredArgsConstructor;
import org.dgsw.finding_yong.service.DgswService;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class DgswController {

    private final DgswService dgswService;
}
