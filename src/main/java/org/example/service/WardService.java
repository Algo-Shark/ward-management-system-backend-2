package org.example.service;

import org.example.dto.WardDto;

public interface WardService {
    public WardDto addWard(WardDto wardDto);

    String generateWardId();
}
