package com.dating.service.update_account;

import com.dating.dto.update_account.PackageDto;
import com.dating.model.update_account.PackageTypes;

import java.util.List;

public interface IPackageTypesService {
    List<PackageTypes> findAll();
    List<PackageDto> findAllPackageAccount();

}
