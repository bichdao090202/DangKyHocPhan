package vn.edu.iuh.fit.ketquahoctapservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.ketquahoctapservice.repositories.HocPhanRepository;
import vn.edu.iuh.fit.ketquahoctapservice.repositories.KetQuaHocKyRepository;
import vn.edu.iuh.fit.ketquahoctapservice.repositories.KetQuaHocPhanRepository;

@Service
public class KetQuaHocTapService {
    @Autowired
    private KetQuaHocPhanRepository ketQuaHocPhanRepository;
    @Autowired
    private KetQuaHocKyRepository ketQuaHocKyRepository;
    @Autowired
    private HocPhanRepository hocPhanRepository;


}
