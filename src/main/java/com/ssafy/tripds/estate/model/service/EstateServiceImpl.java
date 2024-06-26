package com.ssafy.tripds.estate.model.service;

import com.ssafy.tripds.estate.model.dto.EstateDto;
import com.ssafy.tripds.estate.model.dto.EstateInterestDto;
import com.ssafy.tripds.estate.model.dto.EstatePlannerDto;
import com.ssafy.tripds.estate.model.mapper.EstateMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstateServiceImpl implements EstateService {

    private final EstateMapper estateMapper;

    // 부동산 (공통) //
    @Override
    public EstateDto getEstateDetail(String registerNumber) {
        try{
            return estateMapper.getEstateDetail(registerNumber);
        }
        catch (Exception e){
            log.error("exception = {}" ,e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public List<EstateDto> getEstateInfoByRegisterNumbers(List<String> registerNumberList) {
        try{
            return estateMapper.getEstateInfoByRegisterNumbers(registerNumberList);
        }
        catch (Exception e){
            log.error("exception = {}" ,e);
            throw new RuntimeException(e);
        }
    }

    // 관심부동산 //
    @Transactional
    @Override
    public int insertEstateInterest(EstateInterestDto estateInterestDto) {
        try{
            return estateMapper.insertEstateInterest(estateInterestDto);
        }
        catch (Exception e){
            log.error("exception = {}" ,e);
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public List<String> selectEstateInterestByMemberId(Long memberId) {
        try{
            return estateMapper.selectEstateInterestByMemberId(memberId);
        }
        catch (Exception e){
            log.error("exception = {}" ,e);
            throw new RuntimeException(e);
        }
    }

    // 부동산 플래너 //
    @Transactional
    @Override
    public int insertEstatePlanner(EstatePlannerDto estatePlannerDto) {
        try{
            return estateMapper.insertEstatePlanner(estatePlannerDto);
        }
        catch (Exception e){
            log.error("exception = {}" ,e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> selectEstatePlannerByMemberId(Long memberId) {
        try{
            return estateMapper.selectEstatePlannerByMemberId(memberId);
        }
        catch (Exception e){
            log.error("exception = {}" ,e);
            throw new RuntimeException(e);
        }
    }
}
