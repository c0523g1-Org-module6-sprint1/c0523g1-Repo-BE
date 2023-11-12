package com.dating.service.HauNH;

import com.dating.model.HauNH.PackageDetail;
import com.dating.repository.HauNH.IPackageDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PackageDetailService implements IPackageDetailService{
    @Autowired
    private IPackageDetailRepository packageDetailRepository;
    @Override
    public List<PackageDetail> findAll() {
        return packageDetailRepository.findAll();
    }
}
