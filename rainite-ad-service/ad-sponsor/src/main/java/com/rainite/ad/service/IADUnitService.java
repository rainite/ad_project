package com.rainite.ad.service;

import com.rainite.ad.exception.AdException;
import com.rainite.ad.vo.AdUnitRequest;
import com.rainite.ad.vo.AdUnitResponse;

public interface IADUnitService {

    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;
}
