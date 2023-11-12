package com.dating.service.HauNH;

import com.dating.model.HauNH.PackageTypes;
import com.dating.repository.HauNH.IPackageDetailRepository;
import com.dating.repository.HauNH.IPackageTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PackageTypesService implements IPackageTypesService{
    @Autowired
    private IPackageTypesRepository packageTypesRepository;
    @Override
    public List<PackageTypes> findAll() {
        return packageTypesRepository.findAll();
    }
}
