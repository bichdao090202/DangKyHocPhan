package vn.edu.iuh.fit.ketquahoctapservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.ketquahoctapservice.model.HocPhan;
import vn.edu.iuh.fit.ketquahoctapservice.repositories.HocPhanRepository;

@Service
public class HocPhanService {
    @Autowired
    private HocPhanRepository hocPhanRepository;

    public void createBanSaoHocPhan(HocPhan hocPhan) {
        hocPhanRepository.save(hocPhan);
    }

    public HocPhan getHocPhanById(long id) {
        return hocPhanRepository.findById(id).orElse(null);
    }

    public boolean deleteHocPhan(long id) {
        if (!hocPhanRepository.existsById(id))
            return false;   //không tìm thấy id
        hocPhanRepository.deleteById(id);
        return true;
    }

}
