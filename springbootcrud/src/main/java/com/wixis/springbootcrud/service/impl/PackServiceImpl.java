package com.wixis.springbootcrud.service.impl;

import com.wixis.springbootcrud.dto.PackDTO;
import com.wixis.springbootcrud.entity.pack;
import com.wixis.springbootcrud.exception.ValidateException;
import com.wixis.springbootcrud.repo.PackRepo;
import com.wixis.springbootcrud.service.PackService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Isuri Disanayaka
 * @date:30/08/2021
 * @since : 0.0.1
 **/
@Service
@Transactional
public class PackServiceImpl implements PackService {
    @Autowired
    private PackRepo packRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void addPackage(PackDTO dto) {
        if (packRepo.existsById(dto.getPId())) {
            throw new ValidateException("Package Already Exist");
        }
        packRepo.save(mapper.map(dto, pack.class));

    }

    @Override
    public boolean deletePackage(String id) {
        if (!packRepo.existsById(id)) {
            throw new ValidateException("No Package for Delete..!");
        }
        packRepo.deleteById(id);

        return false;
    }

    @Override
    public PackDTO searchPackage(String id) {
        Optional<pack> pack = packRepo.findById(id);
        if (pack.isPresent()) {
            return mapper.map(pack.get(), PackDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<PackDTO> getAllPackages() {
        List<pack> all = packRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<PackDTO>>() {
        }.getType());
    }

    @Override
    public void updatePackage(PackDTO dto) {
        if (packRepo.existsById(dto.getPId())) {
           packRepo.save(mapper.map(dto,pack.class));

        }
    }
}
