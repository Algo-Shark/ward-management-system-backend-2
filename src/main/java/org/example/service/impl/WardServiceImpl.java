package org.example.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.dto.WardDto;
import org.example.entity.Ward;
import org.example.repository.WardRepository;
import org.example.service.WardService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WardServiceImpl implements WardService {
    final WardRepository wardRepository;
    ModelMapper modelMapper;
    @Bean
    public void set(){
        this.modelMapper = new ModelMapper();
    }
    @Override
    public WardDto addWard(WardDto wardDto) {
        Ward ward = modelMapper.map(wardDto,Ward.class);
        if(ward!=null){
            Ward ward1 = wardRepository.save(ward);
            ward1.setWardId(ward.generateWardId());
            wardRepository.save(ward1);
            WardDto wardDto1 = modelMapper.map(ward1,WardDto.class);
            return wardDto1;
        }
        return null;
    }

    @Override
    public String generateWardId() {
        Long id = wardRepository.findMaxId();
        if(id!=null){
            ++id;
            return "WD"+id;
        }else {
            return "WD"+1;
        }
    }
}
