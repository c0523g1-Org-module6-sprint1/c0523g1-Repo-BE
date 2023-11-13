package com.dating.service.update_account;

import com.dating.model.update_account.PackageTypes;
import com.dating.repository.update_account.IPackageTypesRepository;
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
